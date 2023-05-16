from django.db import models

class Libro(models.Model):
    titulo=models.CharField(max_length=30)
    descripcion=models.CharField(max_length=2500)
    precio=models.FloatField()
    cantidad=models.IntegerField()
    categoria=models.CharField(max_length=20)
    autor=models.CharField(max_length=50)
    editorial=models.CharField(max_length=100)


# {
#     "titulo": "Eso",
#     "descipcion": "¿Quién o qué mutila y mata a los niños de un pequeño pueblo norteamericano?¿Por qué llega cíclicamente el horror a Derry en forma de un payaso siniestro que va sembrando la destrucción a su paso? Esto es lo que se proponen averiguar los protagonistas de esta novela. Tras veintisiete años de tranquilidad y lejanía, una antigua promesa infantil les hace volver al lugar en el que vivieron su infancia y juventud como una terrible pesadilla. Regresan a Derry para enfrentarse con su pasado y enterrar definitivamente la amenaza que los amargó durante su niñez. Saben que pueden morir, pero son conscientes de que no conocerán la paz hasta que aquella cosa sea destruida para siempre es una de las novelas más ambiciosas de Stephen King, con la que ha logrado perfeccionar de un modo muy personal las claves del género de terror.",
#     "precio": 450.00,
#     "cantidad": 30,
#     "categoria": "Terror",
#     "autor": "Stephen King",
#     "editorial": "Penguin Random House Grupo Editorial SA de CV"
# }