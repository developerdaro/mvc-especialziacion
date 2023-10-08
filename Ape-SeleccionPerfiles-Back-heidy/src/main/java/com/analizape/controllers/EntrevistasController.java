package com.analizape.controllers;

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

import com.analizape.models.Entrevistas;
import com.analizape.models.Liderazgo;
import com.analizape.services.EntrevistasService;
import com.analizape.services.LiderazgoService;

@RestController
@RequestMapping("/entrevistas")
@CrossOrigin(origins ="http://localhost:4200")
public class EntrevistasController {

	@Autowired
	private EntrevistasService entrevistasService;
	
	@Autowired
	private LiderazgoService liderazgoService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(entrevistasService.findAll());
	}
	
	@GetMapping("/liderazgo")
	public ResponseEntity<Iterable<Liderazgo>> listarCategorias() {
		return ResponseEntity.ok(liderazgoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Entrevistas>o=entrevistasService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Entrevistas entrevistas){
		Entrevistas OperatorBD=entrevistasService.save(entrevistas);
		return ResponseEntity.status(HttpStatus.CREATED).body(entrevistasService.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Entrevistas entrevistas){
		Optional<Entrevistas>o=entrevistasService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Entrevistas entrevistasBD=o.get();
		entrevistasBD.setFecha(entrevistas.getFecha());
		entrevistasBD.setCargo_aspira(entrevistas.getCargo_aspira());
		entrevistasBD.setObservaciones_generales(entrevistas.getObservaciones_generales());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entrevistasService.save(entrevistasBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		entrevistasService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
