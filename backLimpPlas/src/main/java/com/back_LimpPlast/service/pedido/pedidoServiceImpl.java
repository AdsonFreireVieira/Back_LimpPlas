package com.back_LimpPlast.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.itens_Pedido;

@Component
public class pedidoServiceImpl implements IServicePedido {
	@Autowired
	private PedidoDao dao;

	@Override
	public Pedidos cadastrarNovo(Pedidos pedido) {
		for (itens_Pedido itens : pedido.getItens()) {
			itens.setPedidos(pedido);
		}
		return dao.save(pedido);
	}

	@Override
	public Pedidos alterarPedido(Pedidos alterar) {
		for (itens_Pedido itens : alterar.getItens()) {
			itens.setPedidos(alterar);
		}
		return dao.save(alterar);
	}

	@Override
	public List<Pedidos> listarPedido() {
		// TODO Auto-generated method stub
		return    (List<Pedidos>) dao.findAll();
	}

	@Override
	public Pedidos buscarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deletarPedido(int id) {
		dao.deleteById(id);

	}

}