package com.analizape.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "iniciativa")
public class Iniciativa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	private String proyectos_realizados;
	private String propuestas_trabajo;
	private String recomendaciones_propuestas_trabajo;
	private String calificacion;
	private String observaciones;


	// Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProyectos_realizados() {
		return proyectos_realizados;
	}

	public void setProyectos_realizados(String proyectos_realizados) {
		this.proyectos_realizados = proyectos_realizados;
	}

	public String getPropuestas_trabajo() {
		return propuestas_trabajo;
	}

	
	public String getRecomendaciones_propuestas_trabajo() {
		return recomendaciones_propuestas_trabajo;
	}

	public void setRecomendaciones_propuestas_trabajo(String recomendaciones_propuestas_trabajo) {
		this.recomendaciones_propuestas_trabajo = recomendaciones_propuestas_trabajo;
	}

	public void setPropuestas_trabajo(String propuestas_trabajo) {
		this.propuestas_trabajo = propuestas_trabajo;
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

	// Constructor vacio
	public Iniciativa() {
		super();
	}

	// Constructor con el ID
	public Iniciativa(Integer id) {
		super();
		this.id = id;
	}

	// Constructor con todos los campos sin el ID
	public Iniciativa(String proyectos_realizados, String propuestas_trabajo, String calificacion,
			String observaciones) {
		super();
		this.proyectos_realizados = proyectos_realizados;
		this.propuestas_trabajo = propuestas_trabajo;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}

	// Constructor completo
	public Iniciativa(Integer id, String proyectos_realizados, String propuestas_trabajo, String calificacion,
			String observaciones) {
		super();
		this.id = id;
		this.proyectos_realizados = proyectos_realizados;
		this.propuestas_trabajo = propuestas_trabajo;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}

	@JsonManagedReference
	@OneToMany(mappedBy="iniciativa", cascade=CascadeType.ALL)
	@JsonIgnore  
    private Set<Entrevistas> entrevistas;
	
	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	} 

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}
	
}
