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

# @api_view(['PUT'])
# def putUser(request, pk):
#     data = request.data
#     user = User.objects.get(id=pk)
#     serializer = UsersSerializer(instance=user, data = data)
#     # if(serializer.is_valid()):
#     #     serializer.save()
#     try:
#         if(serializer.is_valid()):
#             serializer.save()
#     except Exception as e:
#         print(e)
#     return Response(serializer.data)
    
# # @api_view(['DELETE'])
# # def deleteEmployee(request, pk):
# #     employee = Employee.objects.get(id=pk)
# #     employee.delete()
# #     return Response('Empleado eliminado')


# @api_view(['GET'])
# def getProducto(request):
#     productos = Producto.objects.all()
#     serializer = ProductoSerializer(productos, many = True)
#     return Response(serializer.data)


# @api_view(['POST'])
# def postProducto(request):
#     data = request.data
#     producto = Producto.objects.create(
#         nombre = data['nombre'],
#         descripcion = data['descripcion'],
#         precio = data['precio'],
#         cantidad = data['cantidad'],
#         categoria = data['categoria'],
#         imagen = data['imagen']
#     )
        
#     serializer = ProductoSerializer(producto, many = False)
#     return Response(serializer.data)