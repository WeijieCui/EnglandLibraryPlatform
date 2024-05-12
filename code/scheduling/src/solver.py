from datetime import datetime

from flask import current_app
from ortools.constraint_solver import routing_enums_pb2
from ortools.constraint_solver import pywrapcp

IMG_PATH = 'static/img/'


class Solver:
    def __init__(self, model: dict):
        self.model = model

    def solve(self):
        # Create the routing index manager.
        manager = pywrapcp.RoutingIndexManager(
            len(self.model['distance_matrix']), self.model['num_vehicles'], self.model['depot']
        )
        # Create Routing Model.
        routing = pywrapcp.RoutingModel(manager)

        def distance_callback(from_index, to_index):
            """Returns the distance between the two nodes."""
            # Convert from routing variable Index to distance matrix NodeIndex.
            from_node = manager.IndexToNode(from_index)
            to_node = manager.IndexToNode(to_index)
            return self.model['distance_matrix'][from_node][to_node]

        transit_callback_index = routing.RegisterTransitCallback(distance_callback)
        routing.SetArcCostEvaluatorOfAllVehicles(transit_callback_index)
        # Add Distance constraint.
        dimension_name = 'Distance'
        routing.AddDimension(
            transit_callback_index,
            0,  # no slack
            3000,  # vehicle maximum travel distance
            True,  # start cumul to zero
            dimension_name,
        )
        distance_dimension = routing.GetDimensionOrDie(dimension_name)
        distance_dimension.SetGlobalSpanCostCoefficient(100)
        # Define Transportation Requests.
        for request in self.model['pickups_deliveries']:
            pickup_index = manager.NodeToIndex(request[0])
            delivery_index = manager.NodeToIndex(request[1])
            routing.AddPickupAndDelivery(pickup_index, delivery_index)
            routing.solver().Add(
                routing.VehicleVar(pickup_index) == routing.VehicleVar(delivery_index)
            )
            routing.solver().Add(
                distance_dimension.CumulVar(pickup_index)
                <= distance_dimension.CumulVar(delivery_index)
            )

        # Setting first solution heuristic.
        search_parameters = pywrapcp.DefaultRoutingSearchParameters()
        search_parameters.first_solution_strategy = (
            routing_enums_pb2.FirstSolutionStrategy.PARALLEL_CHEAPEST_INSERTION
        )

        # Solve the problem.
        solution = routing.SolveWithParameters(search_parameters)
        return self.wrap_result(self.model, manager, routing, solution)

    @staticmethod
    def wrap_result(data, manager, routing, solution):
        """wrap solution"""
        total_distance = 0
        paths = []
        plan_output = ''
        for vehicle_id in range(data['num_vehicles']):
            index = routing.Start(vehicle_id)
            plan_output = f'Route for vehicle {vehicle_id}:\n'
            route_distance = 0
            path = []
            while not routing.IsEnd(index):
                plan_output += f' {manager.IndexToNode(index)} -> '
                previous_index = index
                index = solution.Value(routing.NextVar(index))
                if index < len(data['distance_matrix']) and previous_index < len(data['distance_matrix']):
                    path.append((previous_index, index))
                route_distance += routing.GetArcCostForVehicle(
                    previous_index, index, vehicle_id
                )
            plan_output += f'{manager.IndexToNode(index)}\n'
            plan_output += f'Distance of the route: {route_distance}m\n'
            total_distance += route_distance
            paths.append(path)
        # example usage:
        nodes = [i for i in range(len(data['distance_matrix']))]  # [0, 1, 2, 3, 4, 5]

        edges = [(a, b) for a in range(len(data['distance_matrix']))
                 for b in range(len(data['distance_matrix'][a]))
                 if data['distance_matrix'][a][b] != 0]
        # if it is debug mode, plot the graph
        file_name = ''
        if current_app.config['SAVE_PICTURE']:
            file_name = '{}{}_{}.png'.format(IMG_PATH, data.get('name'), datetime.now().strftime('%Y%m%d%H%M%S'))
            Solver.plot_graph(file_name, nodes, edges, paths)
        return {
            'total_distance': total_distance,
            'paths': paths,
            'plan_output': plan_output,
            'url': file_name if current_app.config['SAVE_PICTURE'] else '',
        }

    @staticmethod
    def plot_graph(file_name, nodes, edges, paths):
        try:
            import matplotlib.pyplot as plt
            import networkx as nx
        except ImportError:
            print('Matplotlib and NetworkX are required to plot the graph')
            return None
        g = nx.Graph()
        path_colors = ['r', 'g', 'b', 'y', 'm', 'c', 'k']

        for node in nodes:
            g.add_node(node)

        for edge in edges:
            g.add_edge(*edge)

        pos = nx.spring_layout(g)  # positions for all nodes

        # nodes
        nx.draw_networkx_nodes(g, pos, node_size=100)

        # edges
        nx.draw_networkx_edges(g, pos, edgelist=edges, width=1, alpha=0.2, edge_color='b', style='dashed')

        # labels
        nx.draw_networkx_labels(g, pos, font_size=5, font_family='sans-serif')
        for i, path in enumerate(paths):
            nx.draw_networkx_edges(g, pos, edgelist=path, width=1, alpha=1,
                                   edge_color=path_colors[i % len(path_colors)],
                                   style='solid')
        plt.savefig(file_name, format='png', dpi=300)
