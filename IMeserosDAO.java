package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Meseros;

public interface IMeserosDAO extends JpaRepository<Meseros, Integer> {

}