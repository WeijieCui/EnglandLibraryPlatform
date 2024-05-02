from django.db import models


class Library(models.Model):
    id = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=64)
    city = models.CharField(max_length=64)
    address = models.CharField(max_length=256)
    delivery_pack = models.ManyToOneRel(field='libraries', to=True, field_name='libraries')

    class Meta:
        ordering = ['id']


class Route(models.Model):
    id = models.IntegerField(primary_key=True)
    start = models.IntegerField()
    end = models.IntegerField()
    distance = models.IntegerField()
    minutes = models.IntegerField()
    delivery_pack = models.ManyToOneRel(field='routes', to=True, field_name='routes')

    class Meta:
        ordering = ['id']


class Delivery(models.Model):
    id = models.IntegerField(primary_key=True)
    start = models.IntegerField()
    end = models.IntegerField()
    books = models.IntegerField()
    delivery_pack = models.ManyToOneRel(field='deliveries', to=True, field_name='deliveries')

    class Meta:
        ordering = ['id']


class Car(models.Model):
    id = models.IntegerField(primary_key=True)
    base = models.IntegerField()
    capability = models.IntegerField()
    delivery_pack = models.ManyToOneRel(field='cars', to=True, field_name='cars')

    class Meta:
        ordering = ['id']


class DeliveryPack(models.Model):
    id = models.IntegerField(primary_key=True)
    libraries = None
    routes = None
    deliveries = None
    cars = None

    class Meta:
        ordering = ['id']
