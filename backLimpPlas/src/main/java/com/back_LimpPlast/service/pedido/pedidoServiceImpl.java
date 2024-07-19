package com.back_LimpPlast.service.pedido;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.dto.Itens_Pedido_DTO;
import com.back_LimpPlast.dto.pedidoDTO;

@Component
public class pedidoServiceImpl implements IServicePedido {

	@Autowired
	private PedidoDao dao;

	@Override
	public pedidoDTO cadastrarNovo(pedidoDTO pDTO) {
        
		
        
		for (Itens_Pedido_DTO item : pDTO.getItensDTO()) {
			
			item.setPedidoDTO(pDTO);
		}
            configuracaoPedido.calculaQuntidadeItens(pDTO);
			
			configuracaoPedido.calcularValorItens(pDTO);
			configuracaoPedido.calcularPedido(pDTO);
			configuracaoPedido.calcularDesconto(pDTO);
			
			
			var pedidos = pedidoDTO.convertPedidos(pDTO);
			
			
		return  pedidoDTO.convertDTO(dao.save(pedidos)) ;
	}

	@Override
	public pedidoDTO alterarPedido(pedidoDTO alterar) {

		for (Itens_Pedido_DTO itens : alterar.getItensDTO()) {

			itens.setPedidoDTO(alterar);
		}
		
		var  pedido = pedidoDTO.convertPedidos(alterar);
		
		return pedidoDTO.convertDTO(dao.save(pedido));
	}

	@Override
	public List<pedidoDTO> listarPedido() {
		// TODO Auto-generated method stub
		return  pedidoDTO.toListDTO(dao.findAll());
	}

	@Override
	public pedidoDTO buscarPorId(int id) {

		return  pedidoDTO.convertDTO(dao.findById(id).orElse(null));
	}

	@Override
	public void deletarPedido(int id) {
		dao.deleteById(id);

	}

}
