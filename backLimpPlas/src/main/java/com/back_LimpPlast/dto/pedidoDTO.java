package com.back_LimpPlast.dto;

import java.sql.Date;
import java.util.List;

public class pedidoDTO {
	
	private Integer id;
	private  Date data;
	private int quantidade;
	private double desconto;
    private String status;
    private double valor_total;
    
    private UserDTO userDTo;
    
    private List<Itens_Pedido_DTO> itensDTO;
    
    
    
    
	public UserDTO getUserDTo() {
		return userDTo;
	}
	public void setUserDTo(UserDTO userDTo) {
		this.userDTo = userDTo;
	}
	public List<Itens_Pedido_DTO> getItensDTO() {
		return itensDTO;
	}
	public void setItensDTO(List<Itens_Pedido_DTO> itensDTO) {
		this.itensDTO = itensDTO;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
    
    

}
