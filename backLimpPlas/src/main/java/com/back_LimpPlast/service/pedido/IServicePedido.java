package com.back_LimpPlast.service.pedido;

import java.util.List;

import dto.PedidoDTO;



public interface IServicePedido {
	
	public  PedidoDTO cadastrarNovo(PedidoDTO pedido);
	
	public PedidoDTO alterarPedido(PedidoDTO alterar);
	
	public List<PedidoDTO>  listarPedido();
	
	public PedidoDTO buscarPorId(int id);
	
	public void deletarPedido(int id);
	
	

}
