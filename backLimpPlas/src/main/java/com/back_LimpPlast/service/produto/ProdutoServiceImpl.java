package com.back_LimpPlast.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.ProdutoDao;
import com.back_LimpPlast.dto.ProdutoDTO;


@Component
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoDao dao;

	@Override
	public ResponseEntity<ProdutoDTO> cadastrarNovo(ProdutoDTO novo) {

		var produto = ProdutoDTO.convertToProduto(novo);

		var produtoDTO = ProdutoDTO.convertTOProdutoDTO(dao.save(produto));

		return ResponseEntity.ok().body(produtoDTO);
	}

	@Override
	public ProdutoDTO alterarProoduto(ProdutoDTO alterar) {

		var produto = ProdutoDTO.convertToProduto(alterar);

		return ProdutoDTO.convertTOProdutoDTO(dao.save(produto));
	}

	@Override
	public void deletarProduto(Integer id) {

		dao.deleteById(id);
	}

	@Override
	public List<ProdutoDTO> listarProdutos() {

		return ProdutoDTO.convertList(dao.findAll());
				
	}

	@Override
	public ProdutoDTO BuscarPorId(Integer id) {

		return   ProdutoDTO.convertTOProdutoDTO(dao.findById(id).orElse(null));
	}

}
