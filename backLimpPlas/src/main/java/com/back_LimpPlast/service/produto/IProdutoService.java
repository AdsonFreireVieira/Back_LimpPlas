package com.back_LimpPlast.service.produto;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dto.ProdutoDTO;


public interface IProdutoService {
	
	public ProdutoDTO cadastrarNovo(ProdutoDTO novo);
	
	public ProdutoDTO alterarProoduto(ProdutoDTO alterar);
	
    public  void deletarProduto(Integer id);
    
    public List<ProdutoDTO> listarProdutos();
    
     public ProdutoDTO BuscarPorId(Integer id);
     
     
     
     

}
