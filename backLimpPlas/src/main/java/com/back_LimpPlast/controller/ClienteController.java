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
import org.springframework.web.service.annotation.DeleteExchange;

import com.back_LimpPlast.model.clientes;
import com.back_LimpPlast.service.cliente.IClienteService;

import jakarta.annotation.security.PermitAll;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@PostMapping
	public ResponseEntity<clientes> cadastrarNovo(@RequestBody clientes cliente) {

		clientes clientes = service.cadastrarNovo(cliente);

		if (clientes != null) {
			return ResponseEntity.ok(service.cadastrarNovo(cliente));

		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<clientes> alterar(@RequestBody  clientes clientes , @PathVariable  int id) {
        
		 clientes.setId_Cliente(id);
	 
		clientes cliente = service.alterarDados(clientes);

		if (cliente != null) {

			return ResponseEntity.ok().body(cliente);
		}

		return ResponseEntity.badRequest().build();
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

		clientes cliente = service.buscarporNome(txt);

		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.badRequest().build();

	}

}
