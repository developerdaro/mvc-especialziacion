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
@Table(name = "habilidades_sociales")
public class HabilidadesSociales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String grupos_pertenece;
	private String hobbies;
	private String tiempo_libre;
	private String relacion_equipos_trabajo;
	private String calificacion;
	private String observaciones;

	// Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrupos_pertenece() {
		return grupos_pertenece;
	}

	public void setGrupos_pertenece(String grupos_pertenece) {
		this.grupos_pertenece = grupos_pertenece;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getTiempo_libre() {
		return tiempo_libre;
	}

	public void setTiempo_libre(String tiempo_libre) {
		this.tiempo_libre = tiempo_libre;
	}

	public String getRelacion_equipos_trabajo() {
		return relacion_equipos_trabajo;
	}

	public void setRelacion_equipos_trabajo(String relacion_equipos_trabajo) {
		this.relacion_equipos_trabajo = relacion_equipos_trabajo;
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
	public HabilidadesSociales() {
		super();
	}

	// Constructor con el id
	public HabilidadesSociales(Integer id) {
		super();
		this.id = id;
	}

	// Constructor sin el id
	public HabilidadesSociales(String grupos_pertenece, String hobbies, String tiempo_libre,
			String relacion_equipos_trabajo, String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.grupos_pertenece = grupos_pertenece;
		this.hobbies = hobbies;
		this.tiempo_libre = tiempo_libre;
		this.relacion_equipos_trabajo = relacion_equipos_trabajo;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}

	//Constructor completo
	public HabilidadesSociales(Integer id, String grupos_pertenece, String hobbies, String tiempo_libre,
			String relacion_equipos_trabajo, String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.id = id;
		this.grupos_pertenece = grupos_pertenece;
		this.hobbies = hobbies;
		this.tiempo_libre = tiempo_libre;
		this.relacion_equipos_trabajo = relacion_equipos_trabajo;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}

	@JsonManagedReference
	@OneToMany(mappedBy="habilidadesSociales", cascade=CascadeType.ALL)
	@JsonIgnore
    private Set<Entrevistas> entrevistas;

	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}

}
