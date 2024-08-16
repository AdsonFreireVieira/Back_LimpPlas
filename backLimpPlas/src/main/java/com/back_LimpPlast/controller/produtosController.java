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

import com.back_LimpPlast.service.produto.IProdutoService;

import dto.ProdutoDTO;

@Controller
@RequestMapping("/produto")
public class produtosController {

	@Autowired
	private IProdutoService service;

	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO eProduto) {
          
		return  ResponseEntity.ok(service.cadastrarNovo(eProduto));

	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> alterarProduto(@RequestBody ProdutoDTO prod, @PathVariable int id) {

		 
  
		return ResponseEntity.ok().body(service.alterarProoduto(prod));

	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listarTodos() {

     
	               		
		return ResponseEntity.ok(service.listarProdutos());	
				
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletarProduto(@PathVariable int id) {
		service.deletarProduto(id);

		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable int id) {

		return ResponseEntity.ok().body(service.BuscarPorId(id));
	}

}
