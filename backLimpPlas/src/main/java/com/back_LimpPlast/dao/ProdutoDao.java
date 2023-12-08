package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.Produtos;

public interface ProdutoDao extends JpaRepository<Produtos, Integer> {

}
