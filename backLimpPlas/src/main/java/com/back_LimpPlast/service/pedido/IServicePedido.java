package com.back_LimpPlast.service.pedido;

import java.util.Date;
import java.util.List;

import com.back_LimpPlast.model.Pedido;

public interface IServicePedido {
	
	public  Pedido cadastrarNovo(Pedido pedido);
	
	public Pedido alterarPedido(Pedido alterar);
	
	public List<Pedido>  listarPedido();
	
	public void deletarPedido(int id);
	
	public Pedido buscarPorId(int id);
	
	public List<Pedido> BuscarPorData(Date date);

}
