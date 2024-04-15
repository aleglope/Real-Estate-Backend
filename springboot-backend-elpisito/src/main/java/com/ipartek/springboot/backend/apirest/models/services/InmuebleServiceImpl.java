package com.ipartek.springboot.backend.apirest.models.services;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.springboot.backend.apirest.models.dao.IInmuebleDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Inmueble;

public class InmuebleServiceImpl implements IGeneralService<Inmueble> {

	
	@Autowired
	private IInmuebleDAO inmuebleDAO;
	
	@Override
	public List<Inmueble> findAll() {

		return (List<Inmueble>) inmuebleDAO.findAll();
	}

	@Override
	public List<Inmueble> findAllActive() {
		//EL TRABAJO LO HACE EL SERVIDOR Y ESO NO ESTA BIEN...
		
		/*return findAll().stream()
			.filter(i -> i.getActivo().equals(1))
			.toList(); */
		//DE ESTA FORMA EL TRABAJO LO HACE LA BBDD
		return inmuebleDAO.findByActivo(1);
	}
	
	@Override
	public Inmueble findById(Long id) {
		
		return inmuebleDAO.findById(id).orElse(null);
	}

	@Override
	public Inmueble save(Inmueble item) {
		return inmuebleDAO.save(item);
	}

	@Override
	public void deleteById(long id) {

		inmuebleDAO.deleteById(id);
	}
	
	@Override
	public List<Inmueble> findAllPortada() {
		
		return inmuebleDAO.findByActivoAndPortada(1, 1);
		
	}
		
	/*@Override
	public List<Inmuebles> finder() {
		
		inmuebleDAO.findByTipoAndPoblacionAndOperacionAndActivo(null, null, null, null)
		
		
	}*/
		
		
	

}
