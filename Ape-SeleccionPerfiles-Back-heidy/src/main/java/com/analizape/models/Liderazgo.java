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
@Table(name = "liderazgo")
public class Liderazgo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String capacidad_manejo_autoridad;
	private String personal_a_cargo;
	private String programas_liderados;
	private String resultado_gestiones;
	private String calificacion;
	private String observaciones;


	// Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCapacidad_manejo_autoridad() {
		return capacidad_manejo_autoridad;
	}

	public void setCapacidad_manejo_autoridad(String capacidad_manejo_autoridad) {
		this.capacidad_manejo_autoridad = capacidad_manejo_autoridad;
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

	public String getPersonal_a_cargo() {
		return personal_a_cargo;
	}

	public void setPersonal_a_cargo(String personal_a_cargo) {
		this.personal_a_cargo = personal_a_cargo;
	}

	public String getProgramas_liderados() {
		return programas_liderados;
	}

	public void setProgramas_liderados(String programas_liderados) {
		this.programas_liderados = programas_liderados;
	}

	public String getResultado_gestiones() {
		return resultado_gestiones;
	}

	public void setResultado_gestiones(String resultado_gestiones) {
		this.resultado_gestiones = resultado_gestiones;
	}

	// Constructor vacío
	public Liderazgo() {
		super();
	}

	// Constructor ocn rl id
	public Liderazgo(Integer id) {
		super();
		this.id = id;
	}
	
	// Constructor sin el id
	public Liderazgo(String capacidad_manejo_autoridad, String personal_a_cargo, String programas_liderados,
			String resultado_gestiones, String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.capacidad_manejo_autoridad = capacidad_manejo_autoridad;
		this.personal_a_cargo = personal_a_cargo;
		this.programas_liderados = programas_liderados;
		this.resultado_gestiones = resultado_gestiones;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}


	// Constructor completo
	public Liderazgo(Integer id, String capacidad_manejo_autoridad, String personal_a_cargo, String programas_liderados,
			String resultado_gestiones, String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.id = id;
		this.capacidad_manejo_autoridad = capacidad_manejo_autoridad;
		this.personal_a_cargo = personal_a_cargo;
		this.programas_liderados = programas_liderados;
		this.resultado_gestiones = resultado_gestiones;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}

	@JsonManagedReference
	@OneToMany(mappedBy="liderazgo", cascade=CascadeType.ALL)
	//@JsonIgnore
    private Set<Entrevistas> entrevistas;


	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}

}
