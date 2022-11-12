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

import com.example.demo.dto.Departamento;
import com.example.demo.services.DepartamentoServices;

@RestController
@RequestMapping("/api")
public class DepartamentoController {

	@Autowired
	DepartamentoServices deptServices;
	
	@GetMapping("/departamentos")
	public List<Departamento> listaDepartamentos(){
		return deptServices.listaDepartamentos();
	}
	
	@GetMapping("/departamentos/{id}")
	public Departamento ubicaPorID(@PathVariable (name = "id") int id) {
		return deptServices.ubicaPorID(id);
	}
	
	@PostMapping("/departamentos/add")
	public Departamento guardaDepartamento(@RequestBody Departamento depa) {
		return deptServices.guardaDepartamento(depa);
	}
	
	@PutMapping("/departamento/{id}/actualiza")
	public Departamento actualizaDepartamento(@PathVariable (name = "id") int id, @RequestBody Departamento depa) {
		Departamento deptSEL = new Departamento();
		Departamento deptACTUAL = new Departamento();
		
		deptSEL = deptServices.ubicaPorID(id);
		deptSEL.setNombre(depa.getNombre());
		deptSEL.setPresupuesto(depa.getPresupuesto());
		
		deptACTUAL = deptSEL;
		
		return deptACTUAL;
	}
	
	@DeleteMapping("/departamentos/{id}/borra")
	public void eliminaDepartamento(@PathVariable (name = "id") int id) {
		deptServices.eliminaDepartamento(id);
	}
}
