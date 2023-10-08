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

import com.analizape.models.Rol;
import com.analizape.services.RolService;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins ="http://localhost:4200")
public class RolController {
	

	@Autowired
	private RolService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Rol>o=service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Rol rol){
		Rol OperatorBD=service.save(rol);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Rol rol){
		Optional<Rol>o=service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Rol userBD=o.get();
		userBD.setNombre(rol.getNombre());
 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
