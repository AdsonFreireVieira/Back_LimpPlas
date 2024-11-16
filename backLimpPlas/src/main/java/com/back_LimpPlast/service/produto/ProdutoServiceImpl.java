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
		// TODO Auto-generated method stub
		return dao.save(novo);
	}

	@Override
	public Produtos alterarProoduto(Produtos alterar) {
		// TODO Auto-generated method stub
		return dao.save(alterar);
	}

	@Override
	public void deletarProduto(Integer id) {
		// TODO Auto-generated method stub
		
		dao.deleteById(id);
	}

	@Override
	public List<Produtos> listarProdutos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Produtos BuscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}
   
	
}
