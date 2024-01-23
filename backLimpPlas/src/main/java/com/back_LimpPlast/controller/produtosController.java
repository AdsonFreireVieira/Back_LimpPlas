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
	public ResponseEntity<sProdutoDTO> cadastrarProduto(@RequestBody eProdutoDTO eProdutoDTO) {

		produtos prod = new produtos();

		eProdutoDTO eprodDTO = new eProdutoDTO();
		sProdutoDTO sPDTO = new sProdutoDTO();

		prod = eprodDTO.convertToProduto(eProdutoDTO);

		prod = service.cadastrarNovo(prod);

		sPDTO = sPDTO.sConvertProdutoDTO(prod);

		if (sPDTO != null) {

			return ResponseEntity.ok().body(sPDTO);
		}

		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<sProdutoDTO> alterarProduto(@RequestBody eProdutoDTO eProduto, @PathVariable int id) {

		produtos produto = new produtos();
		sProdutoDTO spDTO = new sProdutoDTO();
		eProduto.setId(id);

		eProdutoDTO epDTO = new eProdutoDTO();

		produto = epDTO.convertToProduto(eProduto);

		produto = service.alterarProoduto(produto);

		spDTO = spDTO.sConvertProdutoDTO(produto);

		if (spDTO != null) {

			return ResponseEntity.ok(spDTO);
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
	public ResponseEntity<sProdutoDTO> buscarPorId(@RequestBody eProdutoDTO epDTO ,@PathVariable int id) {

		 sProdutoDTO spDTO = new sProdutoDTO();
		 
		 
		 
		 epDTO.setId(id);
		
		produtos prod = service.BuscarPorId(id);

		if (prod != null) {

			return ResponseEntity.ok(spDTO.sConvertProdutoDTO(prod));
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{txt}")
	public ResponseEntity<List<produtos>> buscarPorClassificacao(@RequestBody eProdutoDTO epDTO,
			@PathVariable String txt) {
     
      eProdutoDTO epdt = new eProdutoDTO();
		List <produtos> produto = new  ArrayList<>();
		sProdutoDTO spDTO = new sProdutoDTO();
		
		      produto = epdt.convertToProduto(epdt);
		               spDTO =spDTO. service.BuscarPorClassificacao(produto);

		

		if (produt != null) {

			return ResponseEntity.ok(produt);
		}
		return ResponseEntity.badRequest().build();

	}
}
