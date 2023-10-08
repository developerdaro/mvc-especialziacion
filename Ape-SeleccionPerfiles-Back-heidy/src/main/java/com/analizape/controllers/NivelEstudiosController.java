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
import com.analizape.models.NivelEstudios;
import com.analizape.models.Rol;
import com.analizape.repository.NivelEstudiosRepository;
import com.analizape.services.NivelEstudiosService;
import com.analizape.services.RolService;

@RestController
@RequestMapping("/nivelEstudios")
@CrossOrigin(origins = "http://localhost:4200")
public class NivelEstudiosController {


	@Autowired
	private NivelEstudiosService nivelEstudioservice;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(nivelEstudioservice.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<NivelEstudios>o=nivelEstudioservice.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody NivelEstudios nivelEstudios){
		NivelEstudios NivelEstudiosBD=nivelEstudioservice.save(nivelEstudios);
		return ResponseEntity.status(HttpStatus.CREATED).body(nivelEstudioservice.save(NivelEstudiosBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody NivelEstudios nivelEstudios){
		Optional<NivelEstudios>o=nivelEstudioservice.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		NivelEstudios nivelEstudiosBD=o.get();
		nivelEstudiosBD.setEstudios_realizados_especificos(nivelEstudios.getEstudios_realizados_especificos());
		nivelEstudiosBD.setOtros_estudios_relacionados(nivelEstudios.getOtros_estudios_relacionados());
		nivelEstudiosBD.setPuntuacion(nivelEstudios.getPuntuacion());
		nivelEstudiosBD.setObservaciones(nivelEstudios.getObservaciones());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nivelEstudioservice.save(nivelEstudiosBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		nivelEstudioservice.deleteById(id);
		return ResponseEntity.noContent().build();
	}


}
