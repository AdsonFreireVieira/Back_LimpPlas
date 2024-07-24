package com.back_LimpPlast.service.pedido;

import com.back_LimpPlast.dto.Pedido_DTO;

public class configuracaoPedido {

	public static void calculaQuntidadeItens(Pedido_DTO pDTO) {
		
		 int  total = pDTO.getItens().stream().mapToInt(value -> value.getQuantidade()).sum();
		
		pDTO.setQuantidade(total);
	}

	public static void calcularPedido(Pedido_DTO pDTO) {

		Double valor = pDTO.getItens().stream()
				.mapToDouble(item ->  item.getValorItens()).sum();

		pDTO.setValor_total(valor);

	}

	public static void calcularDesconto(Pedido_DTO pDTO) {
          
		double desconto = 0;
		double valor = pDTO.getValor_total();
		if (valor < 5000) {

			 desconto = valor * 0.05;
			  pDTO.setDesconto(desconto);
			pDTO.setValor_total(valor - desconto);

		}
		else if(valor>=10000) {
			
			desconto = valor *0.10;
			pDTO.setDesconto(desconto);
			pDTO.setValor_total(valor - desconto); 
			
		}
	}
	
	public static void calcularValorItens(Pedido_DTO pDTO){
		
		 
		pDTO.getItens().stream().forEach(item -> item.setValorItens(item.getQuantidade()* item.getProduto_DTO().getValor()));
	  
		   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}