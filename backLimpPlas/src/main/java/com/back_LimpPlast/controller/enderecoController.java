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

import com.back_LimpPlast.dto.EnderecoDTO;
import com.back_LimpPlast.model.Endereco;
import com.back_LimpPlast.service.endereco.IServiceEndereco;

@RestController
@RequestMapping("/endereco")
public class enderecoController {

	@Autowired
	private IServiceEndereco service;

	@PostMapping
	public ResponseEntity<EnderecoDTO> cadastrarNovo(@RequestBody Endereco end) {


		Endereco ender = service.cadastrarNovo(end);
		
		if(ender != null) {
		
			EnderecoDTO endDTO = new EnderecoDTO(ender);
			
		return	ResponseEntity.status(201).body(endDTO);
		}
		return ResponseEntity.badRequest().build();
		
	
	}	


	@PutMapping("/{id}")

	public ResponseEntity<EnderecoDTO> alterarEndereco(@RequestBody Endereco end, @PathVariable int id) {

		end.setId(id);

		Endereco ender = service.alterarEndereco(end);
		
		EnderecoDTO endDTO = new EnderecoDTO(ender);
          
		if (endDTO != null) {
			return ResponseEntity.ok(endDTO);
		}
		return ResponseEntity.badRequest().build();

	}

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> listarEndereco() {
		 
         
		return ResponseEntity.ok().body(EnderecoDTO.convertListDTO(service.listarEndereco()));
	}

	@GetMapping("/{id}")

	public ResponseEntity<EnderecoDTO> buscarporId(@PathVariable int id) {

		EnderecoDTO endDTO = EnderecoDTO.toDTO(service.buscarPorId(id));
		
	

		if (endDTO != null) {
			return ResponseEntity.ok().body(endDTO);
		}
		
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarEndereco(@PathVariable int num) {

		service.DeletarEndereco(num);

		return ResponseEntity.ok("Removed");
	}

}
