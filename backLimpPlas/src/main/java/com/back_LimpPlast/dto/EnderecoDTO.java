package com.back_LimpPlast.dto;

import com.back_LimpPlast.model.Endereco;

public class EnderecoDTO {
	
	private String rua;
	private String cidade;
	private String bairro;
	
	
	
   public EnderecoDTO(String rua,String cidade,String bairro) {
	   
	   this.bairro=bairro;
	   this.rua = rua;
	   this.cidade = cidade;
	
}
   public EnderecoDTO(Endereco endereco) {
	   
	   this.bairro = endereco.getBairro();
	   this.rua = endereco.getRua();
	   this.cidade = endereco.getCidade();
	   
   }
   
     public static EnderecoDTO toDTO(Endereco endereco) {
    	 return new EnderecoDTO(endereco.getBairro(),endereco.getRua(),endereco.getCidade());
     }
	
	
	
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	

}
