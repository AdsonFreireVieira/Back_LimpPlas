package com.back_LimpPlast.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.ProdutoDao;
import com.back_LimpPlast.dto.ProdutoDTO;
import com.back_LimpPlast.model.Produtos;


@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoDao dao;

	@Override
	public ResponseEntity<ProdutoDTO> cadastrarNovo(ProdutoDTO novo) {
          
		
	     var  produto = ProdutoDTO.convertParaProduto(novo);
	 
	       var pDTO =  ProdutoDTO.convertParaProdutoDTO(dao.save(produto));

		return ResponseEntity.ok().body(pDTO);
	}

	@Override
	public ProdutoDTO alterarProoduto(ProdutoDTO alterar) {

		var produto = ProdutoDTO.convertParaProduto(alterar);

		return ProdutoDTO.convertParaProdutoDTO(dao.save(produto));
	}

	@Override
	public void deletarProduto(Integer id) {

		dao.deleteById(id);
	}

	@Override
	public List<ProdutoDTO> listarProdutos() {

		return ProdutoDTO.convertLisDTO(dao.findAll());
				
	}

	@Override
	public ProdutoDTO BuscarPorId(Integer id) {

		return   ProdutoDTO.convertParaProdutoDTO(dao.findById(id).orElse(null));
	}

}
