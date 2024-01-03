package com.back_LimpPlast.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.pedido;

public interface PedidoDao extends JpaRepository<pedido, Integer> {

	List<pedido> findByData(Date data);
}
