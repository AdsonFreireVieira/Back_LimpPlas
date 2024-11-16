package com.back_LimpPlast.EnderecoRepositoryTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.EnderecoDao;
import com.back_LimpPlast.model.Endereco;
import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.endereco.ServiceEnderecoImpl;

@ExtendWith(MockitoExtension.class)

public class EnderecoServiceTest {

	 @Mock
	 private EnderecoDao repository;
	 
	 @InjectMocks
	 private ServiceEnderecoImpl service;
	 
	 private Endereco endereco;
	 
	 
	 private User user;
	 
	 
	 @BeforeEach
	 public void Setup() {
		user = new User("Adriano", "A@gmail.com", 223444222, 4445);

		endereco = new Endereco("palmeiras",345,"itaqua","jd vale", 299934,"dadd", user);
	 }
	 
	 @DisplayName("CreateEnderecoReturnSucess")
	 @Test
	 void TestCreateEndereco() {
		 
		 given(repository.save(endereco)).willReturn(endereco);
		 
	   Endereco ender = service.cadastrarNovo(endereco);
	   
	   assertNotNull(ender);
	   assertNotNull(ender.getCliente());
	   
	   assertEquals("palmeiras",ender.getRua());
	   assertEquals(345,ender.getNumero());
	   
	  
	 
	 }
	

}




























