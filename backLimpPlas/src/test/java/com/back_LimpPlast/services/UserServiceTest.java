package com.back_LimpPlast.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.ClientesDao;
import com.back_LimpPlast.model.clientes;
import com.back_LimpPlast.service.cliente.IClienteService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private  IClienteService service;
	
	@InjectMocks
	private ClientesDao repoDao;

	@Nested
	class createUser{
		
		@Test
		@DisplayName("returnUserSucess")
	  void creatUser() {
		   
			var user = new clientes(0, "jose","@gmail", 99999999, 46566666);
			
			doReturn(user).when(repoDao).save(any());
			
		var input =  new clientes(2,"jose","@Josegmail",9999999, 34567845);
		
			var output =service.cadastrarNovo(input);
			
			assertNotNull(output);
	  }
	
	}
}









