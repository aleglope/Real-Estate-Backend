package com.ipartek.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.springboot.backend.apirest.models.entity.Imagen;

import com.ipartek.springboot.backend.apirest.models.services.IGeneralService;



@RestController
@RequestMapping("/api")
public class ImagenRestController {
	
	@Autowired
	private IGeneralService<Imagen> imagenService;
	
	
	@GetMapping("/imagenes")
	public List<Imagen> findAll() {
		
		
		return imagenService.findAll();
		
	}
	
	
	@GetMapping("/imagenes-activas")
	public List<Imagen> findAllActive(){
		
		return imagenService.findAllActive();
	}
	
	
	
	
	@GetMapping("/imagen/{id}")
	public Imagen findById(@PathVariable Long id) {
		
		
		return imagenService.findById(id);
		
	}
	
	
	@PostMapping("/imagen")
	public Imagen create(@RequestBody Imagen imagen) {
			
		return imagenService.save(imagen);
	}
	
	
	
	@PutMapping("/imagen")
	public Imagen update(@RequestBody Imagen imagen) {
		
		return imagenService.save(imagen);
	}
	
	
	
	@DeleteMapping("/imagen/{id}")
	public void deleteById(@PathVariable Long id) {
		
		imagenService.deleteById(id);
	}
	
	
	

}
