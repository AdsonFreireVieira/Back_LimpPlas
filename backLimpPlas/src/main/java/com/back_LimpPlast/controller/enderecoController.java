package com.back_LimpPlast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_LimpPlast.model.Endereco;
import com.back_LimpPlast.service.endereco.IServiceEndereco;

@RestController
@RequestMapping("/endereco")
public class enderecoController {

	@Autowired
	private IServiceEndereco service;

	@PostMapping
	public ResponseEntity<Endereco> cadastrarNovo(@RequestBody Endereco endereco) {

		Endereco ender = service.cadastrarNovo(endereco);

		if (ender != null) {
			ResponseEntity.ok().body(ender);
		}

		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")

	public ResponseEntity<Endereco> alterarEndereco(@RequestBody Endereco endereco, @PathVariable int id) {

		endereco.setId(id);
		Endereco end = service.alterarEndereco(endereco);
		
		if(end != null) {
			return ResponseEntity.ok(end);
		}
		return ResponseEntity.badRequest().build();

	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> listarEndereco(){
		
		return ResponseEntity.ok().body(service.listarEndereco());
	}
	
	@GetMapping("/{num}")
	public ResponseEntity<Endereco> buscarPorNumero(@PathVariable int num){
		
		return ResponseEntity.ok(service.buscarPorNumero(num));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarEndereco(@PathVariable int num){
		
		service.DeletarEndereco(num);
		
		return ResponseEntity.ok("Removed");
	}

}


















