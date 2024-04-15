package com.ipartek.springboot.backend.apirest.models.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

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
@Table(name="inmuebles")
public class Inmueble implements Serializable{

	@Serial
	private static final long serialVersionUID = 654226127056865985L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Incremental para mySQL
	@Column
	private Long id;
	
	@Column
	private String via; //CALLE, PLAZA, CARRETERA
	
	@Column
	private String titular; //Clain - Maravilloso piso en madrid...
	
	@Column(name="nombre_via")
	private String nombreVia; //del Percebe
	
	@Column
	private String numero;
	
	@Column
	private String planta;
	
	@Column
	private String puerta; //A,B,C...
	
	@Column
	private String apertura;//EXTERIOR, INTERIOR
	
	@Column
	private String orientacion; //NORTE, SUR....
	
	@Column
	private String cp;
	
	@Column
	private String operacion; //VENTA, ALQUILER...
	
	@Column(name="superficie_util")
	private String superficieUtil;
	
	@Column(name="superficie_construida")
	private String superficieConstruida;
	
	@Column
	private String precio;
	
	@Column(name="numero_habitaciones")
	private String numeroHabitaciones;
	
	@Column(name="numero_banhos")
	private String numeroBanhos;
	
	@Column(length = 3500)
	private String descripcion; //Una amplia descripcion del inmueble
	
	@Column(name="tipo_calefaccion")
	private String tipoCalefaccion; //SIN CALEFACCION, ELECTRICA...
	
	@Column
	private Integer amueblado; // amueblado, 0 no amueblado
	
	@Column(name="numero_Balcones")
	private String numeroBalcones;
	
	@Column(name="plazas_garaje")
	private String numeroGaraje;
	
	@Column
	private Integer piscina; //1 si 0 no
	
	@Column
	private Integer trastero;
	
	@Column
	private Integer ascensor;
	
	@Column
	private Integer jardin;
	
	@Column
	private Integer tendedero;
	
	@Column
	private Integer portada=0;
	
	@Column
	private Integer activo=1;
	
	@OneToMany(mappedBy="inmueble")
	private Set<Imagen> imagenes;
	
	@ManyToOne
	@JoinColumn(name="tipo")
	private Tipo tipo;
	
	
	
	
	
	
}
