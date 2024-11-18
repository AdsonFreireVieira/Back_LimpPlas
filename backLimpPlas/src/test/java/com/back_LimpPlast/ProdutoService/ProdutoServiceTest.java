package com.back_LimpPlast.ProdutoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.ProdutosRepository;
import com.back_LimpPlast.model.Produtos;
import com.back_LimpPlast.service.produtos.ProdutoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

	@Mock
	private ProdutosRepository repository;

	@InjectMocks
	private ProdutoServiceImpl service;

	private Produtos produtos;

	@BeforeEach
	void setup() {
		produtos = new Produtos(20,"SAco Plastico", 3, 50, "Azul", 100, "90 X 90", 24, 20);

	}

	@DisplayName("CreateProdutos")
	@Test
	void CreateProdutoSucess() {
   
		given(repository.save(produtos)).willReturn(produtos);
		
		Produtos produtosReturn = service.cadastrarNovo(produtos);
		
		assertNotNull(produtosReturn);
		assertEquals(20, produtosReturn.getId());
		
	}
	
	@DisplayName("UpdateProdutoSucess")
    @Test
    void updateProdutoReturnSucess() {
		
		given(repository.save(produtos)).willReturn(produtos);
		
		produtos.setCor("Amarelo");
		produtos.setMedida("100 X 100");
		produtos.setNome("saco Para Lixo");
		
		Produtos produtosReturn = service.alterarProoduto(produtos);
		
		
		assertNotNull(produtosReturn);
		assertEquals("Amarelo", produtosReturn.getCor());
         assertEquals(20, produtosReturn.getId());		
	}
	
	@DisplayName("FindAll return")
	@Test
	void findAllReturnSucess() {
		
		produtos = new Produtos(20,"SAco Plastico", 3, 50, "Azul", 100, "90 X 90", 54, 20);
		Produtos produtos1 = new Produtos(3,"SAco Plastico", 3.6, 60, "Preto", 50, "60 X 70", 24, 50);
		Produtos produtos2 = new Produtos(7,"SAco Plastico", 2.0, 40, "Preto", 100, "40 X 60", 10, 340);

		given(repository.findAll()).willReturn(List.of(produtos1, produtos2,produtos));
		
		
		List<Produtos>listProdutos = service.listarProdutos();
		
		assertNotNull(listProdutos);
		assertEquals(3, listProdutos.size());
		
	}
	@DisplayName("deleteByid return sucess delete")
	 @Test
	 void returnsucessDeleteByid() {
		 

		 
    doNothing().when(repository).deleteById(produtos.getId());
    
    service.deletarProduto(produtos.getId());
    
    verify(repository,times(1)).deleteById(produtos.getId());
    
	}
    
	
		 

}
























