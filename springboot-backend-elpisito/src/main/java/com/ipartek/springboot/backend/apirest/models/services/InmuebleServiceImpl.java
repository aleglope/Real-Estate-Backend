package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.springboot.backend.apirest.models.dao.IInmuebleDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Inmueble;


@Service
public class InmuebleServiceImpl implements IInmuebleService {
	
	@Autowired
	private IInmuebleDAO inmuebleDAO;

	@Override
	public List<Inmueble> findAll() {
		return (List<Inmueble>) inmuebleDAO.findAll();
	}

	@Override
	public List<Inmueble> findAllActive() {
		//EL TRABAJO LO HACE EL SERVIDOR Y ESO NO ESTÁ BIEN...
		/*return findAll().stream()
				.filter(i ->  i.getActivo().equals(1))
				.toList();	*/
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
	public void deleteById(Long id) {
		inmuebleDAO.deleteById(id);
		
	}
	

	@Override
	public List<Inmueble> findAllPortada() {
		return inmuebleDAO.findByActivoAndPortada(1, 1);
	}

	/*@Override
	public List<Inmueble> finder() {
	
		inmuebleDAO.findByTipoAndPoblacionAndOperacionAndActivo(null, null, null, null)
	}*/

}
