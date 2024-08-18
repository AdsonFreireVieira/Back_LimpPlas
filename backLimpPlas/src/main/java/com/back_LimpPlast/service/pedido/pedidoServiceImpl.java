package com.back_LimpPlast.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.itens_Pedido;


import dto.ItensPedidoDTO;
import dto.PedidoDTO;
import mapper.GenericModelMapper;


@Component
public class pedidoServiceImpl implements IServicePedido {

	@Autowired
	private PedidoDao dao;
	
          GenericModelMapper<PedidoDTO, Pedidos> mapperToPedido = new GenericModelMapper<>(Pedidos.class);
	GenericModelMapper<Pedidos, PedidoDTO> mapperToPedidoDTO = new GenericModelMapper<>(PedidoDTO.class);
	

	@Override
	public PedidoDTO cadastrarNovo(PedidoDTO pDTO) {
        
        
		for (ItensPedidoDTO items : pDTO.getItens()){
			
		  items.setPedido(pDTO);
			
		}
            configuracaoPedido.calculaQuntidadeItens(pDTO);
			
			configuracaoPedido.calcularValorItens(pDTO);
			configuracaoPedido.calcularPedido(pDTO);
			configuracaoPedido.calcularDesconto(pDTO);
			
			Pedidos pd = mapperToPedido.map(pDTO);
	      
		  return   mapperToPedidoDTO.map(dao.save(pd));
			
			
			
	
		
	}

	@Override
	public PedidoDTO alterarPedido(PedidoDTO alterar) {
     
		
		for ( ItensPedidoDTO itens : alterar.getItens()){
         
				
		   itens.setPedido(alterar);
             
		}
		
		 
		Pedidos ped = mapperToPedido.map(alterar);
		
		 return mapperToPedidoDTO.map(dao.save(ped));
		 
  
		
		
	}

	@Override
	public List<PedidoDTO> listarPedido() {
		
		return mapperToPedidoDTO.mapList(dao.findAll());
	}

	@Override
	public PedidoDTO buscarPorId(int id) {

		return  mapperToPedidoDTO.map(dao.findById(id).orElse(null));
	}

	@Override
	public void deletarPedido(int id) {
		dao.deleteById(id);

	}

}
