package com.back_LimpPlast.service.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.ProdutoDao;
import com.back_LimpPlast.model.produtos;

@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoDao dao;
	
	@Override
	public produtos cadastrarNovo(produtos novo) {
		
		return dao.save(novo);
	}

	@Override
	public produtos alterarProoduto(produtos alterar) {
		return dao.save(alterar);
	}

	@Override
	public void  deletarProduto(Integer id) {
	
		 dao.deleteById(id);
	}

	@Override
	public List<produtos> listarProdutos() {
		
		return dao.findAll();
	}

	@Override
	public produtos BuscarPorId(Integer id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<produtos> BuscarPorClassificacao( produtos prod) {
		
		return dao.findAllByclassificacao(prod);
	}

}
