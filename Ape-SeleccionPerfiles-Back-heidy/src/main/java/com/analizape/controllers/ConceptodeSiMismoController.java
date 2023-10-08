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
import com.analizape.models.ConceptodeSiMismo;
import com.analizape.models.Rol;
import com.analizape.repository.ConceptodeSiMismoRepository;
import com.analizape.services.ConceptodeSiMismoService;
import com.analizape.services.RolService;

@RestController
@RequestMapping("/conceptodeSiMismo")
@CrossOrigin(origins = "http://localhost:4200")
public class ConceptodeSiMismoController {

	@Autowired
	private ConceptodeSiMismoService conceptodeSiMismoService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(conceptodeSiMismoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<ConceptodeSiMismo>o=conceptodeSiMismoService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody ConceptodeSiMismo conceptodeSiMismo){
		ConceptodeSiMismo ConceptodeSiMismoBD=conceptodeSiMismoService.save(conceptodeSiMismo);
		return ResponseEntity.status(HttpStatus.CREATED).body(conceptodeSiMismoService.save(ConceptodeSiMismoBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody ConceptodeSiMismo conceptodeSiMismo){
		Optional<ConceptodeSiMismo>o=conceptodeSiMismoService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		ConceptodeSiMismo conceptodeSiMismoBD=o.get();
		conceptodeSiMismoBD.setFortalezas_debilidades(conceptodeSiMismo.getFortalezas_debilidades());
		conceptodeSiMismoBD.setCualidades_defectos(conceptodeSiMismo.getCualidades_defectos());
		conceptodeSiMismoBD.setHableme_de_usted(conceptodeSiMismo.getHableme_de_usted());
		conceptodeSiMismoBD.setCalificacion(conceptodeSiMismo.getCalificacion());
		conceptodeSiMismoBD.setObservaciones(conceptodeSiMismo.getObservaciones());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(conceptodeSiMismoService.save(conceptodeSiMismoBD));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		conceptodeSiMismoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}


}
