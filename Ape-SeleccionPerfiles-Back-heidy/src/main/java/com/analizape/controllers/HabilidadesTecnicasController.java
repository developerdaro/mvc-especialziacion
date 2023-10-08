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
import com.analizape.models.Habilidades_tecnicas;
import com.analizape.models.Rol;
import com.analizape.repository.HabilidadesTecnicasRepository;
import com.analizape.services.HabilidadesTecnicasService;
import com.analizape.services.RolService;

@RestController
@RequestMapping("/habilidadesTecnicas")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadesTecnicasController {

	@Autowired
	private HabilidadesTecnicasService habilidadesTecnicasService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(habilidadesTecnicasService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Habilidades_tecnicas>o=habilidadesTecnicasService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Habilidades_tecnicas habilidades_tecnicas){
		Habilidades_tecnicas OperatorBD=habilidadesTecnicasService.save(habilidades_tecnicas);
		return ResponseEntity.status(HttpStatus.CREATED).body(habilidadesTecnicasService.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Habilidades_tecnicas habilidades_tecnicas){
		Optional<Habilidades_tecnicas>o=habilidadesTecnicasService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Habilidades_tecnicas habilidadesTecnicasBD=o.get();
		habilidadesTecnicasBD.setConocimiento_tecnico(habilidades_tecnicas.getConocimiento_tecnico());
		habilidadesTecnicasBD.setEquipos_programas(habilidades_tecnicas.getEquipos_programas());
		habilidadesTecnicasBD.setObservacion(habilidades_tecnicas.getObservacion());
		habilidadesTecnicasBD.setPuntuacion(habilidades_tecnicas.getPuntuacion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(habilidadesTecnicasService.save(habilidadesTecnicasBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		habilidadesTecnicasService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
