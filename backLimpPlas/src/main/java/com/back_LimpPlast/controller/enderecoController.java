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

import com.back_LimpPlast.controller.dto.saidaDTO.sEnderecoDTO;
import com.back_LimpPlast.controller.entradaDTO.eEnderecoDTO;
import com.back_LimpPlast.model.endereco;
import com.back_LimpPlast.service.endereco.IServiceEndereco;

@RestController
@RequestMapping("/endereco")
public class enderecoController {

	@Autowired
	private IServiceEndereco service;

	@PostMapping
	public ResponseEntity<endereco> cadastrarNovo(@RequestBody  endereco end) {
         
		
		
	
		
		endereco endere= service.cadastrarNovo(end);
		
	
		
		if(endere != null) {
			ResponseEntity.ok().body(endere);
		}

		
		
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")

	public ResponseEntity<endereco> alterarEndereco(@RequestBody endereco end, @PathVariable int id) {
	
		
		end.setId(id);
		
		
		endereco ender = service.alterarEndereco(end);
		
		
		if(ender != null) {
			return ResponseEntity.ok(end);
		}
		return ResponseEntity.badRequest().build();

	}
	
	@GetMapping
	public ResponseEntity<List<endereco>> listarEndereco(){
		
		return ResponseEntity.ok().body(service.listarEndereco());
	}
	
	@GetMapping("/{num}")
	public ResponseEntity<endereco> buscarPorNumero(@PathVariable int num ){
		
		endereco ender = service.buscarPorNumero(num);

		
		return ResponseEntity.ok(ender);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarEndereco(@PathVariable int num){
		
		service.DeletarEndereco(num);
		
		return ResponseEntity.ok("Removed");
	}

}


















