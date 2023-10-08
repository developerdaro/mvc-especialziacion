package com.analizape.controllers;

import java.util.List;

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
import com.analizape.models.user;
import com.analizape.services.RolService;
import com.analizape.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="http://localhost:4200")
public class usersController {

	@Autowired
	private UserService service;
	
	@Autowired
	private RolService rolService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/rol")
	public ResponseEntity<Iterable<Rol>> listarCategorias() {
		return ResponseEntity.ok(rolService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<user>o=service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody user user){
		user OperatorBD=service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody user user){
		Optional<user>o=service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		user userBD=o.get();
		userBD.setNombre(user.getNombre());
		userBD.setApellido(user.getApellido());
		userBD.setCargo(user.getCargo());
		userBD.setTelefono(user.getTelefono());
		userBD.setDocumento(user.getDocumento());
		userBD.setEmail(user.getEmail());
		userBD.setPassword(user.getPassword());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
