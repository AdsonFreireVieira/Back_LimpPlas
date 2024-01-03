package com.back_LimpPlast.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.produtos;

public interface ProdutoDao extends JpaRepository<produtos, Integer> {

	
	 List<produtos> findAllByclassificacao( produtos prod);
}
