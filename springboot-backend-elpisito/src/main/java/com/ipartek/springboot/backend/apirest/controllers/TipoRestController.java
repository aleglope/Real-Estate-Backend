package com.ipartek.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.springboot.backend.apirest.models.entity.Tipo;

import com.ipartek.springboot.backend.apirest.models.services.IGeneralService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoRestController {
	
		
	@Autowired
	private IGeneralService<Tipo> tipoService;
	
	
	@GetMapping("/tipos")
	public List<Tipo> findAll() {
		
		
		return tipoService.findAll();
		
	}
	
	
	@GetMapping("/tipos-activos")
	public List<Tipo> findAllActive(){
		
		return tipoService.findAllActive();
	}
	
	
	
	
	@GetMapping("/tipo/{id}")
	public Tipo findById(@PathVariable Long id) {
		
		
		return tipoService.findById(id);
		
	}
	
	
	@PostMapping("/tipo")
	public Tipo create(@RequestBody Tipo tipo) {
			
		return tipoService.save(tipo);
	}
	
	
	
	@PutMapping("/tipo")
	public Tipo update(@RequestBody Tipo tipo) {
		
		return tipoService.save(tipo);
	}
	
	
	
	@DeleteMapping("/tipo/{id}")
	public void deleteById(@PathVariable Long id) {
		
		tipoService.deleteById(id);
	}
	


}
