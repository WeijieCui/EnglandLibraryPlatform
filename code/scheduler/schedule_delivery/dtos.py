class LibraryDto():
    def __init__(self, id, name, city, address):
        self.id = id
        self.name = name
        self.city = city
        self.address = address


class RouteDto():
    def __init__(self, id, start, end, distance, minutes):
        self.id = id
        self.start = start
        self.end = end
        self.distance = distance
        self.minutes = minutes


class DeliveryDto():
    def __init__(self, id, start, end, books):
        self.id = id
        self.start = start
        self.end = end
        self.books = books


class CarDto():
    def __init__(self, id, base, capability):
        self.id = id
        self.base = base
        self.capability = capability


class DeliveryPackDto():
    def __init__(self, id, libraries, routes, deliveries, cars):
        self.id = id
        self.libraries = [LibraryDto(**l) for l in libraries]
        self.routes = [RouteDto(**l) for l in routes]
        self.deliveries = [DeliveryDto(**l) for l in deliveries]
        self.cars = [CarDto(**l) for l in cars]
        self.id2index = {l.id: i for i, l in enumerate(self.libraries)}
        self.index2id = {i: l.id for i, l in enumerate(self.libraries)}

    def to_ortools_model(self):
        lib_count = len(self.libraries)
        distance_matrix = [[0] * lib_count for _ in range(lib_count)]
        for route in self.routes:
            distance_matrix[self.id2index[route.start]][self.id2index[route.end]] = route.distance
            distance_matrix[self.id2index[route.end]][self.id2index[route.start]] = route.distance
        return {
            'id': self.id,
            'distance_matrix': distance_matrix,
            'num_vehicles': len(self.cars),
            'depot': self.cars[0].base,
            'pickups_deliveries': [(d.start, d.end) for d in self.deliveries],
        }
