package com.back_LimpPlast.controller.entradaDTO;

import com.back_LimpPlast.model.clientes;
import com.back_LimpPlast.model.endereco;

public class eEnderecoDTO {
	
	private Integer id;
    private String rua;
    private int numero;
    private String estado;
    private String cidade;
    private int cep;
    private String bairro;
    private clientes cliente;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	public clientes getCliente() {
		return cliente;
	}
	public void setCliente(clientes cliente) {
		this.cliente = cliente;
	}
	public eEnderecoDTO convertEnderecoDTO(endereco ender){
		
		eEnderecoDTO eDTO = new eEnderecoDTO();
		
		eDTO.setId(ender.getId());
		eDTO.setBairro(ender.getBairro());
		eDTO.setCep(ender.getCep());
		eDTO.setCidade(ender.getCidade());
		eDTO.setEstado(ender.getEstado());
		eDTO.setNumero( ender.getNumero());
		eDTO.setRua(ender.getRua());
		
		return eDTO;
		
		
	}
    
	public endereco converEndereco(eEnderecoDTO eDTO) {
		
		endereco ender = new endereco();
		
		ender.setId(ender.getId());
		ender.setBairro(eDTO.getBairro());
		ender.setCep(eDTO.getCep());
		ender.setCidade(eDTO.getCidade());
	    ender.setCliente(eDTO.getCliente());
	    ender.setEstado(eDTO.getEstado());
	    ender.setNumero(eDTO.getNumero());
	    ender.setRua(eDTO.getRua());
	    
	    return  ender;
	}
	
	
	
	
	
	
	
	
	
	
    
    

}
