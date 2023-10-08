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
@Table(name = "presentacion_personal")
public class PresentacionPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String presentacion_personal;
	private String manejo_no_verbal;
	private String actitud;
	private String calificacion;
	private String observaciones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPresentacion_personal() {
		return presentacion_personal;
	}

	public void setPresentacion_personal(String presentacion_personal) {
		this.presentacion_personal = presentacion_personal;
	}

	public String getManejo_no_verbal() {
		return manejo_no_verbal;
	}

	public void setManejo_no_verbal(String manejo_no_verbal) {
		this.manejo_no_verbal = manejo_no_verbal;
	}

	public String getActitud() {
		return actitud;
	}

	public void setActitud(String actitud) {
		this.actitud = actitud;
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
	public PresentacionPersonal() {
		super();
	}

	// Constructor con el id
	public PresentacionPersonal(Integer id) {
		super();
		this.id = id;
	}

//Constructor sin el id
	public PresentacionPersonal(String presentacion_personal, String manejo_no_verbal, String actitud,
			String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.presentacion_personal = presentacion_personal;
		this.manejo_no_verbal = manejo_no_verbal;
		this.actitud = actitud;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}
//Constructor completo
	public PresentacionPersonal(Integer id, String presentacion_personal, String manejo_no_verbal, String actitud,
		String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
	super();
	this.id = id;
	this.presentacion_personal = presentacion_personal;
	this.manejo_no_verbal = manejo_no_verbal;
	this.actitud = actitud;
	this.calificacion = calificacion;
	this.observaciones = observaciones;
	this.entrevistas = entrevistas;
}



	@JsonManagedReference
	@OneToMany(mappedBy="presentacionPersonal", cascade=CascadeType.ALL)
	//@JsonIgnore
    private Set<Entrevistas> entrevistas;

	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}
	
}
