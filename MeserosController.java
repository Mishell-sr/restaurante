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
import edu.uspg.model.Meseros;
import edu.uspg.service.IMeserosService;

@RestController
@RequestMapping("/meseros")
public class MeserosController {

	@Autowired
	private IMeserosService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Meseros>> listar(){
		return new ResponseEntity<List<Meseros>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Meseros> listarPorId(@PathVariable("id") Integer id){
		Optional<Meseros> meseros = service.listarPorId(id);
		if(!meseros.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<Meseros>(meseros.get(),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Meseros mesero) {
		Meseros meseros = new Meseros();
		meseros = service.registrar(mesero);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(meseros.getIdMesero()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Meseros mesero){
		service.modificar(mesero);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}