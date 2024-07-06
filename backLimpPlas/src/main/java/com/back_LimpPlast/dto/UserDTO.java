package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.User;

public class UserDTO {
	
	private Integer id;
	private String nome;
	private int  telefone;
	private int documento;
	private String  email;
	
	public UserDTO userDTO(User user){
		
		UserDTO dto = new UserDTO();
		
		dto.setId(user.getId());
		dto.setDocumento(user.getDocumento());
		dto.setEmail( user.getEmail());
		dto.setTelefone(user.getTelefone());		
		
		return dto;
		
	}
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public UserDTO (User cliente) {
		
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

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static UserDTO toDTO(User cliente) {
		
		return new  UserDTO(cliente.getNome() , cliente.getEmail());
	}

	
	public static  List<UserDTO>convertList(List<User> clientesObj){
		
		return clientesObj.stream().map(UserDTO :: toDTO).collect(Collectors.toList());
	}
	

}
