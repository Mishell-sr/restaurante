package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Mesas;

public interface IMesasDAO extends JpaRepository<Mesas, Integer> {

}