package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IClientesDAO;
import edu.uspg.model.Clientes;
import edu.uspg.service.IClientesService;

@Service
public class ClientesServiceImpl implements IClientesService {

	@Autowired
	private IClientesDAO dao;
	
	@Override
	public Clientes registrar(Clientes t) {
		return dao.save(t);
	}

	@Override
	public Clientes modificar(Clientes t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Clientes> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Clientes> listar() {
		return dao.findAll();
	}

}