package com.analizape.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "toma_de_decisiones")
public class TomadeDecisiones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String decisiones_importantes;
	private String decisiones_faciles;
	private String decisiones_dificiles;
	private String participacion_terceros;
	private String calificacion;
    private String observaciones;
   

 //Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDecisiones_importantes() {
		return decisiones_importantes;
	}

	public void setDecisiones_importantes(String decisiones_importantes) {
		this.decisiones_importantes = decisiones_importantes;
	}

	public String getDecisiones_faciles() {
		return decisiones_faciles;
	}

	public void setDecisiones_faciles(String decisiones_faciles) {
		this.decisiones_faciles = decisiones_faciles;
	}

	public String getDecisiones_dificiles() {
		return decisiones_dificiles;
	}

	public void setDecisiones_dificiles(String decisiones_dificiles) {
		this.decisiones_dificiles = decisiones_dificiles;
	}

	public String getParticipacion_terceros() {
		return participacion_terceros;
	}

	public void setParticipacion_terceros(String participacion_terceros) {
		this.participacion_terceros = participacion_terceros;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	// Constructor vacío
	public TomadeDecisiones() {
		super();
	}

	// Constructor con el ID
	public TomadeDecisiones(Integer id) {
		super();
		this.id = id;
	}

	// Constructor sin el ID

	public TomadeDecisiones(String decisiones_importantes, String decisiones_faciles, String decisiones_dificiles,
			String participacion_terceros, String calificacion, String observaciones) {
		super();
		this.decisiones_importantes = decisiones_importantes;
		this.decisiones_faciles = decisiones_faciles;
		this.decisiones_dificiles = decisiones_dificiles;
		this.participacion_terceros = participacion_terceros;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}
 
	//C	onstructor completo 
	public TomadeDecisiones(Integer id, String decisiones_importantes, String decisiones_faciles,
			String decisiones_dificiles, String participacion_terceros, String calificacion, String observaciones) {
		super();
		this.id = id;
		this.decisiones_importantes = decisiones_importantes;
		this.decisiones_faciles = decisiones_faciles;
		this.decisiones_dificiles = decisiones_dificiles;
		this.participacion_terceros = participacion_terceros;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}
	@JsonManagedReference
	@OneToMany(mappedBy="tomadeDecisiones", cascade=CascadeType.ALL)
	//@JsonIgnore
    private Set<Entrevistas> entrevistas;
	
}
