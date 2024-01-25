package com.back_LimpPlast.service.produto;

import java.util.List;
import java.util.Optional;

import com.back_LimpPlast.model.produtos;

public interface IProdutoService {
	
	public produtos cadastrarNovo(produtos novo);
	
	public produtos alterarProoduto(produtos alterar);
	
    public  void deletarProduto(Integer id);
    
    public List<produtos> listarProdutos();
    
     public produtos BuscarPorId(Integer id);
     
     
     
     

}
