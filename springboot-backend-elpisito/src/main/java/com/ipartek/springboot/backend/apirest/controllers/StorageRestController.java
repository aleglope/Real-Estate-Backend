package com.ipartek.springboot.backend.apirest.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ipartek.springboot.backend.apirest.storage.IStorageService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/media")
public class StorageRestController {
	
	@Autowired
	private IStorageService storageService;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@PostMapping("/upload/{idInmueble}")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile, @PathVariable Long idInmueble ) {
		
		Map<String,Object> response = new HashMap<>();
		String url = null;
		
		try {
			//Almacenamos el archivo utilizando el servicio de almacenamiento...
			String filename = storageService.store(multipartFile, idInmueble);
			
			//EL ARCHIVO FÍSICO YA ESTÁ SUBIDO Y LA NOTACIÓN HECHA EN LA TABLA DE LA BBDD
			
			//LO QUE HACEMOS DESDE AQUÍ ES SIMPLEMENTE CONSEGUIR LA URL FINAL COMPLETA DEL ARCHIVO
			//SUBIDO PARA DEVOLVERLO EN EL RESPONSE
			
			//Conseguimos la URL del archivo	
			String host  = request.getRequestURL().toString().replace(request.getRequestURI(), "");
			
			url = ServletUriComponentsBuilder
						.fromHttpUrl(host)  //Añadimos el host "http://localhost:8080"
						.path("/media/file/")  //Añadimos la carpeta en la que se encuentra el recurso "http://localhost:8080/media/file"
						.path(filename) //"http://localhost:8080/media/file/74784845959595.jpg"
						.toUriString();
						
		}catch(RuntimeException e) {
			
			
			response.put("mensaje", "Error al tratar de subir la imagen");
			response.put("error", e.getMessage());
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		Map<String,String> resultado = Map.of("url",url);
		
		return new ResponseEntity<Map<String,String>>(resultado,HttpStatus.OK);
		
		
	}
	
	
	
	@GetMapping("/file/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException{
	
		
		Resource file = storageService.loadAsResource(filename);
		
		String contentType = Files.probeContentType(file.getFile().toPath());
		 
		 return ResponseEntity
				 .ok()
				 .header(HttpHeaders.CONTENT_TYPE,contentType)
				 .body(file);
		 
	
	}
	
	

}
