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

import com.analizape.models.PerfilBase;
import com.analizape.models.Rol;
import com.analizape.models.user;
import com.analizape.services.PerfilBaseService;
import com.analizape.services.RolService;
import com.analizape.services.UserService;

@RestController
@RequestMapping("/perfilBase")
@CrossOrigin(origins ="http://localhost:4200")
public class PerfilBaseController {

	@Autowired
	private PerfilBaseService perfilBaseService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(perfilBaseService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<PerfilBase>o=perfilBaseService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody PerfilBase perfilBase){
		PerfilBase OperatorBD=perfilBaseService.save(perfilBase);
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilBaseService.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody PerfilBase perfilBase){
		Optional<PerfilBase>o=perfilBaseService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		PerfilBase perfilBaseBD=o.get();
		perfilBaseBD.setNombre_cargo(perfilBase.getNombre_cargo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilBaseService.save(perfilBaseBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		perfilBaseService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
