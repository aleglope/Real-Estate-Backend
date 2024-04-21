package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;


public interface IGeneralService<T> {
	
	//Creamos unos métodos abstractos basados en el CrudRepository por arquitectura
	//Podemos elegir los que nos interesen (no hace falta crear todos)
	//También podemos añadir métodos personalizados (es decir que no estén en el CrudRepository)
	
	List<T> findAll();
	List<T> findAllActive();
	T findById(Long id);
	T save(T item);
	void deleteById(Long id);
	

}
