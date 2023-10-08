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

import com.analizape.models.EntidadSolicitante;
import com.analizape.services.EntidadSolcitanteService;

@RestController
@RequestMapping("/entidadSolicitante")
@CrossOrigin(origins ="http://localhost:4200")
public class EntidadSolicitanteController {

	@Autowired
	private EntidadSolcitanteService entidadSolcitanteService;
		
		@GetMapping
		public ResponseEntity<?> listar(){
			return ResponseEntity.ok(entidadSolcitanteService.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> verId(@PathVariable Integer  id){
			Optional<EntidadSolicitante>o=entidadSolcitanteService.findById(id);
			if(o.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(o.get());
		}
		
		@PostMapping
		public ResponseEntity<?> guardar(@RequestBody EntidadSolicitante entidadSolicitante){
			EntidadSolicitante EntidadSolicitanteBD=entidadSolcitanteService.save(entidadSolicitante);
			return ResponseEntity.status(HttpStatus.CREATED).body(entidadSolcitanteService.save(EntidadSolicitanteBD));
		}
		
		
		@PutMapping("/{id}")
		public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody EntidadSolicitante entidadSolicitante){
			Optional<EntidadSolicitante>o=entidadSolcitanteService.findById(id);
			if(o.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
			EntidadSolicitante entidadSolicitanteBD=o.get();
			entidadSolicitanteBD.setNombre_empresa(entidadSolicitante.getNombre_empresa());
			entidadSolicitanteBD.setNombre_completo_solicitante(entidadSolicitante.getNombre_completo_solicitante());
	 
			
			return ResponseEntity.status(HttpStatus.CREATED).body(entidadSolcitanteService.save(entidadSolicitanteBD));
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> eliminar(@PathVariable Integer  id){
			entidadSolcitanteService.deleteById(id);
			return ResponseEntity.noContent().build();
		}

}
