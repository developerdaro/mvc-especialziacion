package com.analizape.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "metas")
public class Metas {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@Column(name = "parametros_evaluativos", length = 255, nullable = false)
	private String metas_corto_plazo;
	private String metas_mediano_plazo;
	private String metas_largo_plazo;
	private String calificacion;
	private String observaciones;

	// Constructor vacío
	public Metas() {
		super();
	}

	// Constructor con el id
	public Metas(Integer id) {
		super();
		this.id = id;
	}

	// Constructor con el campo parametros evaluativos
	public Metas(String metas_corto_plazo, String metas_mediano_plazo, String metas_largo_plazo, String calificacion,
			String observaciones) {
		super();
		this.metas_corto_plazo = metas_corto_plazo;
		this.metas_mediano_plazo = metas_mediano_plazo;
		this.metas_largo_plazo = metas_largo_plazo;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}
	
	// Constructor completo

	public Metas(Integer id, String metas_corto_plazo, String metas_mediano_plazo, String metas_largo_plazo,
			String calificacion, String observaciones) {
		super();
		this.id = id;
		this.metas_corto_plazo = metas_corto_plazo;
		this.metas_mediano_plazo = metas_mediano_plazo;
		this.metas_largo_plazo = metas_largo_plazo;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}

	// Setters and Getters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getMetas_corto_plazo() {
		return metas_corto_plazo;
	}

	public void setMetas_corto_plazo(String metas_corto_plazo) {
		this.metas_corto_plazo = metas_corto_plazo;
	}

	public String getMetas_mediano_plazo() {
		return metas_mediano_plazo;
	}

	public void setMetas_mediano_plazo(String metas_mediano_plazo) {
		this.metas_mediano_plazo = metas_mediano_plazo;
	}

	public String getMetas_largo_plazo() {
		return metas_largo_plazo;
	}

	public void setMetas_largo_plazo(String metas_largo_plazo) {
		this.metas_largo_plazo = metas_largo_plazo;
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
	
	@JsonManagedReference
	@OneToMany(mappedBy="metas", cascade=CascadeType.ALL)
	@JsonIgnore
    private Set<Entrevistas> entrevistas;

	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}
	

}
