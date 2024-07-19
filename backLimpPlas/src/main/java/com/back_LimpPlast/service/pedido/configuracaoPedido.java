package com.back_LimpPlast.service.pedido;



import com.back_LimpPlast.dto.pedidoDTO;

public class configuracaoPedido {

	public static void calculaQuntidadeItens(pedidoDTO pDTO) {
		
		 int  total = pDTO.getItensDTO().stream().mapToInt(value -> value.getQuantidade()).sum();
		
		pDTO.setQuantidade(total);
	}

	public static void calcularPedido(pedidoDTO pDTO) {

		Double valor = pDTO.getItensDTO().stream()
				.mapToDouble(item ->  item.getValor_itens()).sum();

		pDTO.setValor_total(valor);

	}

	public static void calcularDesconto(pedidoDTO pDTO) {
          
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
	
	public static void calcularValorItens(pedidoDTO pDTO){
		
		 
		pDTO.getItensDTO().stream().forEach(item -> item.setValor_itens(item.getQuantidade()* item.getProdutoDTO().getValor()));
	  
		   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}