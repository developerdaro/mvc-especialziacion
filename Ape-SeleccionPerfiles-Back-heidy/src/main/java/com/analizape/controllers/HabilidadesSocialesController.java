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
import com.analizape.models.HabilidadesSociales;
import com.analizape.models.Rol;
import com.analizape.repository.HabilidadesSocialesRepository;
import com.analizape.services.HabilidadesSocialesService;
import com.analizape.services.RolService;

@RestController
@RequestMapping("habilidadesSociales")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadesSocialesController {

	@Autowired
	private HabilidadesSocialesService HabilidadesSocialesService; 
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(HabilidadesSocialesService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<HabilidadesSociales>o=HabilidadesSocialesService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody HabilidadesSociales habilidadesSociales){
		HabilidadesSociales HabilidadesSocialesBD=HabilidadesSocialesService.save(habilidadesSociales);
		return ResponseEntity.status(HttpStatus.CREATED).body(HabilidadesSocialesService.save(HabilidadesSocialesBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody HabilidadesSociales habilidadesSociales){
		Optional<HabilidadesSociales>o=HabilidadesSocialesService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		HabilidadesSociales habilidadesSocialesBD=o.get();
		habilidadesSocialesBD.setGrupos_pertenece(habilidadesSociales.getGrupos_pertenece());
		habilidadesSocialesBD.setHobbies(habilidadesSociales.getHobbies());
		habilidadesSocialesBD.setTiempo_libre(habilidadesSociales.getTiempo_libre());
		habilidadesSocialesBD.setRelacion_equipos_trabajo(habilidadesSociales.getRelacion_equipos_trabajo());
		habilidadesSocialesBD.setCalificacion(habilidadesSociales.getCalificacion());
		habilidadesSocialesBD.setObservaciones(habilidadesSociales.getObservaciones());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(HabilidadesSocialesService.save(habilidadesSocialesBD));
	}
	    
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		HabilidadesSocialesService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
