package com.ipartek.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.springboot.backend.apirest.models.dao.IUsuarioDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Inmueble;
import com.ipartek.springboot.backend.apirest.models.entity.Usuario;

@Service
public class USuarioServiceImpl implements IGeneralService<Usuario> {
	
	//Una de las principales caracteristicas de un @Service
	//es que sus atributos sueles ser DAO(Repositorios)
	@Autowired
	private IUsuarioDAO usuarioDAO;
	//usuarioDAO automatica y magicamente tiene los metodos IMPLEMENTADOS de
	//CrudRepository
	//Quien ha implementado esos metodos y donde han sido implementados: la implementacion
	//la ha hecho hibernate en el contexto de Spring. Es ahi donde reside toda la logica
	//de negocio SQL
	
	@Override
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public List<Usuario> findAllActive() {
		
		return usuarioDAO.findByActivo(1);
	}

	@Override
	public Usuario findById(Long id) {
		
		//sustituir el null que devuelve el metodo orElse por un new Usuario??
		return usuarioDAO.findById(id).orElse(null);

	}

	@Override
	public Usuario save(Usuario item) {
		
		//el usuario que llega aqui
		//lo hace con el password sin hashear
		//es decir tal y como lo escribio en el formulario de registro
		//Seria aqui el sitio ideal para hashearlo???
		
		return usuarioDAO.save(item);
		//Si el usuario llega con id es un update
		//Si el usuario llega sin id es un create
		
	}

	@Override
	public void deleteById(long id) {
		
		usuarioDAO.deleteById(id);
		
	}

	
	
}
