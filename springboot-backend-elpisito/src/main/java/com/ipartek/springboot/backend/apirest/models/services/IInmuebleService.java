package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;

import com.ipartek.springboot.backend.apirest.models.entity.Inmueble;

public interface IInmuebleService extends IGeneralService<Inmueble>{
	
	
	List<Inmueble> findAllPortada();
	//List<Inmueble> finder();

}
