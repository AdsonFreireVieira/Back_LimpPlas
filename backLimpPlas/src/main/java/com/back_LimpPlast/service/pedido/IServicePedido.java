package com.back_LimpPlast.service.pedido;

import java.util.List;

import com.back_LimpPlast.model.Pedidos;

public interface IServicePedido {
	
	public  Pedidos cadastrarNovo(Pedidos pedido);
	
	public Pedidos alterarPedido(Pedidos alterar);
	
	public List<Pedidos>  listarPedido();
	
	public Pedidos buscarPorId(int id);
	
	public void deletarPedido(int id);
	
	

}
