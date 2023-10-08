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

import com.analizape.models.Experiencia;
import com.analizape.services.ExperienciaService;


@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins ="http://localhost:4200")
public class ExperienciaController {


	@Autowired
	private ExperienciaService experienciaService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(experienciaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Experiencia>o=experienciaService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Experiencia experiencia){
		Experiencia OperatorBD=experienciaService.save(experiencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(experienciaService.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Experiencia experiencia){
		Optional<Experiencia>o=experienciaService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Experiencia experienciaBD=o.get();
		experienciaBD.setExperienciaEspecifica_funciones_tiempo(experiencia.getExperienciaEspecifica_funciones_tiempo());
		experienciaBD.setExperienciaRelacionada_funciones_tiempo(experiencia.getExperienciaRelacionada_funciones_tiempo());
		experienciaBD.setPuntuacion(experiencia.getPuntuacion());
		experienciaBD.setObservacion(experiencia.getObservacion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(experienciaService.save(experienciaBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		experienciaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
