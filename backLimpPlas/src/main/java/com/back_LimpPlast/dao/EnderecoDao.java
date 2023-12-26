package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.Endereco;

public interface EnderecoDao extends JpaRepository<Endereco, Integer> {
	
	public Endereco findByNumber(int number);

}
