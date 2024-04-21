package com.ipartek.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ipartek.springboot.backend.apirest.models.entity.Poblacion;

@Repository
public interface IPoblacionDAO extends CrudRepository<Poblacion, Long> {
	
	//DERIVED QUERY METHODS
	List<Poblacion>findByActivo(Integer activo);

}
