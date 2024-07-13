package com.back_LimpPlast.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public pedidoDTO(int id,LocalDate data, int quantidade, double desconto,String status, double valor_total) {
		
		this.id = id;
		this.data = data;
		this.quantidade = quantidade;
		this.desconto = desconto;
        this.status = status;
        this.valor_total = valor_total;
		
	}
	
	
	public static List<pedidoDTO> toListDTO(List<Pedidos> listPedidos){
	
     
		
		
	}
	

    public static pedidoDTO toDTO(Pedidos pedido) {
    	
    var pedDTO = new pedidoDTO();
    
    var userDTO  =  UserDTO.converttoDTO(pedido.getCliente());
    
      pedDTO.setId(pedido.getId());
      pedDTO.setData(pedido.getData());  
      pedDTO.setDesconto(pedido.getDesconto());
      pedDTO.setValor_total(pedido.getValor_Total());
      pedDTO.setQuantidade(pedido.getQuantidade());
      pedDTO.setStatus(pedido.getStatus());
      
      pedDTO.setUserDTo(userDTO);;
      
      return pedDTO;
      
      
      
    	
    }
   

}








