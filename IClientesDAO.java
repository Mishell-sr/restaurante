package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Clientes;

public interface IClientesDAO extends JpaRepository<Clientes, Integer> {

}