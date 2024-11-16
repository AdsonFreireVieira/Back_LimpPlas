package com.back_LimpPlast.dao;


import org.springframework.data.repository.CrudRepository;

import com.back_LimpPlast.model.Pedidos;

public interface PedidoDao extends CrudRepository<Pedidos, Integer> {

}
