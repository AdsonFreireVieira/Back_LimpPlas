package com.back_LimpPlast.testeMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.back_LimpPlast.model.User;

import dto.UserDTO;
import mapper.GenericModelMapper;

public class testeMapper {

	
	
	@InjectMocks
	 GenericModelMapper<UserDTO,User>  mapper = new GenericModelMapper<>(User.class);
	
	@Test
	@DisplayName("ConverteDTOemEntidade")
	public void ConvertEntity() {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(1);
		userDTO.setEmail("@gmail.com");
		userDTO.setNome("teste1");
		userDTO.setTelefone(44333434);
		userDTO.setDocumento(1112222);
		
		
		 
		 
		 User user = mapper.map(userDTO);
		 
		 assertNotNull(user);
		 assertEquals("teste1", user.getNome());
		 assertEquals(1, user.getId());
		 assertEquals("@gmail.com", user.getEmail());
		 assertEquals(44333434,user.getTelefone());
		 assertEquals(1112222, user.getDocumento());
   }
	
	@Test
	@DisplayName("ConvertEntityemDTO")
   
	public void convertDTOenEntity() {
		
      User users = new User();
		
		users.setId(2);
		users.setEmail("@hotmail.com");
		users.setNome("teste2");
		users.setTelefone(222222);
		users.setDocumento(111111);
		
		 GenericModelMapper<User,UserDTO>  mapper = new GenericModelMapper<>(UserDTO.class);
		 
		 UserDTO userDTO = mapper.map(users);
		 
		 assertNotNull(userDTO);
		 
		 assertEquals(users.getId(), userDTO.getId());
		 assertEquals(users.getEmail(), userDTO.getEmail());
		 assertEquals(users.getNome(),userDTO.getNome());
		 assertEquals(users.getTelefone(),userDTO.getTelefone());
		 assertEquals(users.getDocumento(), userDTO.getDocumento());
		 
		 
	}

}






















