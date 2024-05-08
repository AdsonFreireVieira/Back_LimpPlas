package com.back_LimpPlast.service.pedido;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.model.itens_Pedido;
import com.back_LimpPlast.model.pedido;

@Component
public class pedidoServiceImpl implements IServicePedido {

	@Autowired
	private PedidoDao dao;
       
	@Override
	public pedido cadastrarNovo(pedido pedido) {
		
		for(itens_Pedido item: pedido.getItens() ) {
			
			item.setPedidos(pedido);
		}

		return dao.save(pedido);
	}

	@Override
	public pedido alterarPedido(pedido alterar) {

		return dao.save(alterar);
	}

	@Override
	public List<pedido> listarPedido() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

	@Override
	public pedido buscarPorId(int id) {

		return dao.findById(id).orElse(null);
	}

	
}
