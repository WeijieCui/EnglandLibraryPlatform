from cplex_solver import CplexSolver

solver = CplexSolver(name="Simple Model")
x1 = solver.add_int_var(lb=3, ub=5, name='x1')
x2 = solver.add_int_var(lb=3, ub=12, name='x2')
solver.add_le_constraint((x1, x2), (1, -2), 20, ctname="constraint_1")
solver.maximize(solver.sum([x1, x2]))
solver.solve()
print(solver.get_solution())
