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
import com.analizape.models.Liderazgo;
import com.analizape.models.Rol;
import com.analizape.repository.LiderazgoRepository;
import com.analizape.services.LiderazgoService;
import com.analizape.services.RolService;


@RestController
@RequestMapping("/liderazgo")
@CrossOrigin(origins = "http://localhost:4200")
public class LiderazgoController {


	@Autowired
	private LiderazgoService liderazgoService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(liderazgoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Liderazgo>o=liderazgoService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Liderazgo rol){
		Liderazgo LiderazgoBD=liderazgoService.save(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(liderazgoService.save(LiderazgoBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Liderazgo liderazgo){
		Optional<Liderazgo>o=liderazgoService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Liderazgo liderazgoBD=o.get();
		liderazgoBD.setCapacidad_manejo_autoridad(liderazgo.getCapacidad_manejo_autoridad());
		liderazgoBD.setProgramas_liderados(liderazgo.getProgramas_liderados());
		liderazgoBD.setPersonal_a_cargo(liderazgo.getPersonal_a_cargo());
		liderazgoBD.setResultado_gestiones(liderazgo.getResultado_gestiones());
		liderazgoBD.setCalificacion(liderazgo.getCalificacion());
		liderazgoBD.setObservaciones(liderazgo.getObservaciones());
		 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(liderazgoService.save(liderazgoBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		liderazgoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
