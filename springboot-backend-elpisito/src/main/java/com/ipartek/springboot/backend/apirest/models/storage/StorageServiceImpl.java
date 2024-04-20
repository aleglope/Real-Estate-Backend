/*package com.ipartek.springboot.backend.apirest.models.storage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.web.multipart.MultipartFile;

import com.ipartek.springboot.backend.apirest.models.dao.IImagenDAO;
import com.ipartek.springboot.backend.apirest.models.services.IInmuebleService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;


public class StorageServiceImpl implements IStorageService {
	
	@Autowired
	private IImagenDAO imagenDAO;
	
	@Autowired
	private IInmuebleService inmuebleDAO;
	//con esa propiedad estamos indicando que la propiedad
	//definida en "media.location" en el archivo
	//"application-properties" es en la que queremos albergar
	//los archivos que subamos...
	@Value("${media.location}")
	private String mediaLocation;
	
	//este objeto de tipo Path representara
	//la ruta raiz de almacenamiento
	private Path rootLocation;
	
	
	
	@Override
	@PostConstruct //Esta notacion ejecuta este metodo en el momento en que la clase se instancia
	public void init() throws IOException {
		//inicializamos la ruta de almacenamiento
		rootLocation = Paths.get(mediaLocation);
		Files.createDirectories(rootLocation);
	}

	@Override
	public String store(MultipartFile file, long idInmueble) throws RuntimeException {
		
		//En este metodo vamos a bifurcar la tarea en dos fases:
		//1 fase) va a tener varios pasos y van a consistir en crear un nombre de almacenamiento
		//para el archivo fisico y la subida real de ese archivo fisico a un directorio del servidor
		//2 fase) va a consistir en crear el registro en el BBDD
		
		
		//PASO 0: Verificamos si el MultipartFile esta vacion
		if(file.isEmpty()) {
			throw new RuntimeException("No es posible almacenar un archivo vacio");
		}
		
		
		//Paso 1: Vamos a conseguir la parte del tipo de archivo. Ejemplo: .jpg .png
		//mozilla.org
		//El metodo getContentType nos devuelve el tipo MIME
		
		String filecontentType = file.getContentType(); //"(image/jpeg)", "(application/pdf)"
		
		String tipo = "." + filecontentType.substring(filecontentType.lastIndexOf("/") + 1);//.jpg .pdf
		
		if(tipo.equals(".jpeg")) {
			tipo = ".jpg";
		}
		
		//Si deseamos completar-matizar el hecho de subir otros tipos de archivos
		//....no dejar subir mas que archivos jpg....cualquier otro matiz "de filtro"
		//debemos programarlo aqui... por ejemplo no deseamos subir archivos .pdf...
		
		if(tipo.equals(".pdf")){
			throw new RuntimeException("No se pueden subir archivos PDF");
		}
		
		//PASO 2: Vamos a crear el nombre del archivo basadonos en la clase calendar
		String filename = String.valueOf( Calendar.getInstance().getTimeInMillis()); //764367376399
		filename = filename.concat(tipo);//17263071623.png"
		
		//PASO 3: Añadimos el String filename a la ruta prefijada de destino
		//de almacenamiento
		
		Path destinationFile =	rootLocation.resolve(Paths.get(filename));
		
		//PASO 4: Movemos el archivo FISICAMENTE a su destino final
		
		
			try(
					
					InputStream inputStream = file.getInputStream()
					
					
					){
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING    );
				
				}
			//En este punto el archivo fisico ya esta subido al directorio mediafiles
			
				
				
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	@Override
	public Resource joResource(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

}*/
