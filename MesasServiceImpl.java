package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IMesasDAO;
import edu.uspg.model.Mesas;
import edu.uspg.service.IMesasService;

@Service
public class MesasServiceImpl implements IMesasService {

	@Autowired
	private IMesasDAO dao;
	
	@Override
	public Mesas registrar(Mesas t) {
		return dao.save(t);
	}

	@Override
	public Mesas modificar(Mesas t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Mesas> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Mesas> listar() {
		return dao.findAll();
	}

}