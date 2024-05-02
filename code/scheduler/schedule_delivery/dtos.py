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
