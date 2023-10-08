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
@Table(name = "pertenencia")
public class Pertenencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String conocimiento_empresayservicios;
	private String porque_trabajar_empresa;
	private String percepcion_empresa;
	private String aportes_empresa;
	private String calificacion;
	private String observaciones;
	
	// Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConocimiento_empresayservicios() {
		return conocimiento_empresayservicios;
	}

	public void setConocimiento_empresayservicios(String conocimiento_empresayservicios) {
		this.conocimiento_empresayservicios = conocimiento_empresayservicios;
	}

	public String getPorque_trabajar_empresa() {
		return porque_trabajar_empresa;
	}

	public void setPorque_trabajar_empresa(String porque_trabajar_empresa) {
		this.porque_trabajar_empresa = porque_trabajar_empresa;
	}

	public String getPercepcion_empresa() {
		return percepcion_empresa;
	}

	public void setPercepcion_empresa(String percepcion_empresa) {
		this.percepcion_empresa = percepcion_empresa;
	}

	public String getAportes_empresa() {
		return aportes_empresa;
	}

	public void setAportes_empresa(String aportes_empresa) {
		this.aportes_empresa = aportes_empresa;
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
	public Pertenencia() {
		super();
	}

	// Constructor con el ID
	public Pertenencia(Integer id) {
		super();
		this.id = id;
	}


	// Constructor sin el id
	public Pertenencia(String conocimiento_empresayservicios, String porque_trabajar_empresa, String percepcion_empresa,
			String aportes_empresa, String calificacion, String observaciones) {
		super();
		this.conocimiento_empresayservicios = conocimiento_empresayservicios;
		this.porque_trabajar_empresa = porque_trabajar_empresa;
		this.percepcion_empresa = percepcion_empresa;
		this.aportes_empresa = aportes_empresa;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}

	// Constructor completo
	public Pertenencia(Integer id, String conocimiento_empresayservicios, String porque_trabajar_empresa,
			String percepcion_empresa, String aportes_empresa, String calificacion, String observaciones) {
		super();
		this.id = id;   
		this.conocimiento_empresayservicios = conocimiento_empresayservicios;
		this.porque_trabajar_empresa = porque_trabajar_empresa;
		this.percepcion_empresa = percepcion_empresa;
		this.aportes_empresa = aportes_empresa;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
	}
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="pertenencia", cascade=CascadeType.ALL)
	@JsonIgnore
    private Set<Entrevistas> entrevistas;

	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}
	
	
}
