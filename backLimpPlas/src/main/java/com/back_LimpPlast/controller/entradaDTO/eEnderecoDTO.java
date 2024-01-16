package com.back_LimpPlast.controller.entradaDTO;

import com.back_LimpPlast.controller.dto.saidaDTO.sEnderecoDTO;
import com.back_LimpPlast.model.endereco;

public class eEnderecoDTO {
	
	private Integer id;
    private String rua;
    private int numero;
    private String estado;
    private String cidade;
    private int cep;
    private String bairro;
    
    
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
    
	
	
	
	
	
	
	
	
	
	
	
    
    

}
