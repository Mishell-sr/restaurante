package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IOrdenesDAO;
import edu.uspg.model.Ordenes;
import edu.uspg.service.IOrdenesService;

@Service
public class OrdenesServiceImpl implements IOrdenesService {

	@Autowired
	private IOrdenesDAO dao;
	
	@Override
	public Ordenes registrar(Ordenes t) {
		return dao.save(t);
	}

	@Override
	public Ordenes modificar(Ordenes t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Ordenes> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Ordenes> listar() {
		return dao.findAll();
	}

}