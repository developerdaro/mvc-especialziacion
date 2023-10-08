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
@Table(name = "disponibilidad")
public class Disponibilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String disponibilidad_tiempo;
	private String disponibilidad_salir_municipios;
	private String disponibilidad_segun_lugar_residencia;
	private String aspecto_fisico;
	private String medio_transporte;
	private String calificacion;
	private String observaciones;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisponibilidad_tiempo() {
		return disponibilidad_tiempo;
	}

	public void setDisponibilidad_tiempo(String disponibilidad_tiempo) {
		this.disponibilidad_tiempo = disponibilidad_tiempo;
	}

	public String getDisponibilidad_salir_municipios() {
		return disponibilidad_salir_municipios;  
	}

	public void setDisponibilidad_salir_municipios(String disponibilidad_salir_municipios) {
		this.disponibilidad_salir_municipios = disponibilidad_salir_municipios;
	}

	public String getDisponibilidad_segun_lugar_residencia() {
		return disponibilidad_segun_lugar_residencia;
	}

	public void setDisponibilidad_segun_lugar_residencia(String disponibilidad_segun_lugar_residencia) {
		this.disponibilidad_segun_lugar_residencia = disponibilidad_segun_lugar_residencia;
	}

	public String getAspecto_fisico() {
		return aspecto_fisico;
	}

	public void setAspecto_fisico(String aspecto_fisico) {
		this.aspecto_fisico = aspecto_fisico;
	}

	public String getMedio_transporte() {
		return medio_transporte;
	}

	public void setMedio_transporte(String medio_transporte) {
		this.medio_transporte = medio_transporte;
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
	public Disponibilidad() {
		super();
	}

	// Constructor con el id
	public Disponibilidad(Integer id) {
		super();
		this.id = id;
	}
	
	// Constructor sin el id
	public Disponibilidad(String disponibilidad_tiempo, String disponibilidad_salir_municipios,
			String disponibilidad_segun_lugar_residencia, String aspecto_fisico, String medio_transporte,
			String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.disponibilidad_tiempo = disponibilidad_tiempo;
		this.disponibilidad_salir_municipios = disponibilidad_salir_municipios;
		this.disponibilidad_segun_lugar_residencia = disponibilidad_segun_lugar_residencia;
		this.aspecto_fisico = aspecto_fisico;
		this.medio_transporte = medio_transporte;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}

	public Disponibilidad(Integer id, String disponibilidad_tiempo, String disponibilidad_salir_municipios,
			String disponibilidad_segun_lugar_residencia, String aspecto_fisico, String medio_transporte,
			String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.id = id;
		this.disponibilidad_tiempo = disponibilidad_tiempo;
		this.disponibilidad_salir_municipios = disponibilidad_salir_municipios;
		this.disponibilidad_segun_lugar_residencia = disponibilidad_segun_lugar_residencia;
		this.aspecto_fisico = aspecto_fisico;
		this.medio_transporte = medio_transporte;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}



	@JsonManagedReference
	@OneToMany(mappedBy="disponibilidad", cascade=CascadeType.ALL)
	@JsonIgnore
    private Set<Entrevistas> entrevistas;

	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}

}
