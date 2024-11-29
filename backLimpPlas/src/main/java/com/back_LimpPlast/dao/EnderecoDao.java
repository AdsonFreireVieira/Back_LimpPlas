package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.back_LimpPlast.model.Endereco;

public interface EnderecoDao extends CrudRepository<Endereco, Integer> {
	

}
