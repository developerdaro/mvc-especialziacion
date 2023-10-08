package com.analizape.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="perfil_base")
public class PerfilBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id;
	
	
	private String nombre_cargo;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre_cargo() {
		return nombre_cargo;
	}


	public void setNombre_cargo(String nombre_cargo) {
		this.nombre_cargo = nombre_cargo;
	}
	
    private Integer experiencia_id;
	
	@JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
    @JsonIgnore
    @JoinColumn(name="experiencia_id", insertable = false, updatable = false, nullable=false)
	@JsonIgnoreProperties({"experiencia_id"})
    private Experiencia experiencia;


	public Integer getExperiencia_id() {
		return experiencia_id;
	}


	public void setExperiencia_id(Integer experiencia_id) {
		this.experiencia_id = experiencia_id;
	}


	public Experiencia getExperiencia() {
		return experiencia;
	}


	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
    
    
	  private Integer nivelEstudios_id;
		
		@JsonBackReference 
	    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
	    @JsonIgnore
	    @JoinColumn(name="nivelEstudios_id", insertable = false, updatable = false, nullable=false)
		@JsonIgnoreProperties({"nivelEstudios_id"})
	    private NivelEstudios nivelEstudios; 


		public Integer getNivelEstudios_id() {
			return nivelEstudios_id;
		}


		public void setNivelEstudios_id(Integer nivelEstudios_id) {
			this.nivelEstudios_id = nivelEstudios_id;
		}


		public NivelEstudios getNivelEstudios() {
			return nivelEstudios;
		}


		public void setNivelEstudios(NivelEstudios nivelEstudios) {
			this.nivelEstudios = nivelEstudios;
		}
		
		 private Integer habilidadesTecnicas_id;
			
			@JsonBackReference 
		    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
		    @JsonIgnore
		    @JoinColumn(name="habilidadesTecnicas_id", insertable = false, updatable = false, nullable=false)
			@JsonIgnoreProperties({"habilidadesTecnicas_id"})
		    private Habilidades_tecnicas  habilidadesTecnicas;


			public Integer getHabilidadesTecnicas_id() {
				return habilidadesTecnicas_id;
			}


			public void setHabilidadesTecnicas_id(Integer habilidadesTecnicas_id) {
				this.habilidadesTecnicas_id = habilidadesTecnicas_id;
			}


			public Habilidades_tecnicas getHabilidadesTecnicas() {
				return habilidadesTecnicas;
			}


			public void setHabilidadesTecnicas(Habilidades_tecnicas habilidadesTecnicas) {
				this.habilidadesTecnicas = habilidadesTecnicas;
			}
			
			
  
}
