package com.ipartek.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.ipartek.springboot.backend.apirest.models.entity.Usuario;

@Repository
public interface IUsuarioDAO extends CrudRepository<Usuario,Long> {
	
	
	//DERIVED QUERY METHODS
	List<Usuario>findByActivo(Integer activo);
	

}
