package com.back_LimpPlast.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.ProdutoDao;
import com.back_LimpPlast.model.Produtos;

import br.com.Produto.model.Produto;
import dto.ProdutoDTO;
import mapper.GenericModelMapper;


@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoDao dao;
   
	GenericModelMapper<ProdutoDTO, Produtos > mapper = new GenericModelMapper<>(Produtos.class);
	
	GenericModelMapper<Produtos, ProdutoDTO > mapperDTO = new GenericModelMapper<>(ProdutoDTO.class);
	
	@Override
	public ProdutoDTO cadastrarNovo(ProdutoDTO novo) {
		
        
        Produtos prod = mapper.map(novo);
        dao.save(prod);
       
        
         
		return mapperDTO.map(prod) ;
	}

	@Override
	public ProdutoDTO alterarProoduto(ProdutoDTO alterar) {
        
		Produtos prod = mapper.map(alterar);
		
		dao.save(prod);
           
		return mapperDTO.map(prod);
	}

	@Override
	public void deletarProduto(Integer id) {

		dao.deleteById(id);
	}

	@Override
	public List<ProdutoDTO> listarProdutos() {

		return mapperDTO.mapList(dao.findAll());
	}

	@Override
	public ProdutoDTO BuscarPorId(Integer id) {

		return mapperDTO.map(dao.findById(id).orElse(null));
	}
}
