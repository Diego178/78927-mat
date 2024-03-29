package com.uv.practica05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Practica05Application {

	ArrayList<Persona> p = new ArrayList<Persona>();

	public static void main(String[] args) {
		SpringApplication.run(Practica05Application.class, args);
	}

	@RequestMapping("/")
	public String name() {
		return "Hola mundo";
	}

	@RequestMapping("/adios")
	public String name1() {
		return "Adios mundo";
	}

	@RequestMapping(value= "/personas", method =  RequestMethod.GET)
	public List<Persona> productoGET() {
		return p;
	}

	@RequestMapping(value= "/personas", method =  RequestMethod.POST)
	public String productoPOST(@RequestBody Persona persona) {
		p.add(persona);
		return "200";
	}

	// @RequestMapping("/productos")
	// public ArrayList<String> productos() {
	// 	ArrayList<String> p = new ArrayList<String>();
	// 	p.add("pambazos");
	// 	p.add("coca");
	// 	p.add( "tamales");
	// 	p.add("chetos");
	// 	return p;
	// }

	// @RequestMapping("/productos2")
	// public List<Productos> productos1() {
	// 	List<Productos> lista = new ArrayList<Productos>();
	// 	Productos p0 = new Productos("Pan", 2);
	// 	lista.add(p0);
	// 	Productos p1 = new Productos("Dulce", 2);
	// 	lista.add(p1);
	// 	Productos p2 = new Productos("Chetos", 2);
	// 	lista.add(p2);
	// 	Productos p3 = new Productos("Churritos", 2);
	// 	lista.add(p3);
	// 	return lista;
	// }

	// @RequestMapping(value = "/saludar", method = RequestMethod.GET)
	// public String saludarGET() {
	// 	return "Holaaaa";
	// }

	// @RequestMapping(value = "/saludar", method = RequestMethod.POST)
	// public String saludarPOST() {
	// 	return "Holaaaa post";
	// }

	// @RequestMapping(value = "/recurso/{nombre}", method = RequestMethod.POST)
	// public String saludarPOST(@PathVariable String nombre) {
	// 	return "Holaaaa "+nombre;
	// }

	// @RequestMapping(value = "/recurso/{nombre}", method = RequestMethod.POST)
	// public String saludarPOST(@RequestBody Persona nombre) {
	// 	return "Holaaaa "+nombre;
}

	//curl -X POST -d @p.json http://..../...
	//p.json {"nombre": "....", "color" : "...", "edad": "..."}

