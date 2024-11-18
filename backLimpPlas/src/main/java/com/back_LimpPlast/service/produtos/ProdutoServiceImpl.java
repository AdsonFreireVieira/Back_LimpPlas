package com.back_LimpPlast.service.produtos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.ProdutosRepository;
import com.back_LimpPlast.model.Produtos;



@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutosRepository repository;

	@Override
	public Produtos cadastrarNovo(Produtos novo) {
		// TODO Auto-generated method stub
		return repository.save(novo);
	}

	@Override
	public Produtos alterarProoduto(Produtos alterar) {
		// TODO Auto-generated method stub
		return repository.save(alterar);
	}

	@Override
	public void deletarProduto(Integer id) {
		// TODO Auto-generated method stub
		
		repository.deleteById(id);
	}

	@Override
	public List<Produtos> listarProdutos() {
		// TODO Auto-generated method stub
		return  repository.findAll();
	}

	@Override
	public Produtos BuscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
