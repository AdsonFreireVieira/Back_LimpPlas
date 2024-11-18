package com.back_LimpPlast.PedidoServiceTest;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.model.User;
import com.back_LimpPlast.model.itens_Pedido;
import com.back_LimpPlast.service.pedido.pedidoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {
	
	@Mock
	private PedidoDao repository;
	
	@InjectMocks
	private pedidoServiceImpl service;
	
	private  User user;
	
	private List<itens_Pedido> listItens;
	
	@BeforeEach
	void setup() {
		
		user = new User(30,"jose","jose@bol.com",99340034,3343434);                                                                           
		
	}
}
