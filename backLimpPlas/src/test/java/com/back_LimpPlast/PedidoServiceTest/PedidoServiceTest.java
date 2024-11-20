package com.back_LimpPlast.PedidoServiceTest;

import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.PedidoDao;
import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.Produtos;
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

	private Produtos produto;
	
	
	private  List<itens_Pedido> itensList;
	
	private Pedidos pedidos;
	
	@BeforeEach
	void setup() {
		
		                                                                    
		
		pedidos = new Pedidos(23,LocalDate.now(), 30, 2,"Entregue", 34, user, itensList);
		
	}
	@DisplayName("Create")
	@Test
	void CreatePedidoSucess(){
      
		produto = new Produtos(29,"Plastico", 3, 5,"Azul", 100,"88X 105", 34, 6);
        
		itens_Pedido itens1 = new itens_Pedido(23, 3, 45, produto);
	    itens_Pedido  itens2 = new itens_Pedido(34, 67, 5, produto);
	    itens_Pedido  itens3 = new itens_Pedido(45,4, 56, produto);
	    
	    itensList.add(itens1);
	    itensList.add(itens2);
	    itensList.add(itens3);
	    user = new User(30,"jose","jose@bol.com",99340034,3343434);       
		
		given(repository.save(pedidos)).willReturn(pedidos);
		 
		 Pedidos pedidosTest = service.cadastrarNovo(pedidos);
		 
		System.out.println(pedidosTest);
		 
	}
}



























