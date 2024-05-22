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

import com.back_LimpPlast.dto.clienteDTO;
import com.back_LimpPlast.model.clientes;
import com.back_LimpPlast.service.cliente.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@PostMapping
	public ResponseEntity<clienteDTO> cadastrarNovo(@RequestBody clienteDTO cl) {

		return ResponseEntity.ok(service.cadastrarNovo(cl));
	}

	@PutMapping("/{id}")
	public ResponseEntity<clientes> alterar(@RequestBody clientes cli, @PathVariable int id) {

		cli.setId_Cliente(id);

		return ResponseEntity.ok().body(service.alterarDados(cli));
	}

	@GetMapping

	public ResponseEntity<List<clientes>> listarTodos() {

		return ResponseEntity.ok(service.ListarTodos());
	}

	@GetMapping("/{id}")

	public ResponseEntity<clientes> buscarPorid(@PathVariable int id) {

		clientes cliente = service.buscarPorId(id);
		if (cliente != null) {

			return ResponseEntity.ok(cliente);
		}
		
		return ResponseEntity.badRequest().build();
				}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletar(@PathVariable Integer id) {

		service.deletarPorId(id);
		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/nome/{txt}")

	public ResponseEntity<clientes> buscarNome(@PathVariable String txt) {

		return ResponseEntity.ok(service.buscarporNome(txt));
	}

}
