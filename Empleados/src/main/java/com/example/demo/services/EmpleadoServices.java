package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;

@Service
public class EmpleadoServices implements IEmpleadoServices {

	@Autowired
	IEmpleadoDAO empleDAO;
	
	@Override
	public List<Empleado> totalEmpleados() {
		return empleDAO.findAll();
	}

	@Override
	public Empleado guardaEmpleado(Empleado emple) {
		return empleDAO.save(emple);
	}

	@Override
	public Empleado actualizaEmpelado(Empleado emple) {
		return empleDAO.save(emple);
	}

	@Override
	public Empleado ubicaPorID(String dni) {
		return empleDAO.findById(dni).get();
	}

	@Override
	public void eliminaEmpleado(String dni) {
		empleDAO.deleteById(dni);
	}

}
