package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDepartamentoDAO;
import com.example.demo.dto.Departamento;

@Service
public class DepartamentoServices implements IDepartamentoServices {
	
	@Autowired
	IDepartamentoDAO deptDao;

	@Override
	public List<Departamento> listaDepartamentos() {
		return deptDao.findAll();
	}

	@Override
	public Departamento actualizaDepartamento(Departamento dept) {
		return deptDao.save(dept);
	}

	@Override
	public Departamento guardaDepartamento(Departamento dept) {
		return deptDao.save(dept);
	}

	@Override
	public Departamento ubicaPorID(int id) {
		return deptDao.findById(id).get();
	}

	@Override
	public void eliminaDepartamento(int id) {
		deptDao.deleteById(id);;
	}

}
