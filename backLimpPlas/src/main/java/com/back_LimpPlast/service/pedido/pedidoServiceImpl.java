package com.back_LimpPlast.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.dto.Itens_Pedido_DTO;
import com.back_LimpPlast.dto.Pedido_DTO;
import com.back_LimpPlast.model.itens_Pedido;

@Component
public class pedidoServiceImpl implements IServicePedido {

	@Autowired
	private PedidoDao dao;

	@Override
	public Pedido_DTO cadastrarNovo(Pedido_DTO pDTO) {
        
		
        
		for (Itens_Pedido_DTO item : pDTO.getItens()) {
			
			item.setPedidoDTO(pDTO);
		}
            configuracaoPedido.calculaQuntidadeItens(pDTO);
			
			configuracaoPedido.calcularValorItens(pDTO);
			configuracaoPedido.calcularPedido(pDTO);
			configuracaoPedido.calcularDesconto(pDTO);
			
			
			var pedidos = Pedido_DTO.convetToPedido(pDTO);
			
			
		return  Pedido_DTO.convertToPedidoDTO(dao.save(pedidos)) ;
	}

	@Override
	public Pedido_DTO alterarPedido(Pedido_DTO alterar) {
    
		 
		
		for ( Itens_Pedido_DTO itensDTO : alterar.getItens()){
         
		  itensDTO.setPedidoDTO(alterar);
		
		   
             
		}
		
		var  pedido = Pedido_DTO.convetToPedido(alterar);
		
		return Pedido_DTO.convertToPedidoDTO(dao.save(pedido));
	}

	@Override
	public List<Pedido_DTO> listarPedido() {
		// TODO Auto-generated method stub
		return  Pedido_DTO.convertListToDTO(dao.findAll());
	}

	@Override
	public Pedido_DTO buscarPorId(int id) {

		return  Pedido_DTO.convertToPedidoDTO(dao.findById(id).orElse(null));
	}

	@Override
	public void deletarPedido(int id) {
		dao.deleteById(id);

	}

}
