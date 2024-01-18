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
	public ResponseEntity<sEnderecoDTO> cadastrarNovo(@RequestBody  eEnderecoDTO eEDTO) {
         
		eEnderecoDTO edto = new eEnderecoDTO();
		endereco ender = new endereco();
		sEnderecoDTO sDTO = new sEnderecoDTO();
		
		ender = edto.converEndereco(eEDTO);
		
		ender = service.cadastrarNovo(ender);
		
		sDTO = sDTO.enderecoTOsEnderecoDTO(ender);
		
		if(sDTO != null) {
			ResponseEntity.ok().body(sDTO);
		}

		
		
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")

	public ResponseEntity<sEnderecoDTO> alterarEndereco(@RequestBody eEnderecoDTO entDTO, @PathVariable int id) {
	
		eEnderecoDTO edto = new eEnderecoDTO();
		endereco ender = new endereco();
		sEnderecoDTO sDTO = new sEnderecoDTO();
		
		entDTO.setId(id);
		
		ender = edto.converEndereco(entDTO);
		
		  sDTO = sDTO.enderecoTOsEnderecoDTO(ender);
		
		
		
		if(sDTO != null) {
			return ResponseEntity.ok(sDTO);
		}
		return ResponseEntity.badRequest().build();

	}
	
	@GetMapping
	public ResponseEntity<List<endereco>> listarEndereco(){
		
		return ResponseEntity.ok().body(service.listarEndereco());
	}
	
	@GetMapping("/{num}")
	public ResponseEntity<sEnderecoDTO> buscarPorNumero(@PathVariable int num ){
		
		endereco ender = service.buscarPorNumero(num);
		sEnderecoDTO sDTO = new sEnderecoDTO();
		
		return ResponseEntity.ok(sDTO.enderecoTOsEnderecoDTO(ender));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarEndereco(@PathVariable int num){
		
		service.DeletarEndereco(num);
		
		return ResponseEntity.ok("Removed");
	}

}


















