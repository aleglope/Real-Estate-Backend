package com.ipartek.springboot.backend.apirest.models.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.springboot.backend.apirest.models.dao.IUsuarioDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Usuario;



@Service
public class UsuarioServiceImpl implements IGeneralService<Usuario> {
	
	//Una de las principales características de un @Service
	//es que sus atributos suelen ser DAO (Repositorios)
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	//usuarioDAO automática y mágicamente tiene los métodos IMPLEMENTADOS de
	//CrudRepository
	//Quién ha implementado esos métodos y dónde han sido implementados: la implementación
	//la ha hecho hibernate en el contexto de Spring. Es ahí donde reside toda la lógica
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
		
		//sustituir el null que devuelve el método orElse por un new Usuario???
		return usuarioDAO.findById(id).orElse(null);

	}
	
	

	@Override
	public Usuario save(Usuario item) {
		
		//El usuario que llega aquí 
		//lo hace con el password sin hashear
		//es decir tal y como lo escribió en el formulario de registro
		//Sería aquí el sitio ideal para hashearlo???
		return usuarioDAO.save(item);
		//Si el usuario llega con id es un update
		//Si el usuario llega sin id es un create
	
		

	}
	
	

	@Override
	public void deleteById(Long id) {
		
		usuarioDAO.deleteById(id);
		

	}


	

}
