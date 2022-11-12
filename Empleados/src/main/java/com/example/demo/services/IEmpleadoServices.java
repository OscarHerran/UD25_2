package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Empleado;

public interface IEmpleadoServices {

	public List<Empleado> totalEmpleados();
	public Empleado guardaEmpleado(Empleado emple);
	public Empleado actualizaEmpelado(Empleado emple);
	public Empleado ubicaPorID(String dni);
	public void eliminaEmpleado(String dni);
}
