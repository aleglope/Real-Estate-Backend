/*package com.ipartek.springboot.backend.apirest.models.storage;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;

public interface IStorageService {
	
	//Metodo auxiliar para preparar todo lo necesario
	//para la subida de archivos
	void init() throws IOException;
	
	//Con este metodo almacenaremos FISICAMENTE
	//el archivo en la carpeta de destino (mediafiles que esta definida en application-properties)
	String store(MultipartFile file, long idInmueble) throws RuntimeException;
	
	Resource joResource(String filename);
	
	
}*/
