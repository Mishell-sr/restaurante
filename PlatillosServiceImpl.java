package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IPlatillosDAO;
import edu.uspg.model.Platillos;
import edu.uspg.service.IPlatillosService;

@Service
public class PlatillosServiceImpl implements IPlatillosService {

	@Autowired
	private IPlatillosDAO dao;
	
	@Override
	public Platillos registrar(Platillos t) {
		return dao.save(t);
	}

	@Override
	public Platillos modificar(Platillos t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Platillos> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Platillos> listar() {
		return dao.findAll();
	}

}