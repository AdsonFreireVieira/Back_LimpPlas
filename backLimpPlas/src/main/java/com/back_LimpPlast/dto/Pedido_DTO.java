package com.back_LimpPlast.dto;

import java.time.LocalDate;
import java.util.List;

import com.back_LimpPlast.model.Pedidos;

public class Pedido_DTO {

	private Integer id;
	private LocalDate data;
	private double desconto;
	private int quantidade;
	private double valor_total;
	private String status;

	private UserDTO cliente;
	private List<Itens_Pedido_DTO> itens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDTO getCliente() {
		return cliente;
	}

	public void setCliente(UserDTO cliente) {
		this.cliente = cliente;
	}

	public List<Itens_Pedido_DTO> getItens() {
		return itens;
	}

	public void setItens(List<Itens_Pedido_DTO> itens) {
		this.itens = itens;
	}

	public Pedido_DTO() {
		// TODO Auto-generated constructor stub
	}

	public static Pedido_DTO convertToPedidoDTO(Pedidos pedido) {

		var pedidoDTO = new Pedido_DTO();

		pedidoDTO.setId(pedido.getId());
		pedidoDTO.setData(pedido.getData());
		pedidoDTO.setDesconto(pedido.getDesconto());
		pedidoDTO.setQuantidade(pedido.getQuantidade());
		pedidoDTO.setStatus(pedido.getStatus());
		pedidoDTO.setValor_total(pedido.getValor_Total());

		pedidoDTO.setCliente(UserDTO.convertToUserDTO(pedido.getCliente()));
		pedidoDTO.setItens(Itens_Pedido_DTO.convertListToItensDTO(pedido.getItens()));

		return pedidoDTO;
	}

       
	public static  Pedidos convetToItensPedido( Pedido_DTO pedidoDTO) {
		
		var pedido = new Pedidos();
		
		pedido.setId(pedidoDTO.getId());
		pedido.setData(pedidoDTO.getData());
		pedido.setQuantidade(pedidoDTO.getQuantidade());
		pedido.setDesconto(pedidoDTO.getDesconto());
		pedido.setStatus(pedidoDTO.getStatus());
		pedido.setValor_Total(pedidoDTO.getValor_total());
        
		pedido.setCliente(UserDTO.convertToUser(pedidoDTO.getCliente()));
		pedido.setItens( Itens_Pedido_DTO.convertToListITensPedido(pedidoDTO.getItens()));
		
		return pedido;
        
       
		
	}
















}
