package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Platillos;

public interface IPlatillosDAO extends JpaRepository<Platillos, Integer> {

}