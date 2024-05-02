from rest_framework import serializers
from schedule_delivery.models import Library, Route, Delivery, Car, DeliveryPack

class LibrarySerializer(serializers.Serializer):
    id = serializers.IntegerField()
    name = serializers.CharField(max_length=64, min_length=0, required=True,
                                 error_messages={'required': 'library name required',
                                                 'max_length': 'the max length of library name is 64'})
    city = serializers.CharField(max_length=64, min_length=0, required=True,
                                 error_messages={'required': 'library name required',
                                                 'max_length': 'the max length of city name is 64'})
    address = serializers.CharField(max_length=256, min_length=0, required=True,
                                    error_messages={'required': 'library name required',
                                                    'max_length': 'the max length of address name is 256'})

    class Meta:
        model = Library
        fields = "__all__"
        extra_kwargs = {}


class RouteSerializer(serializers.Serializer):
    id = serializers.IntegerField()
    start = serializers.IntegerField()
    end = serializers.IntegerField()
    distance = serializers.IntegerField()
    minutes = serializers.IntegerField()
    class Meta:
        model = Route
        fields = "__all__"
        extra_kwargs = {}

class DeliverySerializer(serializers.Serializer):
    id = serializers.IntegerField()
    start = serializers.IntegerField()
    end = serializers.IntegerField()
    books = serializers.IntegerField()
    class Meta:
        model = Delivery
        fields = "__all__"
        extra_kwargs = {}

class CarSerializer(serializers.Serializer):
    id = serializers.IntegerField()
    base = serializers.IntegerField()
    capability = serializers.IntegerField()
    class Meta:
        model = Car
        fields = "__all__"
        extra_kwargs = {}


class DeliveryPackSerializer(serializers.Serializer):
    id = serializers.IntegerField(default=None)
    libraries = LibrarySerializer(read_only=False, many=True)
    routes = RouteSerializer(read_only=False, many=True)
    deliveries = DeliverySerializer(read_only=False, many=True)
    cars = CarSerializer(read_only=False, many=True)

    class Meta:
        model = DeliveryPack
        fields = "__all__"
        extra_kwargs = {}
