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
import edu.uspg.model.Clientes;
import edu.uspg.service.IClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private IClientesService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Clientes>> listar(){
		return new ResponseEntity<List<Clientes>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clientes> listarPorId(@PathVariable("id") Integer id){
		Optional<Clientes> clientes = service.listarPorId(id);
		if(!clientes.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<Clientes>(clientes.get(),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Clientes cliente) {
		Clientes clientes = new Clientes();
		clientes = service.registrar(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientes.getIdCliente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Clientes cliente){
		service.modificar(cliente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}