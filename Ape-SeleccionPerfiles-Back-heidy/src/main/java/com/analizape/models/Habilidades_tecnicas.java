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
@Table(name = "habilidades_tecnicas")
public class Habilidades_tecnicas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String conocimiento_tecnico;
	private String equipos_programas;
	private String puntuacion;
	private String observacion;
	
 	// Constructor vacio
	public Habilidades_tecnicas() {
		super();
	}

	// Constructor solo con el ID
	public Habilidades_tecnicas(Integer id) {
		super();
		this.id = id;
	}

	// Constructor sin el id
	public Habilidades_tecnicas(String conocimiento_tecnico, String equipos_programas, String puntuacion,
			String observacion) {
		super();
		this.conocimiento_tecnico = conocimiento_tecnico;
		this.equipos_programas = equipos_programas;
		this.puntuacion = puntuacion;
		this.observacion = observacion;
	}


	// Contructor con todos los campos
	public Habilidades_tecnicas(Integer id, String conocimiento_tecnico, String equipos_programas, String puntuacion,
			String observacion) {
		super();
		this.id = id;
		this.conocimiento_tecnico = conocimiento_tecnico;
		this.equipos_programas = equipos_programas;
		this.puntuacion = puntuacion;
		this.observacion = observacion;
	}

	public String getEquipos_programas() {
		return equipos_programas;
	}
	
	public void setEquipos_programas(String equipos_programas) {
		this.equipos_programas = equipos_programas;
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

	// Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConocimiento_tecnico() {
		return conocimiento_tecnico;
	}

	public void setConocimiento_tecnico(String conocimiento_tecnico) {
		this.conocimiento_tecnico = conocimiento_tecnico;
	}

	@JsonManagedReference
	@OneToMany(mappedBy="habilidadesTecnicas", cascade=CascadeType.REFRESH)
	@JsonIgnore
    private Set<PerfilBase> perfilbase;

	public Set<PerfilBase> getPerfilbase() {
		return perfilbase;
	}

	public void setPerfilbase(Set<PerfilBase> perfilbase) {
		this.perfilbase = perfilbase;
	}
	
}
