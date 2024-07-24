package com.back_LimpPlast.service.pedido;

import java.util.List;

import com.back_LimpPlast.dto.Pedido_DTO;

public interface IServicePedido {
	
	public  Pedido_DTO cadastrarNovo(Pedido_DTO pedido);
	
	public Pedido_DTO alterarPedido(Pedido_DTO alterar);
	
	public List<Pedido_DTO>  listarPedido();
	
	public Pedido_DTO buscarPorId(int id);
	
	public void deletarPedido(int id);
	
	

}
