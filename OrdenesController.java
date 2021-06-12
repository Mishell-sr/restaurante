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
import edu.uspg.model.Ordenes;
import edu.uspg.service.IOrdenesService;

@RestController
@RequestMapping("/ordenes")
public class OrdenesController {

	@Autowired
	private IOrdenesService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ordenes>> listar(){
		return new ResponseEntity<List<Ordenes>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ordenes> listarPorId(@PathVariable("id") Integer id){
		Optional<Ordenes> ordenes = service.listarPorId(id);
		if(!ordenes.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<Ordenes>(ordenes.get(),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Ordenes orden) {
		Ordenes ordenes = new Ordenes();
		ordenes = service.registrar(orden);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordenes.getIdOrden()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Ordenes orden){
		service.modificar(orden);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}