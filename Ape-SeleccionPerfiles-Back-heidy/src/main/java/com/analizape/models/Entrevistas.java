package com.analizape.models;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@Table(name = "entrevistas")
public class Entrevistas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date fecha;
	private String cargo_aspira;
	private String observaciones_generales;

	public Integer getId() {
		return id;
	}
   
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha; 
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getCargo_aspira() {
		return cargo_aspira;
	}

	public void setCargo_aspira(String cargo_aspira) {
		this.cargo_aspira = cargo_aspira;
	}

	public String getObservaciones_generales() {
		return observaciones_generales;
	}

	public void setObservaciones_generales(String observaciones_generales) {
		this.observaciones_generales = observaciones_generales;
	}


	private Integer habComunicacion_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "habComunicacion_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "habComunicacion_id" })
	private HabComuicacion habComuicacion;

	public Integer getHabComunicacion_id() {
		return habComunicacion_id;
	}

	public void setHabComunicacion_id(Integer habComunicacion_id) {
		this.habComunicacion_id = habComunicacion_id;
	}

	public HabComuicacion getHabComuicacion() {
		return habComuicacion;
	}

	public void setHabComuicacion(HabComuicacion habComuicacion) {
		this.habComuicacion = habComuicacion;
	}

	private Integer liderazgo_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "liderazgo_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "liderazgo_id" })
	private Liderazgo liderazgo;

	public Integer getLiderazgo_id() {
		return liderazgo_id;
	}

	public void setLiderazgo_id(Integer liderazgo_id) {
		this.liderazgo_id = liderazgo_id;
	}

	public Liderazgo getLiderazgo() {
		return liderazgo;
	}

	public void setLiderazgo(Liderazgo liderazgo) {
		this.liderazgo = liderazgo;
	}

	private Integer presentacion_personal_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "presentacion_personal_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "presentacion_personal_id" })
	private PresentacionPersonal presentacionPersonal;

	public Integer getPresentacion_personal_id() {
		return presentacion_personal_id;
	}

	public void setPresentacion_personal_id(Integer presentacion_personal_id) {
		this.presentacion_personal_id = presentacion_personal_id;
	}

	public PresentacionPersonal getPresentacionPersonal() {
		return presentacionPersonal;
	}

	public void setPresentacionPersonal(PresentacionPersonal presentacionPersonal) {
		this.presentacionPersonal = presentacionPersonal;
	}
	
	private Integer iniciativa_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "iniciativa_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "iniciativa_id" })
	private Iniciativa iniciativa;

	public Integer getIniciativa_id() {
		return iniciativa_id;
	}

	public void setIniciativa_id(Integer iniciativa_id) {
		this.iniciativa_id = iniciativa_id;
	}

	public Iniciativa getIniciativa() {
		return iniciativa;
	}

	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}

	private Integer habilidades_sociales_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "habilidades_sociales_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "habilidades_sociales_id" })
	private HabilidadesSociales habilidadesSociales;

	public Integer getHabilidades_sociales_id() {
		return habilidades_sociales_id;
	}

	public void setHabilidades_sociales_id(Integer habilidades_sociales_id) {
		this.habilidades_sociales_id = habilidades_sociales_id;
	}

	public HabilidadesSociales getHabilidadesSociales() {
		return habilidadesSociales;
	}

	public void setHabilidadesSociales(HabilidadesSociales habilidadesSociales) {
		this.habilidadesSociales = habilidadesSociales;
	}
	
	private Integer planeacion_organizacion_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "planeacion_organizacion_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "planeacion_organizacion_id" })
	private Planeacion_organizacion planeacion_organizacion;

	public Integer getPlaneacion_organizacion_id() {
		return planeacion_organizacion_id;
	}

	public void setPlaneacion_organizacion_id(Integer planeacion_organizacion_id) {
		this.planeacion_organizacion_id = planeacion_organizacion_id;
	}

	public Planeacion_organizacion getPlaneacion_organizacion() {
		return planeacion_organizacion;
	}

	public void setPlaneacion_organizacion(Planeacion_organizacion planeacion_organizacion) {
		this.planeacion_organizacion = planeacion_organizacion;
	}

	private Integer disponibilidad_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "disponibilidad_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "disponibilidad_id" })
	private Disponibilidad disponibilidad;

	public Integer getDisponibilidad_id() {
		return disponibilidad_id;
	}

	public void setDisponibilidad_id(Integer disponibilidad_id) {
		this.disponibilidad_id = disponibilidad_id;
	}

	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	private Integer concepto_de_si_mismo_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "concepto_de_si_mismo_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "concepto_de_si_mismo_id" })
	private ConceptodeSiMismo conceptodeSiMismo;

	public Integer getConcepto_de_si_mismo_id() {
		return concepto_de_si_mismo_id;
	}

	public void setConcepto_de_si_mismo_id(Integer concepto_de_si_mismo_id) {
		this.concepto_de_si_mismo_id = concepto_de_si_mismo_id;
	}

	public ConceptodeSiMismo getConceptodeSiMismo() {
		return conceptodeSiMismo;
	}

	public void setConceptodeSiMismo(ConceptodeSiMismo conceptodeSiMismo) {
		this.conceptodeSiMismo = conceptodeSiMismo;
	}
	
	private Integer toma_de_decisiones_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "toma_de_decisiones_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "toma_de_decisiones_id" })
	private TomadeDecisiones tomadeDecisiones;

	public Integer getToma_de_decisiones_id() {
		return toma_de_decisiones_id;
	}

	public void setToma_de_decisiones_id(Integer toma_de_decisiones_id) {
		this.toma_de_decisiones_id = toma_de_decisiones_id;
	}

	public TomadeDecisiones getTomadeDecisiones() {
		return tomadeDecisiones;
	}

	public void setTomadeDecisiones(TomadeDecisiones tomadeDecisiones) {
		this.tomadeDecisiones = tomadeDecisiones;
	}
	
	private Integer metas_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "metas_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "metas_id" })
	private Metas metas;

	public Integer getMetas_id() {
		return metas_id;
	}

	public void setMetas_id(Integer metas_id) {
		this.metas_id = metas_id;
	}

	public Metas getMetas() {
		return metas;
	}

	public void setMetas(Metas metas) {
		this.metas = metas;
	}
	
	private Integer entidad_solicitante_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "entidad_solicitante_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "entidad_solicitante_id" })
	private EntidadSolicitante entidadSolicitante;

	public Integer getEntidad_solicitante_id() {
		return entidad_solicitante_id;
	}

	public void setEntidad_solicitante_id(Integer entidad_solicitante_id) {
		this.entidad_solicitante_id = entidad_solicitante_id;
	}

	public EntidadSolicitante getEntidadSolicitante() {
		return entidadSolicitante;
	}

	public void setEntidadSolicitante(EntidadSolicitante entidadSolicitante) {
		this.entidadSolicitante = entidadSolicitante;
	}
	
	private Integer pertenencia_id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JsonIgnore
	@JoinColumn(name = "pertenencia_id", insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties({ "pertenencia_id" })
	private Pertenencia pertenencia;

	public Integer getPertenencia_id() {
		return pertenencia_id;
	}

	public void setPertenencia_id(Integer pertenencia_id) {
		this.pertenencia_id = pertenencia_id;
	}

	public Pertenencia getPertenencia() {
		return pertenencia;
	}

	public void setPertenencia(Pertenencia pertenencia) {
		this.pertenencia = pertenencia;
	}
	
}
