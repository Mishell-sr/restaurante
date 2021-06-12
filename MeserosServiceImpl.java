package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IMeserosDAO;
import edu.uspg.model.Meseros;
import edu.uspg.service.IMeserosService;

@Service
public class MeserosServiceImpl implements IMeserosService {

	@Autowired
	private IMeserosDAO dao;
	
	@Override
	public Meseros registrar(Meseros t) {
		return dao.save(t);
	}

	@Override
	public Meseros modificar(Meseros t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Meseros> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Meseros> listar() {
		return dao.findAll();
	}

}