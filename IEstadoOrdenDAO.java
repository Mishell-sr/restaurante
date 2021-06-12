package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.EstadoOrden;

public interface IEstadoOrdenDAO extends JpaRepository<EstadoOrden, Integer> {

}