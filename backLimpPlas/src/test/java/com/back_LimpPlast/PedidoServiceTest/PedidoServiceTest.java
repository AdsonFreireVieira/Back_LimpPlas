package com.back_LimpPlast.PedidoServiceTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	private Produtos produtos;
	
	private User user;
	
	
	private Pedidos pedido;
	
	
	@BeforeEach
	public  void setup() {
		ArrayList<itens_Pedido> itens = new ArrayList<>();

		user = new User("jose","jose@gmail.com",3345666,39989);
		
		produtos = new Produtos(56,"plastico",3.4,90,"cinza", 110,"90x110",58.0, 10);
		
		Produtos produto1 = new Produtos(23,"plastico",3.4,90,"cinza", 110,"90x110",58.0, 10);
		Produtos produto2 = new Produtos(32,"plastico",4,90,"Preto", 110,"90x90",40.0, 10);
		     
        itens_Pedido item1 = new itens_Pedido(22, 7, 4, produto2);
        itens_Pedido item2 = new itens_Pedido(23, 3, 4, produto1); 

		
		  itens.add(item1);
		  itens.add(item2);
	    

	    
		pedido = new Pedidos(LocalDate.now(), 5, 5,"Pronto", 200, user, itens);
		

	
	}
    
	@DisplayName("Create Pedido Sucess")
	@Test
	public void testeCreatePedido() {
		
		 given(repository.save(pedido)).willReturn(pedido);
		
		 Pedidos pedidoResult = service.cadastrarNovo(pedido);
		 
		assertNotNull(pedidoResult);
	}
	
         
}



























