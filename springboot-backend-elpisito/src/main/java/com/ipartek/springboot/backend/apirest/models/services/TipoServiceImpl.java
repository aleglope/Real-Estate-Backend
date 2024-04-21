package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.springboot.backend.apirest.models.dao.ITipoDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Tipo;


@Service
public class TipoServiceImpl implements IGeneralService<Tipo> {

	
	@Autowired
	private ITipoDAO tipoDAO;
	
	
	@Override
	public List<Tipo> findAll() {
		
		return (List<Tipo>) tipoDAO.findAll();
	}

	@Override
	public List<Tipo> findAllActive() {
		
		return tipoDAO.findByActivo(1);
		
	}

	@Override
	public Tipo findById(Long id) {
		
		return tipoDAO.findById(id).orElse(null);

	}

	@Override
	public Tipo save(Tipo item) {
		
		return tipoDAO.save(item);		

	}
	
	

	@Override
	public void deleteById(Long id) {

		tipoDAO.deleteById(id);
	}

}
