package com.back_LimpPlast.service.pedido;

import com.back_LimpPlast.dto.pedidoDTO;
import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.itens_Pedido;

public class configuracaoPedido {

	public static void calculaQuntidadeItens(pedidoDTO pDTO) {

		int totalQuantidade = pedido.getItens().stream().mapToInt(itens_Pedido::getQuantidade).sum();

		pedido.setQuantidade(totalQuantidade);
	}

	public static void calcularPedido(pedidoDTO pDTO) {

		Double valor = pDTO;.getItens().stream()
				.mapToDouble(item ->  item.getValorItens()).sum();

		pedido.setValor_Total(valor);

	}

	public static void calcularDesconto(pedidoDTO pDTO) {
          
		double desconto = 0;
		double valor = pedido.getValor_Total();

		if (valor < 5000) {

			 desconto = valor * 0.05;
			 pedido.setDesconto(desconto);
			pedido.setValor_Total(valor - desconto);

		}
		else if(valor>=10000) {
			
			desconto = valor *0.10;
			pedido.setDesconto(desconto);
			pedido.setValor_Total(valor- desconto); 
			
		}
	}
	
	public static void calcularValorItens(pedidoDTO pDTO){
		
		  
	      
	 pedido.getItens().stream().forEach( item -> item.setValorItens(item.getQuantidade() * item.getProduto().getValor()));
		   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}