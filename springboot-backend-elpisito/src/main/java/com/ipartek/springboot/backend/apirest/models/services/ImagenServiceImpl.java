package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.springboot.backend.apirest.models.dao.IImagenDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Imagen;

@Service
public class ImagenServiceImpl implements IGeneralService<Imagen> {
	
	@Autowired
	private IImagenDAO imagenDAO;
	

	@Override
	public List<Imagen> findAll() {
		
		return (List<Imagen>) imagenDAO.findAll();
	}

	@Override
	public List<Imagen> findAllActive() {
		
		return imagenDAO.findByActivo(1);
	
	}

	@Override
	public Imagen findById(Long id) {
		return imagenDAO.findById(id).orElse(null);
	}

	@Override
	public Imagen save(Imagen item) {
		
		return imagenDAO.save(item);	
	}
	

	@Override
	public void deleteById(Long id) {
		imagenDAO.deleteById(id);
		
	}

}
