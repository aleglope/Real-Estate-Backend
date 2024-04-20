package com.ipartek.springboot.backend.apirest.models.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="poblaciones")
public class Poblacion implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -5763929061016836220L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Incremental para mySQL
	@Column
	private Long id;
	
	@Column
	private String nombre; //PISO, FINCA, LONJA...
	
	@Column
	private Integer activo=1;
	
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name="provincia")
	private Provincia provincia; //Este es el mappedby de onetomany de la clase provincia
	
	@JsonIgnore
	@OneToMany(mappedBy = "poblacion", cascade=CascadeType.ALL)
	private Set<Inmueble> inmuebles;
	
	
	
	
}
