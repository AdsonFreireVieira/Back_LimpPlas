package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.User;

public class UserDTO {
	
	private Integer id;
	private int documento;
	private String email;
	private String nome;
	private int telefone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public static UserDTO convertToUserDTO(User user) {
		
	  var   userDTO = new UserDTO();
	  
	  userDTO.setId(user.getId());
	  userDTO.setDocumento(user.getDocumento());
	  userDTO.setEmail(user.getEmail());
	  userDTO.setNome(user.getNome());
	  userDTO.setTelefone(user.getTelefone());
	  
	  
	  return userDTO;
		
	}
	
	public  static User  convertToUser( UserDTO userDTO) {
		
		var  user = new  User();
		
		user.setId(userDTO.getId());
		user.setDocumento(userDTO.getDocumento());
		user.setEmail(userDTO.getEmail());
		user.setNome(userDTO.getNome());
        user.setTelefone(userDTO.getTelefone());	
        
        return user;
        
	}
	
	public static List<UserDTO> convertToListDTO(List<User> listUser){
		
		return listUser.stream().map(UserDTO :: convertToUserDTO).collect(Collectors.toList());
	}
	
	
}






































