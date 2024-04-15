package com.ipartek.springboot.backend.apirest.models.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}
