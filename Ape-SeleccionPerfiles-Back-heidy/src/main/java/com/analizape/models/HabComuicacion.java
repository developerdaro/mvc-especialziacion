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
@Table(name = "hab_comunicacion")
public class HabComuicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@Column(name = "tipo_comunicacion", length = 60, nullable = false)
	private String fluidez_verbal;
	private String seguridad_transmitir_mensaje;
	private String capacidad_manejar_objeciones;
	private String claridad_transmitir_mensaje;
	private String calificacion;
	private String observaciones;

	public HabComuicacion() {
		super();
	}


	public HabComuicacion(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getFluidez_verbal() {
		return fluidez_verbal;
	}


	public void setFluidez_verbal(String fluidez_verbal) {
		this.fluidez_verbal = fluidez_verbal;
	}


	public String getSeguridad_transmitir_mensaje() {
		return seguridad_transmitir_mensaje;
	}


	public void setSeguridad_transmitir_mensaje(String seguridad_transmitir_mensaje) {
		this.seguridad_transmitir_mensaje = seguridad_transmitir_mensaje;
	}


	public String getCapacidad_manejar_objeciones() {
		return capacidad_manejar_objeciones;
	}


	public void setCapacidad_manejar_objeciones(String capacidad_manejar_objeciones) {
		this.capacidad_manejar_objeciones = capacidad_manejar_objeciones;
	}


	public String getClaridad_transmitir_mensaje() {
		return claridad_transmitir_mensaje;
	}


	public void setClaridad_transmitir_mensaje(String claridad_transmitir_mensaje) {
		this.claridad_transmitir_mensaje = claridad_transmitir_mensaje;
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
	@OneToMany(mappedBy="habComuicacion", cascade=CascadeType.ALL)
	@JsonIgnore 
    private Set<Entrevistas> entrevistas;

	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	} 

}
