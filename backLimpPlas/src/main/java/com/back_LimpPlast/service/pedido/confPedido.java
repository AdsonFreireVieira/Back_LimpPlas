package com.back_LimpPlast.service.pedido;

import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.itens_Pedido;

public class confPedido {
	
	
	public  static void  calculaItens(Pedidos pedido) {
		
		int totalQuantidade = pedido.getItens()
                .stream()
                .mapToInt(itens_Pedido::getQuantidade)
                .sum();

         pedido.setQuantidade(totalQuantidade);
	}
	public static void calcularPedido(Pedidos pedido) {
	
		double valor =0;
		for(itens_Pedido itens: pedido.getItens()) {
		
			
		}
	}
	


}