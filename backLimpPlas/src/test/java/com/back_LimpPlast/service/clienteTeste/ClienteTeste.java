package com.back_LimpPlast.service.clienteTeste;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.cliente.ServiceUserImpl;
import com.back_LimpPlast.service.cliente.UserService;

import dto.UserDTO;

@ExtendWith(MockitoExtension.class)

class ClienteTeste {
	
	@InjectMocks
	private ServiceUserImpl userService;
	
	@Mock
	private UserDao repository;
	
	@BeforeEach
	public void setUp(){
		User users =  new User(1, "Adson", "adson@gmail", 99333444, 22445433);
       lenient().when(repository.findAll()).thenReturn(Collections.singletonList( users));
       lenient().when(repository.findById(1)).thenReturn(Optional.of(users));
		
	}
	
	
	@Test
	@DisplayName("Retorna uma Lista com apenas 1 usuario")
	public void  buscarTodos() {
				
		List<UserDTO> Usuarios = userService.ListarTodos(); 
	    
		Assertions.assertEquals(1, Usuarios.size()); 
		verify(repository).findAll();
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	@DisplayName("Buscar por id")
	public void buscarPorId() {
		
		UserDTO userdto = userService.buscarPorId(1);
		
		assertNotNull(userdto);
		
		   
		
	}
	}







