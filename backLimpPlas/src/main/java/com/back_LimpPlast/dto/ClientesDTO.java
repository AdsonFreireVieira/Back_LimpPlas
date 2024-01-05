package com.back_LimpPlast.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.back_LimpPlast.model.clientes;

public class ClientesDTO {
	
	private String nome;
	private String email;
	private int telefone;
	private int documento;
	
	
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public void alterarClienteDTO(clientes cliente) {
		
	   this.nome= cliente.getNome();
	   this.telefone = cliente.getTelefone();
	   this.email = cliente.getEmail();
	   this.telefone = cliente.getTelefone();
	   
	}

	public List<ClientesDTO> clienteListDTO(List<clientes> lista){
		
	    List lDTO = null;  
     BeanUtils.copyProperties(lDTO, lista);
     
     return lDTO;
	}

}
