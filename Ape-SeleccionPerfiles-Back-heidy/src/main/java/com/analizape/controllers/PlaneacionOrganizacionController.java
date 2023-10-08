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
import com.analizape.models.Planeacion_organizacion;
import com.analizape.models.Rol;
import com.analizape.repository.PlaneacionOrganizacionRepository;
import com.analizape.services.PlaneacionyOrganizacionService;
import com.analizape.services.RolService;

@RestController
@RequestMapping("/planeacionyOrganizacion")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaneacionOrganizacionController {


	@Autowired
	private PlaneacionyOrganizacionService planeacionyOrganizacionService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(planeacionyOrganizacionService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Planeacion_organizacion>o=planeacionyOrganizacionService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Planeacion_organizacion planeacion_organizacion){
		Planeacion_organizacion PlaneacionyOrganizacionBD=planeacionyOrganizacionService.save(planeacion_organizacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(planeacionyOrganizacionService.save(PlaneacionyOrganizacionBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Planeacion_organizacion planeacion_organizacion){
		Optional<Planeacion_organizacion>o=planeacionyOrganizacionService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Planeacion_organizacion planeacionyOrganizacionBD=o.get();
		planeacionyOrganizacionBD.setComo_planifica(planeacion_organizacion.getComo_planifica());
		planeacionyOrganizacionBD.setMetas(planeacion_organizacion.getMetas());
		planeacionyOrganizacionBD.setEstrategias(planeacion_organizacion.getEstrategias());
		planeacionyOrganizacionBD.setNecesidad_de_recompensa(planeacion_organizacion.getNecesidad_de_recompensa());
		planeacionyOrganizacionBD.setCalificacion(planeacion_organizacion.getCalificacion());
		planeacionyOrganizacionBD.setObservaciones(planeacion_organizacion.getObservaciones());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(planeacionyOrganizacionService.save(planeacionyOrganizacionBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		planeacionyOrganizacionService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
