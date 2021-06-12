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
import edu.uspg.model.Mesas;
import edu.uspg.service.IMesasService;

@RestController
@RequestMapping("/mesas")
public class MesasController {

	@Autowired
	private IMesasService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Mesas>> listar(){
		return new ResponseEntity<List<Mesas>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mesas> listarPorId(@PathVariable("id") Integer id){
		Optional<Mesas> mesas = service.listarPorId(id);
		if(!mesas.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<Mesas>(mesas.get(),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Mesas mesa) {
		Mesas mesas = new Mesas();
		mesas = service.registrar(mesas);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mesas.getIdMesas()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Mesas mesas){
		service.modificar(mesas);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}