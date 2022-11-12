package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Departamento;

public interface IDepartamentoServices {
	
	public List<Departamento> listaDepartamentos();
	public Departamento actualizaDepartamento(Departamento dept);
	public Departamento guardaDepartamento(Departamento dept);
	public Departamento ubicaPorID(int id);
	public void eliminaDepartamento(int id);
}
