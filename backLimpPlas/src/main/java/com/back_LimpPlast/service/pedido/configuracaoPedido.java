package com.back_LimpPlast.service.pedido;

import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.itens_Pedido;

public class configuracaoPedido {

	public static void calculaQuntidadeItens(Pedidos pedido) {

		int totalQuantidade = pedido.getItens().stream().mapToInt(itens_Pedido::getQuantidade).sum();

		pedido.setQuantidade(totalQuantidade);
	}

	public static void calcularPedido(Pedidos pedido) {

		Double valor = pedido.getItens().stream()
				.mapToDouble(item -> item.getProduto().getValor() * item.getQuantidade()).sum();

		pedido.setValor_Total(valor);

	}

	public static void calcularDesconto(Pedidos pedido) {
          
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
			
		}else {
			
			pedido.setDesconto(desconto);
		}
	}

}