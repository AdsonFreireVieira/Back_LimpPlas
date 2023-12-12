package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.Pedido;

public interface PedidoDao  extends JpaRepository<Pedido, Integer> {

}
