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

import com.ipartek.springboot.backend.apirest.models.entity.Inmueble;
import com.ipartek.springboot.backend.apirest.models.services.IInmuebleService;


@RestController
@RequestMapping("/api")
public class InmuebleRestController {
	
	
	@Autowired
	private IInmuebleService inmuebleService;
	
	
	@GetMapping("/inmuebles")
	public List<Inmueble> findAll() {
		
		
		return inmuebleService.findAll();
		
	}
	
	
	@GetMapping("/inmuebles-activos")
	public List<Inmueble> findAllActive(){
		
		return inmuebleService.findAllActive();
	}
	
	
	@GetMapping("/inmuebles-portada")
	public List<Inmueble> findAllPortada(){
		
		return inmuebleService.findAllPortada();
	}
	
	
	
	
	@GetMapping("/inmueble/{id}")
	public Inmueble findById(@PathVariable Long id) {
		
		
		return inmuebleService.findById(id);
		
	}
	
	
	@PostMapping("/inmueble")
	public Inmueble create(@RequestBody Inmueble inmueble) {
			
		return inmuebleService.save(inmueble);
	}
	
	
	
	@PutMapping("/inmueble")
	public Inmueble update(@RequestBody Inmueble inmueble) {
		
		return inmuebleService.save(inmueble);
	}
	
	
	
	@DeleteMapping("/inmueble/{id}")
	public void deleteById(@PathVariable Long id) {
		
		inmuebleService.deleteById(id);
	}
	
	
	

}

