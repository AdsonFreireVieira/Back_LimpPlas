package com.back_LimpPlast.controller;

import java.util.ArrayList;
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

import com.back_LimpPlast.controller.dto.saidaDTO.sProdutoDTO;
import com.back_LimpPlast.controller.entradaDTO.eProdutoDTO;
import com.back_LimpPlast.model.produtos;
import com.back_LimpPlast.service.produto.IProdutoService;

@Controller
@RequestMapping("/produto")
public class produtosController {

	@Autowired
	private IProdutoService service;

	@PostMapping
	public ResponseEntity<produtos> cadastrarProduto(@RequestBody produtos eProduto) {

		


		produtos prod  = service.cadastrarNovo(eProduto);




		if (prod != null) {

			return ResponseEntity.ok().body(prod);
		}

		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<produtos> alterarProduto(@RequestBody produtos eProduto, @PathVariable int id) {

		
		eProduto.setId(id);

		

		produtos pds = service.alterarProoduto(eProduto);

		
		if (pds != null) {

			return ResponseEntity.ok(pds);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<produtos>> listarTodos() {
          
		
		
		return ResponseEntity.ok(service.listarProdutos());
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletarProduto(@PathVariable int id) {
		service.deletarProduto(id);

		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/{id}")
	public ResponseEntity<produtos> buscarPorId(@RequestBody produtos epDTO ,@PathVariable int id) {

		 
		 
		 
		 
		 epDTO.setId(id);
		
		produtos prod = service.BuscarPorId(id);

		if (prod != null) {

			return ResponseEntity.ok(prod);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{txt}")
	public ResponseEntity<List<produtos>> buscarPorClassificacao() {
     
      
		return ResponseEntity.badRequest().build();

	}
}
