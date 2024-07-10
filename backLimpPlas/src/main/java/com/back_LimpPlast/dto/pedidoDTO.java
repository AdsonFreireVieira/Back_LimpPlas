package com.back_LimpPlast.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.back_LimpPlast.model.Pedidos;

public class pedidoDTO {
	
	private Integer id;
	private  LocalDate data;
	private int quantidade;
	private double desconto;
    private String status;
    private double valor_total;
    
    private UserDTO userDTo;
    private List<Itens_Pedido_DTO> itensDTO;
    
 
    public pedidoDTO() {
		// TODO Auto-generated constructor stub
	}
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
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
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
	
    
   
    	
    public static pedidoDTO(Pedidos pedido) {
    	
    	pedidoDTO   DTO = new pedidoDTO();
    	
    	 var uDTO =UserDTO.toDTO(pedido.getCliente());
    	 var listDTO = 

    	DTO.setId(pedido.getId());
        DTO.setData(pedido.getData());
        DTO.setQuantidade(pedido.getQuantidade());
        DTO.setStatus(pedido.getStatus());
        DTO.setDesconto(pedido.getDesconto());
        DTO.setValor_total(pedido.getValor_Total());
        DTO.setUserDTo(uDTO);
        DTO.setItensDTO();
        
        
        
        
    }

}








