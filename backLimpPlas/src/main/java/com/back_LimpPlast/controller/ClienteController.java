package com.back_LimpPlast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.back_LimpPlast.model.clientes;
import com.back_LimpPlast.service.cliente.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired 
	private IClienteService service;

	@PostMapping
	public ResponseEntity<clientes> cadastrarNovo(@RequestBody clientes cl) {
		
		 
		return ResponseEntity.ok(cl);
	}

	@PutMapping("/{id}")
	public ResponseEntity<clienteDTO> alterar(@RequestBody clientes cli, @PathVariable int id) {

		cli.setId_Cliente(id);
		
		clienteDTO clienteObj = new  clienteDTO(service.alterarDados(cli));

		return ResponseEntity.ok().body(clienteObj);
	}

	@GetMapping

	public ResponseEntity<List<clienteDTO>> listarTodos() {

		
		List<clienteDTO> clienteObj = clienteDTO.convertList(service.ListarTodos());
		return ResponseEntity.ok(clienteObj);
	}

	@GetMapping("/{id}")

	public ResponseEntity<clienteDTO> buscarPorid(@PathVariable int id) {

		clientes cliente = service.buscarPorId(id);
		
		clienteDTO clienteObj = new clienteDTO(cliente);
		return ResponseEntity.ok(clienteObj);
				}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletar(@PathVariable Integer id) {

		service.deletarPorId(id);
		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/nome/{txt}")

	public ResponseEntity<clienteDTO> buscarNome(@PathVariable String txt) {

		 clienteDTO clienteObj = new clienteDTO(service.buscarporNome(txt));
		return ResponseEntity.ok(clienteObj);
	}

}
