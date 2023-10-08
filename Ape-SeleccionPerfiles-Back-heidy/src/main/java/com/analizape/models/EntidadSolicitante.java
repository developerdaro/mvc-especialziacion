package com.analizape.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="entidad_solicitante")
public class EntidadSolicitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id;
	
	private String nombre_empresa;
	private String nombre_completo_solicitante;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre_empresa() {
		return nombre_empresa;
	}
	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
	public String getNombre_completo_solicitante() {
		return nombre_completo_solicitante;
	}
	public void setNombre_completo_solicitante(String nombre_completo_solicitante) {
		this.nombre_completo_solicitante = nombre_completo_solicitante;
	}
	
	private Integer perfil_base_id;
	
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name="perfil_base_id", insertable = false, updatable = false, nullable=false)
	@JsonIgnoreProperties({"perfil_base_id"})
    private PerfilBase perfilBase;
	public Integer getPerfil_base_id() {
		return perfil_base_id;
	}
	public void setPerfil_base_id(Integer perfil_base_id) {
		this.perfil_base_id = perfil_base_id;
	}
	public PerfilBase getPerfilBase() {
		return perfilBase;
	}
	public void setPerfilBase(PerfilBase perfilBase) {
		this.perfilBase = perfilBase;
	}
    
	@JsonManagedReference
	@OneToMany(mappedBy="entidadSolicitante", cascade=CascadeType.ALL)
	@JsonIgnore
    private Set<Entrevistas> entrevistas;
	public Set<Entrevistas> getEntrevistas() {
		return entrevistas;
	}
	public void setEntrevistas(Set<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}
	
}
