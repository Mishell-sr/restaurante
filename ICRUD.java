package edu.uspg.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
	T registrar(T t);
	T modificar(T t);
	void eliminar(int id);
	Optional<T> listarPorId(int id);
	List<T> listar();
}