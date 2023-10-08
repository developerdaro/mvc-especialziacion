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
@Table(name = "nivelEstudios")
public class NivelEstudios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String estudios_realizados_especificos;
	private String otros_estudios_relacionados;
	private String puntuacion;
	private String observaciones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstudios_realizados_especificos() {
		return estudios_realizados_especificos;
	}

	public void setEstudios_realizados_especificos(String estudios_realizados_especificos) {
		this.estudios_realizados_especificos = estudios_realizados_especificos;
	}


	public String getOtros_estudios_relacionados() {
		return otros_estudios_relacionados;
	}

	public void setOtros_estudios_relacionados(String otros_estudios_realacionados) {
		this.otros_estudios_relacionados = otros_estudios_realacionados;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	// Constructor vacío
	public NivelEstudios() {
		super();
	}

	// Constructor con el ID
	public NivelEstudios(Integer id) {
		super();
		this.id = id;
	}
	
	// Constructor completo
	public NivelEstudios(Integer id, String estudios_realizados_especificos, String otros_estudios_realacionados,
			String puntuacion, String observaciones) {
		super();
		this.id = id;
		this.estudios_realizados_especificos = estudios_realizados_especificos;
		this.otros_estudios_relacionados = otros_estudios_realacionados;
		this.puntuacion = puntuacion;
		this.observaciones = observaciones;
	}
	
	// Constructor sin el id
	public NivelEstudios(String estudios_realizados_especificos, String otros_estudios_realacionados, String puntuacion,
			String observaciones) {
		super();
		this.estudios_realizados_especificos = estudios_realizados_especificos;
		this.otros_estudios_relacionados = otros_estudios_realacionados;
		this.puntuacion = puntuacion;
		this.observaciones = observaciones;
	}
	
	@JsonManagedReference
	@OneToMany(mappedBy="nivelEstudios", cascade=CascadeType.REFRESH)
	@JsonIgnore 
    private Set<PerfilBase> perfilbase;
	
}
