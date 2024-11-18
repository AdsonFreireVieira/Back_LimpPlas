	package com.back_LimpPlast.EnderecoService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
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
	 @DisplayName("UpdateEnderecoReturnTrue")
	 @Test
	 void TestEnderecoReturnTrueUpdateSucess() {
		 
		 given(repository.save(endereco)).willReturn(endereco);
		 
		 endereco.setCidade("suzano");
		 endereco.setRua("Rua 15");
		 
		 Endereco ender = service.alterarEndereco(endereco);
		 
		 assertEquals(ender.getCidade(), endereco.getCidade());
		 assertEquals(ender.getRua(), endereco.getRua());
	 } 
	 
	 @DisplayName("FindAllEnderecosReturnTrue")
	 @Test
	 void TesteFindAllReturnSucess() {
		 
		
		 
		  Endereco endereco1 = new Endereco("rua 10", 135,"Minas Gerais","Belo Horizinte" ,988043444,"Caucaia",user);
		  Endereco endereco2= new Endereco("rua 12",123,"Sergipe","Neopolis",994567,"caucaia",user);
		  
		  given(repository.findAll()).willReturn(List.of(endereco,endereco1,endereco2));
		 
		  List<Endereco> personList = service.listarEndereco();
		  
	     assertEquals(3, personList.size());
		 
	 }	
	 @DisplayName("findById return true")
	 @Test
	 void findByIdReturnSucess() {
		 
		  Endereco ende = new Endereco(15,"rua 10", 135,"Minas Gerais","Belo Horizinte" ,988043444,"Caucaia",user);
		  
		 
		  
		  given(repository.findById(anyInt())).willReturn(Optional.of(ende));
		  
		  Endereco enderecoReturn = service.buscarPorId(15);

		  
		  assertEquals(15, enderecoReturn.getId());
		  assertEquals(ende.getCidade(),enderecoReturn.getCidade());

		 
	 }
	 @DisplayName("DeleteByID")
	 @Test
	 
	 void deleteByIDReturnTrue() {
		 
		  doNothing().when(repository).deleteById(endereco.getId());
		  
		  service.DeletarEndereco(endereco.getId());
		  
 		  
		 
	 
	 }

}




























