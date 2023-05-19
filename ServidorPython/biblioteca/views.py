from rest_framework.response import Response
from rest_framework.serializers import Serializer
from rest_framework.decorators import api_view
from rest_framework.exceptions import APIException
from .serializers import LibroSerializer

from .models import Libro
    
@api_view(['GET'])
def getLibros(request):
    libro = Libro.objects.all();
    serializer = LibroSerializer(libro, many = True)
    return Response(serializer.data)
    

@api_view(['POST'])
def postLibro(request):
    data = request.data
    user = Libro.objects.create(
        titulo = data['titulo'],
        descripcion = data['descripcion'],
        precio = data['precio'],
        cantidad = data['cantidad'],
        categoria = data['categoria'],
        autor = data['autor'],
        editorial = data['editorial']
    )
        
    serializer = LibroSerializer(user, many = False)
    return Response(serializer.data)
