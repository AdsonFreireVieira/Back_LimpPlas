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
import com.back_LimpPlast.dto.clienteDTO;
import com.back_LimpPlast.service.cliente.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@PostMapping
	public ResponseEntity<clienteDTO> cadastrarNovo(@RequestBody clienteDTO cl) {
		
		clienteDTO cDTO = new clienteDTO();
		
		clienteDTO resp  = new clienteDTO(service.cadastrarNovo(cDTO.convertToClientes(cl)));

		return ResponseEntity.ok(resp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<clienteDTO> alterar(@RequestBody clienteDTO cli, @PathVariable int id) {
        
		
		cli.setId(id);
		clienteDTO clienteDTO = new clienteDTO();
		
		clienteDTO resp = new clienteDTO(service.alterarDados(clienteDTO.convertToClientes(cli)));

		return ResponseEntity.ok().body(resp);
	}

	@GetMapping

	public ResponseEntity<List<clienteDTO>> listarTodos() {
        
		
		return ResponseEntity.ok(clienteDTO.listClienteDTO(service.ListarTodos()));
	}

	@GetMapping("/{id}")

	public ResponseEntity<clienteDTO> buscarPorid(@PathVariable int id) {

		 clienteDTO dto = new clienteDTO(service.buscarPorId(id));	

		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletar(@PathVariable Integer id) {

		service.deletarPorId(id);
		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/nome/{txt}")

	public ResponseEntity<clienteDTO> buscarNome(@PathVariable String txt) {

	
		clienteDTO cliente = new clienteDTO(service.buscarporNome(txt));

		return ResponseEntity.ok(cliente);
	}

}
