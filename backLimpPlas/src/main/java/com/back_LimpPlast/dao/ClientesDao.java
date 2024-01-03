package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.clientes;

public interface ClientesDao extends JpaRepository<clientes, Integer> {

	
	public clientes findByNome(String nome);
}
