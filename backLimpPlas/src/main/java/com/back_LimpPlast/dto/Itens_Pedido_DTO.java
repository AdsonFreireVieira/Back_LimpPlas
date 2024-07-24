package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.itens_Pedido;

public class Itens_Pedido_DTO {

	private Integer id;
	private int quantidade;
	private double valorItens;

	private ProdutoDTO produto_DTO;
	private Pedido_DTO pedidoDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorItens() {
		return valorItens;
	}

	public void setValorItens(double valorItens) {
		this.valorItens = valorItens;
	}

	public ProdutoDTO getProduto_DTO() {
		return produto_DTO;
	}

	public void setProduto_DTO(ProdutoDTO produto_DTO) {
		this.produto_DTO = produto_DTO;
	}

	public Pedido_DTO getPedidoDTO() {
		return pedidoDTO;
	}

	public void setPedidoDTO(Pedido_DTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}

	public Itens_Pedido_DTO() {
		// TODO Auto-generated constructor stub
	}

	public static Itens_Pedido_DTO convertToItensDTO(itens_Pedido itens) {

		var itens_DTO = new Itens_Pedido_DTO();

		itens_DTO.setId(itens.getId());
		itens_DTO.setQuantidade(itens.getQuantidade());
		itens_DTO.setValorItens(itens.getValorItens());
		itens_DTO.setProduto_DTO(ProdutoDTO.convertParaProdutoDTO(itens.getProduto()));
		itens_DTO.setPedidoDTO(Pedido_DTO.convertToPedidoDTO(itens.getPedidos()));
		
		return itens_DTO;

	}

	public static itens_Pedido convertTO_ITens_PEdido(Itens_Pedido_DTO itensDTO) {

		var itens_Pedido = new itens_Pedido();

		itens_Pedido.setId(itensDTO.getId());
		itens_Pedido.setQuantidade(itensDTO.getQuantidade());
		itens_Pedido.setValorItens(itensDTO.getValorItens());
		itens_Pedido.setProduto(ProdutoDTO.convertParaProduto(itensDTO.getProduto_DTO()));
		itens_Pedido.setPedidos(Pedido_DTO.convetToPedido(itensDTO.getPedidoDTO()));
		return itens_Pedido;

	}

	public static List<Itens_Pedido_DTO> convertListToItensDTO(List<itens_Pedido> itensList) {

		return itensList.stream().map(Itens_Pedido_DTO::convertToItensDTO).collect(Collectors.toList());

	}
	
	public static List<itens_Pedido> convertToListITensPedido(List<Itens_Pedido_DTO>  itensDTO){
	
		
		return itensDTO.stream().map(Itens_Pedido_DTO :: convertTO_ITens_PEdido).collect(Collectors.toList());
	}

	
	
	
	
}
