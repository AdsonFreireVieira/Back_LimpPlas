package com.back_LimpPlast.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.Produtos;
import com.back_LimpPlast.model.itens_Pedido;

@Component
public class pedidoServiceImpl implements IServicePedido {

	@Autowired
	private PedidoDao dao;

	@Override
	public Pedidos cadastrarNovo(Pedidos pedido) {

		pedido.setQuantidade(0);
        
		
        
		for (itens_Pedido item : pedido.getItens()) {
			configuracaoPedido.calculaQuntidadeItens(pedido);
			pedido.setItens(configuracaoPedido.calcularValorItens(pedido));
			configuracaoPedido.calcularPedido(pedido);
			item.setPedidos(pedido);
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
		return dao.findAll();
	}

	@Override
	public Pedidos buscarPorId(int id) {

		return dao.findById(id).orElse(null);
	}

	@Override
	public void deletarPedido(int id) {
		dao.deleteById(id);

	}

}
