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
@Table(name = "concepto_de_si_mismo")
public class ConceptodeSiMismo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String fortalezas_debilidades;
	private String cualidades_defectos;
	private String hableme_de_usted;
	private String calificacion;
	private String observaciones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFortalezas_debilidades() {
		return fortalezas_debilidades;
	}

	public void setFortalezas_debilidades(String fortalezas_debilidades) {
		this.fortalezas_debilidades = fortalezas_debilidades;
	}

	public String getCualidades_defectos() {
		return cualidades_defectos;
	}

	public void setCualidades_defectos(String cualidades_defectos) {
		this.cualidades_defectos = cualidades_defectos;
	}

	public String getHableme_de_usted() {
		return hableme_de_usted;
	}

	public void setHableme_de_usted(String hableme_de_usted) {
		this.hableme_de_usted = hableme_de_usted;
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
	public ConceptodeSiMismo() {
		super();
	}

	//Constructor con el id
	public ConceptodeSiMismo(Integer id) {
		super();
		this.id = id;
	}

	//Constructor sin el id
	public ConceptodeSiMismo(String fortalezas_debilidades, String cualidades_defectos, String hableme_de_usted,
			String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.fortalezas_debilidades = fortalezas_debilidades;
		this.cualidades_defectos = cualidades_defectos;
		this.hableme_de_usted = hableme_de_usted;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}

	//Constructor completo
	public ConceptodeSiMismo(Integer id, String fortalezas_debilidades, String cualidades_defectos,
			String hableme_de_usted, String calificacion, String observaciones, Set<Entrevistas> entrevistas) {
		super();
		this.id = id;
		this.fortalezas_debilidades = fortalezas_debilidades;
		this.cualidades_defectos = cualidades_defectos;
		this.hableme_de_usted = hableme_de_usted;
		this.calificacion = calificacion;
		this.observaciones = observaciones;
		this.entrevistas = entrevistas;
	}

	@JsonManagedReference
	@OneToMany(mappedBy="conceptodeSiMismo", cascade=CascadeType.ALL)
	@JsonIgnore
    private Set<Entrevistas> entrevistas;

	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}
    
}
