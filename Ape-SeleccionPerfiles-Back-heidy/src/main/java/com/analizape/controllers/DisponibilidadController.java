package com.analizape.controllers;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analizape.excepciones.ResourceNotFoundExcepcion;
import com.analizape.models.Disponibilidad;
import com.analizape.models.Rol;
import com.analizape.repository.DisponibilidadRepository;
import com.analizape.services.DisponibilidadService;
import com.analizape.services.RolService;

@RestController
@RequestMapping("disponibilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class DisponibilidadController {


	@Autowired
	private DisponibilidadService disponibilidadService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(disponibilidadService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Disponibilidad>o=disponibilidadService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Disponibilidad disponibilidad){
		Disponibilidad DisponibilidadBD=disponibilidadService.save(disponibilidad);
		return ResponseEntity.status(HttpStatus.CREATED).body(disponibilidadService.save(DisponibilidadBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Disponibilidad disponibilidad){
		Optional<Disponibilidad>o=disponibilidadService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Disponibilidad disponibilidadBD=o.get();
		disponibilidadBD.setDisponibilidad_tiempo(disponibilidad.getDisponibilidad_tiempo());
		disponibilidadBD.setDisponibilidad_salir_municipios(disponibilidad.getDisponibilidad_salir_municipios());
		disponibilidadBD.setDisponibilidad_segun_lugar_residencia(disponibilidad.getDisponibilidad_segun_lugar_residencia());
		disponibilidadBD.setAspecto_fisico(disponibilidad.getAspecto_fisico());
		disponibilidadBD.setMedio_transporte(disponibilidad.getMedio_transporte());
		disponibilidadBD.setCalificacion(disponibilidad.getCalificacion());
		disponibilidadBD.setObservaciones(disponibilidad.getObservaciones());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(disponibilidadService.save(disponibilidadBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		disponibilidadService.deleteById(id);
		return ResponseEntity.noContent().build();
	}


}
