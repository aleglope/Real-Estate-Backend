package com.ipartek.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.springboot.backend.apirest.models.entity.Provincia;

@Repository
public interface IProvinciaDAO extends CrudRepository<Provincia, Long>{

	//DERIVED QUERY METHODS
	List<Provincia>findByActivo(Integer activo);
}
