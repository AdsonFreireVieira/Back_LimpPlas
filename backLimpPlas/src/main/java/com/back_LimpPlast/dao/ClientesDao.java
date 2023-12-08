package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.Clientes;

public interface ClientesDao extends JpaRepository<Clientes, Integer> {

}
