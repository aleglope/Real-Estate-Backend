package com.ipartek.springboot.backend.apirest.storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ipartek.springboot.backend.apirest.models.dao.IImagenDAO;
import com.ipartek.springboot.backend.apirest.models.dao.IInmuebleDAO;
import com.ipartek.springboot.backend.apirest.models.entity.Imagen;
import com.ipartek.springboot.backend.apirest.models.entity.Inmueble;


import jakarta.annotation.PostConstruct;




@Service
public class StorageServiceImpl implements IStorageService {
	
	@Autowired
	private IImagenDAO imagenDAO;

	
	@Autowired
	private IInmuebleDAO inmuebleDAO;
	
	//Con esta propiedad estamos indicando
	//que la propiedad definida en "media.location" en el archivo
	//"application-properties" es la en la que queremos albergar
	//los archivos que subamos...
	@Value("${media.location}")
	private String mediaLocation;
	
	//Este objeto de tipo Path representará
	//la ruta raiz de almacenamiento
	private Path rootLocation;
	
	
	
	
	

	@Override
	@PostConstruct //Esta notación ejecuta este método en el momento en que la clase se instancia
	public void init() throws IOException {
		//Inicializamos la ruta de almacenamiento
		rootLocation = Paths.get(mediaLocation);
		Files.createDirectories(rootLocation);
		
	}

	@Override
	public String store(MultipartFile file, Long idInmueble) throws RuntimeException {
		
		
		try {

		//EN ESTE MÉTODO VAMOS A BIFURCAR LA TAREA EN DOS FASES:
		//1 FASE) VA A TENER VARIOS PASOS (0,1,2,3,4) Y VAN A CONSISTIR EN CREAR UN NOMBRE DE ALMACENAMIENTO
		//PARA EL ARCHIVO FÍSICO Y LA SUBIDA REAL DE ESE ARCHIVO FÍSICO A UN DIRECTORIO DEL SERVIDOR
		//2 FASE) VA A CONSISTIR EN CREAR EL REGISTRO EN AL BBDD (PASO 5)
		
		//////////////////////////////////////////////////////////////////////
		//FASE 1
		//////////////////////////////////////////////////////////////////////
		
		// PASO 0: Verificamos si el MultipartFile está vacío
		if(file.isEmpty()) {
			throw new RuntimeException("No es posible almacenar un archivo vacío");
		}
		
		//PASO 1: Vamos a conseguir la parte del tipo de archivo. Ejemplo: ".jpg", ".pdf"
		//https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		//El método getContentType nos devuelve el tipo MIME
		
		String fileContentType =  file.getContentType();//"(image/jpeg)", "(application/pdf)"
		
		String tipo = "." + fileContentType.substring(fileContentType.lastIndexOf("/") + 1);//.jpg, .pdf
		
		if(tipo.equals(".jpeg")) {
			tipo = ".jpg";
		}
		
		//Si deseamos completar-matizar el hecho de subir otros tipos de archivos
		//...no dejar subir mas que archivos jpg...cualquier otro matiz "de filtro"
		//debemos programarlo aquí...por ejemplo no deseamos subir archivos .pdf...
		
		if(tipo.equals(".pdf")){
			throw new RuntimeException("No se pueden subir archivos PDF");
		}
		
		//PASO 2: Vamos a crear el nombre del archivo basándonos en la clase Calendar
		 String filename = String.valueOf( Calendar.getInstance().getTimeInMillis());//765645464848884
		 filename = filename.concat(tipo);//"765645464848884.jpg"
		 
		 //PASO 3: Añadimos el String filename a la ruta prefijada de destino
		 //de almacenamiento
		 
		  Path destinationFile =  rootLocation.resolve(Paths.get(filename));
		  
		  //PASO 4: Movemos el archivo FÍSICAMENTE a su destino final
		  
		  
			try(
					
					InputStream inputStream = file.getInputStream()
					
					
					){
				
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
				
				}
		
			//EN ESTE PUNTO EL ARCHIVO FÍSICO YA ESTÁ SUBIDO AL DIRECTORIO mediafiles
			
			//////////////////////////////////////////////////////////////////////
			//FASE 2
			//////////////////////////////////////////////////////////////////////
			
			//PASO 5: Vamos a crear la notación en la BBDD
			//////////////////////////////////////////////////////////////////////
			//PREFERIMOS SUBIR PRIMERO LA IMAGEN FÍSICAMENTE Y POSTERIORMENTE
			//CREAR LA NOTACIÓN EN LA BBDD PORQUE SI LA NOTACIÓN NO SE CREA (ALGUN ERROR)
			//SOLO TENDRÉ, COMO CONSECUENCIA (COMO MAL MAYOR) UNA IMAGEN FÍSICA NO VINCULADA
			//A CAMBIO DE TENER UN REGISTRO ERRÓNEO EN LA BBDD
			//////////////////////////////////////////////////////////////////////
			
			Imagen imagen = new Imagen();
			Inmueble inmueble = inmuebleDAO.findById(idInmueble).orElse(null);
			imagen.setNombre(filename);
			imagen.setInmueble(inmueble);
			
			imagenDAO.save(imagen);
			
			////////////////////////////////////////////////////////////////////////
			return filename;
			////////////////////////////////////////////////////////////////////////e
			
			
			
		}catch(IOException e) {
			
			throw new RuntimeException("Fallo al almacenar el archivo");
		}
			
			
			
		
	}
	
	
	

	@Override
	public Resource loadAsResource(String filename) {
		//Obtenemos el path real del archivo
		Path filePath = rootLocation.resolve(Paths.get(filename));
		
		
		try {
			
			Resource resource = new UrlResource(filePath.toUri());
			
			if(resource.exists() || resource.isReadable()) {
				
				return resource;
		
			}else{
				
				throw new RuntimeException("No se puede leer el archivo " + filename);
			}
			
			
		}catch(MalformedURLException e) {
			
			throw new RuntimeException("No se puede leer el archivo " + filename);
		}
		
		
	}
	
	
	

}
