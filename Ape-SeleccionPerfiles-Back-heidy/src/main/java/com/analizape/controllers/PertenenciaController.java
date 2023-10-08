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
import com.analizape.models.Pertenencia;
import com.analizape.services.PertenenciaService;

@RestController
@RequestMapping("/pertenencia")
@CrossOrigin(origins = "http://localhost:4200")
public class PertenenciaController {

	@Autowired
	private PertenenciaService pertenenciaService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(pertenenciaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Pertenencia>o=pertenenciaService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Pertenencia pertenencia){
		Pertenencia PertenenciaBD=pertenenciaService.save(pertenencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(pertenenciaService.save(PertenenciaBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Pertenencia pertenencia){
		Optional<Pertenencia>o=pertenenciaService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Pertenencia pertenenciaBD=o.get();
		pertenenciaBD.setConocimiento_empresayservicios(pertenencia.getConocimiento_empresayservicios());
		pertenenciaBD.setPorque_trabajar_empresa(pertenencia.getPorque_trabajar_empresa());
		pertenenciaBD.setPercepcion_empresa(pertenencia.getPercepcion_empresa());
		pertenenciaBD.setAportes_empresa(pertenencia.getAportes_empresa());
		pertenenciaBD.setCalificacion(pertenencia.getCalificacion());
		pertenenciaBD.setObservaciones(pertenencia.getObservaciones());
		return ResponseEntity.status(HttpStatus.CREATED).body(pertenenciaService.save(pertenenciaBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		pertenenciaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
		
}
