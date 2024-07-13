package com.back_LimpPlast.service.pedido;

import java.util.List;

import com.back_LimpPlast.dto.pedidoDTO;
import com.back_LimpPlast.model.Pedidos;

public interface IServicePedido {
	
	public  pedidoDTO cadastrarNovo(Pedidos pedido);
	
	public pedidoDTO alterarPedido(Pedidos alterar);
	
	public List<pedidoDTO>  listarPedido();
	
	public pedidoDTO buscarPorId(int id);
	
	public void deletarPedido(int id);
	
	

}
