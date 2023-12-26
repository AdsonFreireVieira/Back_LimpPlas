package com.back_LimpPlast.service.pedido;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.model.Pedido;

@Component
public class pedidoServiceImpl implements IServicePedido {

	@Autowired
	private PedidoDao dao;

	@Override
	public Pedido cadastrarNovo(Pedido pedido) {

		return dao.save(pedido);
	}

	@Override
	public Pedido alterarPedido(Pedido alterar) {

		return dao.save(alterar);
	}

	@Override
	public List<Pedido> listarPedido() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deletarPedido(int id) {

		dao.deleteById(null);

	}

	@Override
	public Pedido buscarPorId(int id) {

		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Pedido> BuscarPorData(Date date) {

		return dao.findByDataRegistroAfter(date);
	}
}
