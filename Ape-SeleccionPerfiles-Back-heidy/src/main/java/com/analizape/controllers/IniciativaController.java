package com.analizape.controllers;

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
import com.analizape.models.Iniciativa;
import com.analizape.services.IniciativaService;


@RestController
@RequestMapping("/iniciativa")
@CrossOrigin(origins = "http://localhost:4200") 
public class IniciativaController {

	

	@Autowired
	private IniciativaService iniciativaService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(iniciativaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Iniciativa>o=iniciativaService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Iniciativa iniciativa){
		Iniciativa IniciativaBD=iniciativaService.save(iniciativa);
		return ResponseEntity.status(HttpStatus.CREATED).body(iniciativaService.save(IniciativaBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Iniciativa iniciativa){
		Optional<Iniciativa>o=iniciativaService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Iniciativa iniciativaBD=o.get();
		iniciativaBD.setProyectos_realizados(iniciativa.getProyectos_realizados());
		iniciativaBD.setPropuestas_trabajo(iniciativa.getPropuestas_trabajo());
		iniciativaBD.setRecomendaciones_propuestas_trabajo(iniciativa.getRecomendaciones_propuestas_trabajo());
		iniciativaBD.setCalificacion(iniciativa.getCalificacion());
		iniciativaBD.setObservaciones(iniciativa.getObservaciones());
 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(iniciativaService.save(iniciativaBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		iniciativaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
