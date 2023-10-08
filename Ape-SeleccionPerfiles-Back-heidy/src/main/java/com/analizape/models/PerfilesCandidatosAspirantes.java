package com.analizape.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfiles_candidatos_aspirantes")
public class PerfilesCandidatosAspirantes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String identificacion;
	private String nombres;
	private String fecha_hora;
	private String correo_electronico;
	private String direccion;
	private String seleccinado;
	private String obaervacion;
	private String solicitud;

	// Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getSeleccinado() {
		return seleccinado;
	}

	public void setSeleccinado(String seleccinado) {
		this.seleccinado = seleccinado;
	}

	public String getObaervacion() {
		return obaervacion;
	}

	public void setObaervacion(String obaervacion) {
		this.obaervacion = obaervacion;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	//Constructores
	public PerfilesCandidatosAspirantes() {
		super();
	}

	public PerfilesCandidatosAspirantes(Integer id) {
		super();
		this.id = id;
	}

	public PerfilesCandidatosAspirantes(String identificacion, String nombres, String fecha_hora,
			String correo_electronico, String seleccinado, String obaervacion, String solicitud) {
		super();
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.fecha_hora = fecha_hora;
		this.correo_electronico = correo_electronico;
		this.seleccinado = seleccinado;
		this.obaervacion = obaervacion;
		this.solicitud = solicitud;
	}

	public PerfilesCandidatosAspirantes(Integer id, String identificacion, String nombres, String fecha_hora,
			String correo_electronico, String seleccinado, String obaervacion, String solicitud) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.fecha_hora = fecha_hora;
		this.correo_electronico = correo_electronico;
		this.seleccinado = seleccinado;
		this.obaervacion = obaervacion;
		this.solicitud = solicitud;
	}
	
	private Integer perfil_base_id;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
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
    
	private Integer entrevista_id;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.REFRESH)
    @JsonIgnore
    @JoinColumn(name="entrevista_id", insertable = false, updatable = false, nullable=false)
	@JsonIgnoreProperties({"entrevista_id"})
    private Entrevistas entrevistas;

	public Integer getEntrevista_id() {
		return entrevista_id;
	}

	public void setEntrevista_id(Integer entrevista_id) {
		this.entrevista_id = entrevista_id;
	}

	public Entrevistas getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(Entrevistas entrevistas) {
		this.entrevistas = entrevistas;
	}
    
}
