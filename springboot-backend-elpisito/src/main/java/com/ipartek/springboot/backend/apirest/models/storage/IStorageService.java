package com.ipartek.springboot.backend.apirest.storage;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;



public interface IStorageService {
	
	//Método auxiliar para preparar todo lo necesario
	//para la subida de archivos
	void init() throws IOException;
	
	//Con este método almacenaremos FISICAMENTE
	//el archivo en la carpeta de destino (mediafiles que está definida en application-properties)
	String store(MultipartFile file, Long idInmueble) throws RuntimeException;
	
	
	Resource loadAsResource(String filename);

}
