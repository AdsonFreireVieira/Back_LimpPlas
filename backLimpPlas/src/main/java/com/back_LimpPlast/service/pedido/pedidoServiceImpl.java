package com.back_LimpPlast.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.dto.Itens_Pedido_DTO;
import com.back_LimpPlast.dto.PedidoDTO;
import com.back_LimpPlast.model.itens_Pedido;

@Component
public class pedidoServiceImpl implements IServicePedido {

	@Autowired
	private PedidoDao dao;

	@Override
	public PedidoDTO cadastrarNovo(PedidoDTO pDTO) {
        
		
        
		for (Itens_Pedido_DTO item : pDTO.getItens()) {
			
			
		}
            configuracaoPedido.calculaQuntidadeItens(pDTO);
			
			configuracaoPedido.calcularValorItens(pDTO);
			configuracaoPedido.calcularPedido(pDTO);
			configuracaoPedido.calcularDesconto(pDTO);
			
			
			var pedidos = PedidoDTO.convetToPedido(pDTO);
			
			
		return  PedidoDTO.convertToPedidoDTO(dao.save(pedidos)) ;
	}

	@Override
	public PedidoDTO alterarPedido(PedidoDTO alterar) {
    
		 
		
		for ( Itens_Pedido_DTO itensDTO : alterar.getItens()){
         
				
		   
             
		}
		
		var  pedido = PedidoDTO.convetToPedido(alterar);
		
		return PedidoDTO.convertToPedidoDTO(dao.save(pedido));
	}

	@Override
	public List<PedidoDTO> listarPedido() {
		// TODO Auto-generated method stub
		return  PedidoDTO.convertListToDTO(dao.findAll());
	}

	@Override
	public PedidoDTO buscarPorId(int id) {

		return  PedidoDTO.convertToPedidoDTO(dao.findById(id).orElse(null));
	}

	@Override
	public void deletarPedido(int id) {
		dao.deleteById(id);

	}

}
