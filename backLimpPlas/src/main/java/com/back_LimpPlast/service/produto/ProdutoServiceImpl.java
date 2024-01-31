package com.back_LimpPlast.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.ProdutoDao;
import com.back_LimpPlast.model.Produtos;

@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoDao dao;
	
	@Override
	public Produtos cadastrarNovo(Produtos novo) {
		
		return dao.save(novo);
	}

	@Override
	public Produtos alterarProoduto(Produtos alterar) {
		return dao.save(alterar);
	}

	@Override
	public void  deletarProduto(Integer id) {
	
		 dao.deleteById(id);
	}

	@Override
	public List<Produtos> listarProdutos() {
		
		return dao.findAll();
	}

	@Override
	public Produtos BuscarPorId(Integer id) {
		
		return dao.findById(id).orElse(null);
	}

	
}
