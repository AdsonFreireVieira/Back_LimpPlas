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

import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.cliente.UserService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> cadastrarNovo(@RequestBody User cl) {

		return ResponseEntity.ok(cl);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> alterar(@RequestBody User cli, @PathVariable int id) {

		cli.setId(id);

		return ResponseEntity.ok().body(service.alterarDados(cli));
	}

	@GetMapping

	public ResponseEntity<List<User>> listarTodos() {

;
		return ResponseEntity.ok(service.ListarTodos());
	}

	@GetMapping("/{id}")

	public ResponseEntity<User> buscarPorid(@PathVariable int id) {

		
		return ResponseEntity.ok(service.buscarPorId(id));
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletar(@PathVariable Integer id) {

		service.deletarPorId(id);
		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/nome/{txt}")

	public ResponseEntity<User> buscarNome(@PathVariable String txt) {

		
		return ResponseEntity.ok(service.buscarporNome(txt));
	}

}
