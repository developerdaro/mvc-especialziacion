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
import com.analizape.models.HabComuicacion;
import com.analizape.models.Rol;
import com.analizape.repository.HabComunicacionRepository;
import com.analizape.services.HabComunicacionService;
import com.analizape.services.RolService;

@RestController
@RequestMapping("/habComunicacion")
@CrossOrigin(origins = "http://localhost:4200")
public class HabComunicacionController {

	@Autowired
	private HabComunicacionService habComunicacionService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(habComunicacionService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<HabComuicacion>o=habComunicacionService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody HabComuicacion habComunicacion){
		HabComuicacion OperatorBD=habComunicacionService.save(habComunicacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(habComunicacionService.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody HabComuicacion habComuicacion){
		Optional<HabComuicacion>o=habComunicacionService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		HabComuicacion habComunicacionBD=o.get();
		habComunicacionBD.setFluidez_verbal(habComuicacion.getFluidez_verbal());
		habComunicacionBD.setSeguridad_transmitir_mensaje(habComuicacion.getSeguridad_transmitir_mensaje());
		habComunicacionBD.setCapacidad_manejar_objeciones(habComuicacion.getCapacidad_manejar_objeciones());
		habComunicacionBD.setClaridad_transmitir_mensaje(habComuicacion.getClaridad_transmitir_mensaje());
		habComunicacionBD.setCalificacion(habComuicacion.getCalificacion());
		habComunicacionBD.setObservaciones(habComuicacion.getObservaciones());
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(habComunicacionService.save(habComunicacionBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		habComunicacionService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
		
}
