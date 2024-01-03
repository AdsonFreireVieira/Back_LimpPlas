package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.endereco;

public interface EnderecoDao extends JpaRepository<endereco, Integer> {
	
	public endereco findByNumero(int number);

}
