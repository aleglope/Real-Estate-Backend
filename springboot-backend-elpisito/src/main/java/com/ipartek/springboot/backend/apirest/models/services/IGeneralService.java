package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;


public interface IGeneralService<T> {
	//Creamos unos metodos abstractos basados en el CrudRepository por arquitectura
	//Podemos elegir los que nos interesen (no hace falta crear todos)
	//Tambien podemos añadir metodos personalizados //es decir que no esten en el CrudRepository
	
	List<T> findAll();
	List<T> findAllActive();
	T findById(Long id);
	T save(T item);
	void deleteById(long id);
	

}
