package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.clientes;

public class clienteDTO {
	
	private String nome;
	private String  email;
	
	public clienteDTO( String nome, String email){
		
		this.nome = nome;
		this.email = email;
	}
	
	public clienteDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public clienteDTO (clientes cliente) {
		
	    this.nome = cliente.getNome();
	    this.email = cliente.getEmail();
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
	
	public static clienteDTO toDTO(clientes cliente) {
		
		return new  clienteDTO(cliente.getNome() , cliente.getEmail());
	}

	
	public static  List<clienteDTO>convertList(List<clientes> clientesObj){
		
		return clientesObj.stream().map(clienteDTO :: toDTO).collect(Collectors.toList());
	}
	

}
