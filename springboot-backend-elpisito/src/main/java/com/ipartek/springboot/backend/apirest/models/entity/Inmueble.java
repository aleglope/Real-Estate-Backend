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
@Table(name = "inmuebles")
public class Inmueble implements Serializable {

	@Serial
	private static final long serialVersionUID = 654226127056865985L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Incremental para mySQL
	@Column
	private Long id;

	@Column
	private String via; // CALLE, PLAZA, CARRETERA

	@Column
	private String titular; // Claim - Maravilloso piso en Madrid...

	@Column(name = "nombre_via")
	private String nombreVia; // del Percebe

	@Column
	private String numero;

	@Column
	private String planta;

	@Column
	private String puerta; // A,B,C...

	@Column
	private String apertura; // EXTERIOR, INTERIOR...

	@Column
	private String orientacion; // NORTE, SUR...

	@Column
	private String cp;

	@Column
	private String operacion; // VENTA, ALQUILER...

	@Column(name = "superficie_util")
	private String superficieUtil;

	@Column(name = "superficie_construida")
	private String superficieConstruida;

	@Column
	private String precio;

	@Column(name = "numero_habitaciones")
	private String numeroHabitaciones;

	@Column(name = "numero_banhos")
	private String numeroBanhos;

	@Column(length = 3500)
	private String descripcion;// Una amplia descripción del inmueble

	@Column(name = "tipo_calefaccion")
	private String tipoCalefaccion;// SIN CALEFACCIÓN, ELÉCTRICA...

	@Column
	private Integer amueblado;// 1 si, 0 no

	@Column(name = "numero_balcones")
	private String numeroBalcones;

	@Column(name = "plazas_garaje")
	private String plazasGaraje;

	@Column
	private Integer piscina; // 1 si, 0 no

	@Column
	private Integer trastero; // 1 si, 0 no

	@Column
	private Integer ascensor; // 1 si, 0 no

	@Column
	private Integer jardin; // 1 si, 0 no

	@Column
	private Integer tendedero; // 1 si, 0 no

	@Column
	private Integer portada = 0; // 1 si, 0 no

	@Column
	private Integer activo = 1;

	@OneToMany(mappedBy = "inmueble")
	private Set<Imagen> imagenes;

	@ManyToOne
	@JoinColumn(name = "tipo")
	private Tipo tipo;// Este esl mappedBy de @OneToMany de la clase Tipo

	@ManyToOne
	@JoinColumn(name = "poblacion")
	private Poblacion poblacion;

}
