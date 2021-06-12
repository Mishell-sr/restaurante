package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Ordenes;

public interface IOrdenesDAO extends JpaRepository<Ordenes, Integer> {

}