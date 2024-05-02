from rest_framework import viewsets
from rest_framework.response import Response
from rest_framework.decorators import api_view, action
from schedule_delivery.serializers_validater import DeliveryPackSerializer
from schedule_delivery.dtos import DeliveryPackDto


class SchedulerViewset(viewsets.ViewSet):
    @action(methods=['GET'], detail=False, url_path='hello', url_name='hello')
    def hello(self, request, *args, **kwargs):
        return Response({'hello': 'world'})

    @action(methods=['POST'], detail=False, url_path='schedule', url_name='schedule')
    def schedule(self, request, *args, **kwargs):
        ser = DeliveryPackSerializer(data=request.data)
        if ser.is_valid():
            deliveryPack = DeliveryPackDto(**ser.validated_data)
            print(deliveryPack)
        else:
            print(ser.errors)
        return Response({'hello': 'world'})
