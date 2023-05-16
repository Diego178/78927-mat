package com.uv.practica05;

public class Persona{
    String nombre;
    String color;
    String edad;

    
    public Persona(String nombre, String color, String edad) {
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
}