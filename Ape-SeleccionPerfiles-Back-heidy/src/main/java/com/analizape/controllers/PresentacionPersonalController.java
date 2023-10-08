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
import com.analizape.models.PresentacionPersonal;
import com.analizape.models.Rol;
import com.analizape.repository.PresentacionPersonalRepository;
import com.analizape.services.PresentacionPersonalService;

@RestController
@RequestMapping("/presentacionPnal")
@CrossOrigin(origins = "http://localhost:4200")
public class PresentacionPersonalController {

	@Autowired
	private PresentacionPersonalService presentacionPersonalService;

	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(presentacionPersonalService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> verId(@PathVariable Integer  id){
		Optional<PresentacionPersonal>o=presentacionPersonalService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody PresentacionPersonal presentacionPersonal){
		PresentacionPersonal PresentacionPersonalBD=presentacionPersonalService.save(presentacionPersonal);
		return ResponseEntity.status(HttpStatus.CREATED).body(presentacionPersonalService.save(PresentacionPersonalBD));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar (@PathVariable Integer  id, @RequestBody PresentacionPersonal presentacionPersonal){
		Optional<PresentacionPersonal>o=presentacionPersonalService.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		PresentacionPersonal presentacionPersonalBD=o.get();
		presentacionPersonalBD.setPresentacion_personal(presentacionPersonal.getPresentacion_personal());
		presentacionPersonalBD.setCalificacion(presentacionPersonal.getCalificacion());
		presentacionPersonalBD.setObservaciones(presentacionPersonal.getObservaciones());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(presentacionPersonalService.save(presentacionPersonalBD));
	}
	
	
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> eliminar(@PathVariable Integer  id){
		//presentacionPersonalService.deleteById(id);
		//return ResponseEntity.noContent().build();
		//}

	//Método para eliminar un registro
	@DeleteMapping("/presentacionPnal/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarRegistroPresentacionPersonal(@PathVariable Integer id) {
		PresentacionPersonal registroPresentacionPersonal = presentacionPersonalService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExcepcion("No existe un registro con el ID: " + id));

		presentacionPersonalService.deleteById(id);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
