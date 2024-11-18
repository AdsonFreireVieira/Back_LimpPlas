package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

}
