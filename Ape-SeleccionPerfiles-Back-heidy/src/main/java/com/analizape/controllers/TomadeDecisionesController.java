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
import com.analizape.models.Rol;
import com.analizape.models.TomadeDecisiones;
import com.analizape.repository.TomaDecisionesRepository;
import com.analizape.services.RolService;
import com.analizape.services.TomaDecisionesService;

@RestController
@RequestMapping("/tomadeDecisiones")
@CrossOrigin(origins = "http://localhost:4200")
public class TomadeDecisionesController {


	@Autowired
	private TomaDecisionesService tomaDecisionesService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(tomaDecisionesService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<TomadeDecisiones>o=tomaDecisionesService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody TomadeDecisiones tomadeDecisiones){
		TomadeDecisiones OperatorBD=tomaDecisionesService.save(tomadeDecisiones);
		return ResponseEntity.status(HttpStatus.CREATED).body(tomaDecisionesService.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody TomadeDecisiones tomadeDecisiones){
		Optional<TomadeDecisiones>o=tomaDecisionesService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		TomadeDecisiones tomadeDecisionesBD=o.get();
		tomadeDecisionesBD.setDecisiones_importantes(tomadeDecisiones.getDecisiones_importantes());
		tomadeDecisionesBD.setDecisiones_faciles(tomadeDecisiones.getDecisiones_faciles());
		tomadeDecisionesBD.setParticipacion_terceros(tomadeDecisiones.getParticipacion_terceros());
		tomadeDecisionesBD.setDecisiones_dificiles(tomadeDecisiones.getDecisiones_dificiles());
		tomadeDecisionesBD.setCalificacion(tomadeDecisiones.getCalificacion());
		tomadeDecisionesBD.setObservaciones(tomadeDecisiones.getObservaciones());
 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tomaDecisionesService.save(tomadeDecisionesBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		tomaDecisionesService.deleteById(id);
		return ResponseEntity.noContent().build();
	}


}
