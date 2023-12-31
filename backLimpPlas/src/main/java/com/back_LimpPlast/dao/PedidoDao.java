package com.back_LimpPlast.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByData(Date data);
}
