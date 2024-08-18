package com.back_LimpPlast.service.pedido;

import dto.PedidoDTO;

public class configuracaoPedido {

	public static void calculaQuntidadeItens(PedidoDTO pDTO) {
		
		 int  total = pDTO.getItens().stream().mapToInt(value -> value.getQuantidade()).sum();
		
		pDTO.setQuantidade(total);
	}

	public static void calcularPedido(PedidoDTO pDTO) {

		Double valor = pDTO.getItens().stream()
				.mapToDouble(item ->  item.getValorItens()).sum();

		pDTO.setValorTotal(valor);

	}

	public static void calcularDesconto(PedidoDTO pDTO) {
          
		double desconto = 0;
		double valor = pDTO.getValorTotal();
		if (valor < 5000) {

			 desconto = valor * 0.05;
			  pDTO.setDesconto(desconto);
			pDTO.setValorTotal(valor - desconto);

		}
		else if(valor>=10000) {
			
			desconto = valor *0.10;
			pDTO.setDesconto(desconto);
			pDTO.setValorTotal(valor - desconto); 
			
		}
	}
	
	public static void calcularValorItens(PedidoDTO pDTO){
		
		 
	  
		   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}