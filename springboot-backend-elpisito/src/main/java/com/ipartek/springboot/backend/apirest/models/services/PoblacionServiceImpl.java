package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.springboot.backend.apirest.models.dao.IPoblacionDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Poblacion;

@Service
public class PoblacionServiceImpl implements IGeneralService<Poblacion> {

	@Autowired
	private IPoblacionDAO poblacionDAO;

	@Override
	public List<Poblacion> findAll() {

		return (List<Poblacion>) poblacionDAO.findAll();
	}

	@Override
	public List<Poblacion> findAllActive() {
		
		return poblacionDAO.findByActivo(1);
	}

	@Override
	public Poblacion findById(Long id) {
		
		return poblacionDAO.findById(id).orElse(null);
	}

	@Override
	public Poblacion save(Poblacion item) {
		return poblacionDAO.save(item);
	}

	@Override
	public void deleteById(long id) {

		poblacionDAO.deleteById(id);
	}


	
	
	
	
	
	
	
	
}
