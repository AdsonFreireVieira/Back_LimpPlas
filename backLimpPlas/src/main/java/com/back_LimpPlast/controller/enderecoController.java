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

import com.back_LimpPlast.service.endereco.IServiceEndereco;

import dto.EnderecoDTO;

@RestController
@RequestMapping("/endereco")
public class enderecoController {

	@Autowired   
	private IServiceEndereco service;

	@PostMapping
	public ResponseEntity<EnderecoDTO> cadastrarNovo(@RequestBody EnderecoDTO end) {


		var ender = service.cadastrarNovo(end);
		
		if(ender != null) {
		
		
		return	ResponseEntity.status(201).body(ender);
		}
		
		return ResponseEntity.badRequest().build();
	
	}	


	@PutMapping("/{id}")

	public ResponseEntity<EnderecoDTO> alterarEndereco(@RequestBody EnderecoDTO end, @PathVariable int id) {

		end.setId(id);

		var ender = service.alterarEndereco(end);
	
          
		if (ender!= null) {
			return ResponseEntity.ok(ender);
		}
		return ResponseEntity.badRequest().build();

	}

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> listarEndereco() {
		 
         
		return ResponseEntity.ok().body(service.listarEndereco());
	}

	@GetMapping("/{id}")

	public ResponseEntity<EnderecoDTO> buscarporId(@PathVariable int id) {

		
		var end = service.buscarPorId(id);
	

		if (end != null) {
			return ResponseEntity.ok().body(end);
		}
		
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarEndereco(@PathVariable int num) {

		service.DeletarEndereco(num);

		return ResponseEntity.ok("Removed");
	}

}
