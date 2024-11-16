package com.back_LimpPlast.service.produto;

import java.util.List;

import com.back_LimpPlast.model.Produtos;


public interface IProdutoService {
	
	public Produtos cadastrarNovo(Produtos novo);
	
	public Produtos alterarProoduto(Produtos alterar);
	
    public  void deletarProduto(Integer id);
    
    public List<Produtos> listarProdutos();
    
     public Produtos BuscarPorId(Integer id);
     
     
     
     

}
