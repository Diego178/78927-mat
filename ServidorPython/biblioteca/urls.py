from django.urls import path
from . import views

urlpatterns = [

    ### URLS Libros ###
    path('biblioteca/libros/todos/', views.getLibros), #devuelve todas los libros
    path('biblioteca/libros/', views.postLibro), #postear un libro
    
]