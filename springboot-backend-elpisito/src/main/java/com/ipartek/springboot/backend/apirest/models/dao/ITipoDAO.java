package com.ipartek.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.springboot.backend.apirest.models.entity.Tipo;

@Repository
public interface ITipoDAO extends CrudRepository<Tipo, Long>{

}