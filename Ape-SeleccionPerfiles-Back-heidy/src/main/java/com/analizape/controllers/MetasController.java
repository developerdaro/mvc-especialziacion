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
import com.analizape.models.Metas;
import com.analizape.services.MetasService;


@RestController
@RequestMapping("/metas")
@CrossOrigin(origins = "http://localhost:4200")
public class MetasController {


	@Autowired
	private MetasService metasService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(metasService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<Metas>o=metasService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Metas metas){
		Metas OperatorBD=metasService.save(metas);
		return ResponseEntity.status(HttpStatus.CREATED).body(metasService.save(OperatorBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody Metas metas){
		Optional<Metas>o=metasService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Metas metasBD=o.get();
		metasBD.setMetas_corto_plazo(metas.getMetas_corto_plazo());
		metasBD.setMetas_mediano_plazo(metas.getMetas_mediano_plazo());
		metasBD.setMetas_largo_plazo(metas.getMetas_largo_plazo());
		metasBD.setCalificacion(metas.getCalificacion());
		metasBD.setObservaciones(metas.getObservaciones());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(metasService.save(metasBD));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarMeta(@PathVariable Integer id){
		Metas metas = metasService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcepcion("No existe un registro con el ID: "+ id));
		
		metasService.deleteById(id);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);	
		}
	
}
