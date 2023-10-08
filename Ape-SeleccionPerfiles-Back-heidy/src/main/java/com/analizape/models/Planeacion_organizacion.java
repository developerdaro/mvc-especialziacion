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
@Table(name = "planeacion_organizacion")
public class Planeacion_organizacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String metas;
	private String como_planifica;
	private String estrategias;
	private String necesidad_de_recompensa;
	private String calificacion;
	private String observaciones;

	//Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMetas() {
		return metas;
	}

	public void setMetas(String metas) {
		this.metas = metas;
	}

	public String getComo_planifica() {
		return como_planifica;
	}

	public void setComo_planifica(String como_planea) {
		this.como_planifica = como_planea;
	}

	public String getEstrategias() {
		return estrategias;
	}

	public void setEstrategias(String estrategias) {
		this.estrategias = estrategias;
	}

	public String getNecesidad_de_recompensa() {
		return necesidad_de_recompensa;
	}

	public void setNecesidad_de_recompensa(String necesidad_de_recompensa) {
		this.necesidad_de_recompensa = necesidad_de_recompensa;
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


	//Constructor vacío
	public Planeacion_organizacion() {
		super();
	}

	//Constructor con el ID
	public Planeacion_organizacion(Integer id) {
		super();
		this.id = id;
	}


	//Constructor sin el id
	public Planeacion_organizacion(String metas, String como_planifica, String estrategias,
			String necesidad_de_recompensa, String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.metas = metas;
		this.como_planifica = como_planifica;
		this.estrategias = estrategias;
		this.necesidad_de_recompensa = necesidad_de_recompensa;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}
	
	//Constructor completo
	public Planeacion_organizacion(Integer id, String metas, String como_planifica, String estrategias,
			String necesidad_de_recompensa, String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.id = id;
		this.metas = metas;
		this.como_planifica = como_planifica;
		this.estrategias = estrategias;
		this.necesidad_de_recompensa = necesidad_de_recompensa;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}



	@JsonManagedReference
	@OneToMany(mappedBy="planeacion_organizacion", cascade=CascadeType.ALL)
	//@JsonIgnore
    private Set<Entrevistas> entrevistas;
}
