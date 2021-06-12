package edu.uspg.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.uspg.exception.ModeloNotFoundException;
import edu.uspg.model.EstadoOrden;
import edu.uspg.service.IEstadoOrdenService;

@RestController
@RequestMapping("/estado_Orden")
public class EstadoOrdenController {

	@Autowired
	private IEstadoOrdenService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadoOrden>> listar(){
		return new ResponseEntity<List<EstadoOrden>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadoOrden> listarPorId(@PathVariable("id") Integer id){
		Optional<EstadoOrden> estado_Orden = service.listarPorId(id);
		if(!estado_Orden.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<EstadoOrden>(estado_Orden.get(),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody EstadoOrden estadoOrden) {
		EstadoOrden estado_Orden = new EstadoOrden();
		estado_Orden = service.registrar(estadoOrden);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estado_Orden.getIdestado_Orden()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody EstadoOrden estadoOrden){
		service.modificar(estadoOrden);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}