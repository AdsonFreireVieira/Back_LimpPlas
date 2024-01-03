package com.back_LimpPlast.service.pedido;

import java.util.Date;
import java.util.List;

import com.back_LimpPlast.model.pedido;

public interface IServicePedido {
	
	public  pedido cadastrarNovo(pedido pedido);
	
	public pedido alterarPedido(pedido alterar);
	
	public List<pedido>  listarPedido();
	
	public pedido buscarPorId(int id);
	
	public List<pedido> BuscarPorData(Date date);

}
