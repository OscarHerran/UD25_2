package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.services.EmpleadoServices;


@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServices empleSERV;
	
	@GetMapping("/empleados")
	public List<Empleado> listaEmpleados(){
		return empleSERV.totalEmpleados();
	}
	
	@PostMapping("/empleados/add")
	public Empleado guardaEmpleado(@RequestBody Empleado emple) {
		return empleSERV.guardaEmpleado(emple);
	}
	
	@GetMapping("/empleados/{dni}")
	public Empleado ubicaPorID(@PathVariable (name = "dni") String dni) {
		return empleSERV.ubicaPorID(dni);
	}
	
	@PutMapping("/empleados/{dni}/actualiza")
	public Empleado actualizaEmpleado(@PathVariable (name = "dni") String dni, @RequestBody Empleado emple) {
		Empleado empleSEL = new Empleado();
		Empleado empleACT = new Empleado();
		
		empleSEL = empleSERV.ubicaPorID(dni);
		empleSEL.setNombre(emple.getNombre());
		empleSEL.setApellidos(emple.getApellidos());
		empleSEL.setDepartamento(emple.getDepartamento());
		
		empleACT = empleSEL;
		
		return empleACT;
	}
	
	@DeleteMapping("/empleados/{dni}/elimina")
	public void eliminaEmpleado(@PathVariable (name = "dni") String dni) {
		empleSERV.eliminaEmpleado(dni);
	}
}
