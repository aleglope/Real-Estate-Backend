package com.ipartek.springboot.backend.apirest.models.entity;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="imagenes")
public class Imagen implements Serializable {
	
	
	@Serial
	private static final long serialVersionUID = 2349985578667285154L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Incremental para mySQL
	@Column
	private Long id;
	
	@Column
	private String nombre; //7858858757825785789925592.jpg
	
	@Column
	private Integer activo=1;
	
	
	//@JsonBackReference  //para pruebas con objetos json en Postman
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="inmueble")
	private Inmueble inmueble;//Este es el mappedBy de @OneToMany de la clase Inmueble
	
	

}
