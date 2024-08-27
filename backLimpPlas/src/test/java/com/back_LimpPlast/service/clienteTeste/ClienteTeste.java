package com.back_LimpPlast.service.clienteTeste;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.cliente.ServiceUserImpl;


import dto.UserDTO;

@ExtendWith(MockitoExtension.class)

class ClienteTeste {
	
	@InjectMocks
	private ServiceUserImpl user;
	
	@Mock
	private UserDao repository;
	@Test
	public void  buscarTodos() {
		
		User users =  new User(20, "Adson", "adson@gmail", 99333444, 22445433);
		Mockito.when(repository.findAll()).thenReturn(Collections.singletonList( users));
		
		List<UserDTO> Usuarios = user.ListarTodos(); 
	    
		Assertions.assertEquals(1, Usuarios.size());
	}
		
	}