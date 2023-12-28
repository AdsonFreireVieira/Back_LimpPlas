package com.back_LimpPlast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back_LimpPlast.model.Produtos;
import com.back_LimpPlast.service.produto.IProdutoService;

@Controller
@RequestMapping("produto")
public class produtosController {

	@Autowired
	private IProdutoService service;

	@PostMapping
	public ResponseEntity<Produtos> cadastrarProduto(@RequestBody Produtos produto) {

		Produtos prod = service.cadastrarNovo(produto);

		if (prod != null) {

			return ResponseEntity.ok().body(prod);
		}

		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produtos> alterarProduto(@RequestBody Produtos produto, @PathVariable int id) {

		produto.setId(id);
		Produtos prod = service.alterarProoduto(produto);

		if (prod != null) {

			return ResponseEntity.ok(prod);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<Produtos>> listarTodos() {

		return ResponseEntity.ok(service.listarProdutos());
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletarProduto(@PathVariable int id) {
		service.deletarProduto(id);

		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/{id}")
	public ResponseEntity<Produtos> buscarPorId(@PathVariable int id) {

		Produtos prod = service.BuscarPorId(id);

		if (prod != null) {

			return ResponseEntity.ok(prod);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{txt}")
	public ResponseEntity<List<Produtos>> buscarPorClassificacao(@RequestBody Produtos produto,
			@PathVariable String txt) {

		produto.setClassificacao(txt);

		List<Produtos> produt = service.BuscarPorClassificacao(produto);

		if (produt != null) {

			return ResponseEntity.ok(produt);
		}
		return ResponseEntity.badRequest().build();

	}
}
