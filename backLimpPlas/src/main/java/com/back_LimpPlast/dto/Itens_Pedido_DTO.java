package com.back_LimpPlast.dto;

public class Itens_Pedido_DTO {
	
	private Integer id_Itens;
	private	 int quantidade;
	private double valor_itens;
	
	private ProdutoDTO produtoDTO;
	private pedidoDTO pedidoDTO;
	public Integer getId_Itens() {
		return id_Itens;
	}
	public void setId_Itens(Integer id_Itens) {
		this.id_Itens = id_Itens;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor_itens() {
		return valor_itens;
	}
	public void setValor_itens(double valor_itens) {
		this.valor_itens = valor_itens;
	}
	public ProdutoDTO getProdutoDTO() {
		return produtoDTO;
	}
	public void setProdutoDTO(ProdutoDTO produtoDTO) {
		this.produtoDTO = produtoDTO;
	}
	public pedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}
	public void setPedidoDTO(pedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}
	
	
	
	

}
