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
@Table(name = "experiencia")
public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String experienciaEspecifica_funciones_tiempo;
	private String experienciaRelacionada_funciones_tiempo;
	private String puntuacion;
	private String observacion;


	// Constructor vacío
	public Experiencia() {
		super();
	}
	
	// Constructor con el Id
	public Experiencia(Integer id) {
		super();
		this.id = id;
	}

	// Constructor con los campos sin el ID
	public Experiencia(String experienciaEspecifica_funciones_tiempo, String experienciaRelacionada_funciones_tiempo,
			String puntuacion, String observacion, Set<PerfilBase> perfilbase) {
		super();
		this.experienciaEspecifica_funciones_tiempo = experienciaEspecifica_funciones_tiempo;
		this.experienciaRelacionada_funciones_tiempo = experienciaRelacionada_funciones_tiempo;
		this.puntuacion = puntuacion;
		this.observacion = observacion;
		this.perfilbase = perfilbase;
	}

	//Constructor completo
	public Experiencia(Integer id, String experienciaEspecifica_funciones_tiempo,
			String experienciaRelacionada_funciones_tiempo, String puntuacion, String observacion,
			Set<PerfilBase> perfilbase) {
		super();
		this.id = id;
		this.experienciaEspecifica_funciones_tiempo = experienciaEspecifica_funciones_tiempo;
		this.experienciaRelacionada_funciones_tiempo = experienciaRelacionada_funciones_tiempo;
		this.puntuacion = puntuacion;
		this.observacion = observacion;
		this.perfilbase = perfilbase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExperienciaEspecifica_funciones_tiempo() {
		return experienciaEspecifica_funciones_tiempo;
	}

	public void setExperienciaEspecifica_funciones_tiempo(String experienciaEspecifica_funciones_tiempo) {
		this.experienciaEspecifica_funciones_tiempo = experienciaEspecifica_funciones_tiempo;
	}

	public String getExperienciaRelacionada_funciones_tiempo() {
		return experienciaRelacionada_funciones_tiempo;
	}

	public void setExperienciaRelacionada_funciones_tiempo(String experienciaRelacionada_funciones_tiempo) {
		this.experienciaRelacionada_funciones_tiempo = experienciaRelacionada_funciones_tiempo;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@JsonManagedReference
	@OneToMany(mappedBy="experiencia", cascade=CascadeType.REFRESH)
	@JsonIgnore 
    private Set<PerfilBase> perfilbase;

	public Set<PerfilBase> getPerfilbase() {
		return perfilbase;
	}

	public void setPerfilbase(Set<PerfilBase> perfilbase) {
		this.perfilbase = perfilbase;
	}
	
	
}
