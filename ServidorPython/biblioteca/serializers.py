from rest_framework.serializers import ModelSerializer
from .models import Libro


class LibroSerializer(ModelSerializer):
    class Meta:
        model = Libro
        fields = '__all__'