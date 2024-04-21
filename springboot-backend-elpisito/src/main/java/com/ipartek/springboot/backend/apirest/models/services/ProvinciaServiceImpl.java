package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.springboot.backend.apirest.models.dao.IProvinciaDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Provincia;


@Service
public class ProvinciaServiceImpl implements IGeneralService<Provincia>{
	
	@Autowired
	private IProvinciaDAO provinciaDAO;

	@Override
	public List<Provincia> findAll() {
		return (List<Provincia>) provinciaDAO.findAll();
	}

	@Override
	public List<Provincia> findAllActive() {
		return provinciaDAO.findByActivo(1);
	}

	@Override
	public Provincia findById(Long id) {
		return provinciaDAO.findById(id).orElse(null);
	}

	@Override
	public Provincia save(Provincia item) {
		return provinciaDAO.save(item);	
	}

	@Override
	public void deleteById(Long id) {
		provinciaDAO.deleteById(id);
		
	}
	
	
}
