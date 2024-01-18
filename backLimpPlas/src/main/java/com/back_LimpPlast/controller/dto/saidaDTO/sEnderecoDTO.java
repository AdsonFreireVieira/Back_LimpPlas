package com.back_LimpPlast.controller.dto.saidaDTO;

import com.back_LimpPlast.model.endereco;

public class sEnderecoDTO {
	
	private String nome_rua;
	private int endereco;
	private String estado;
	private String cidade;
	private int cep;
	private String bairro;
	
	
	
	public String getNome_rua() {
		return nome_rua;
	}
	public void setNome_rua(String nome_rua) {
		this.nome_rua = nome_rua;
	}
	public int getEndereco() {
		return endereco;
	}
	public void setEndereco(int endereco) {
		this.endereco = endereco;
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
	
	
	public sEnderecoDTO enderecoTOsEnderecoDTO(endereco endere) {
		
		sEnderecoDTO sDTO = new sEnderecoDTO();
		
		sDTO.setNome_rua(endere.getRua());
		sDTO.setBairro(endere.getBairro());
		sDTO.setCep(endere.getCep());
	    sDTO.setCidade(endere.getCidade());
	    sDTO.setEstado(endere.getEstado());
	
	    return sDTO;
	}
	
	
	
	
	
	
	
	
	
	
	

}
