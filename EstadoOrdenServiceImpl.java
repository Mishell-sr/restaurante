package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IEstadoOrdenDAO;
import edu.uspg.model.EstadoOrden;
import edu.uspg.service.IEstadoOrdenService;

@Service
public class EstadoOrdenServiceImpl implements IEstadoOrdenService {

	@Autowired
	private IEstadoOrdenDAO dao;
	
	@Override
	public EstadoOrden registrar(EstadoOrden t) {
		return dao.save(t);
	}

	@Override
	public EstadoOrden modificar(EstadoOrden t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<EstadoOrden> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<EstadoOrden> listar() {
		return dao.findAll();
	}

}