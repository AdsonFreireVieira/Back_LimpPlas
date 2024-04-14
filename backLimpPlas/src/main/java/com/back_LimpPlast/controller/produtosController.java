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

import com.back_LimpPlast.dto.produtoDTO;
import com.back_LimpPlast.model.Produtos;
import com.back_LimpPlast.service.produto.IProdutoService;

@Controller
@RequestMapping("/produto")
public class produtosController {

	@Autowired
	private IProdutoService service;

	@PostMapping
	public ResponseEntity<produtoDTO> cadastrarProduto(@RequestBody produtoDTO eProduto) {

		    produtoDTO pDTO = new produtoDTO();
		    

		  produtoDTO prod = new produtoDTO(service.cadastrarNovo(pDTO.ConvertProduto(eProduto)));




		if (prod != null) {

			return ResponseEntity.ok().body(prod);
		}
		return ResponseEntity.badRequest().build();

		
	}

	@PutMapping("/{id}")
	public ResponseEntity<produtoDTO> alterarProduto(@RequestBody produtoDTO eProduto, @PathVariable int id) {

		
		eProduto.setId(id);

		 
		produtoDTO  prDTO = new produtoDTO();

	produtoDTO	prod  = new produtoDTO(service.alterarProoduto(prDTO.ConvertProduto(eProduto)));

		
		if (prod != null) {

			return ResponseEntity.ok(prod);
		}
		
		return ResponseEntity.badRequest().build();
		
	}

	@GetMapping
	public ResponseEntity<List<produtoDTO>> listarTodos() {
          
		produtoDTO pDTO = new produtoDTO();
		
		
		return ResponseEntity.ok(pDTO.listDTO(service.listarProdutos()));
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletarProduto(@PathVariable int id) {
		service.deletarProduto(id);

		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/{id}")
	public ResponseEntity<produtoDTO> buscarPorId(@RequestBody produtoDTO epDTO ,@PathVariable int id) {

		 
		 
		     
		 
		 epDTO.setId(id);
		
		produtoDTO prod = new produtoDTO(service.BuscarPorId(id));

		if (prod != null) {

			return ResponseEntity.ok(prod);
		}
		
		return ResponseEntity.badRequest().build();
	}

	
}
