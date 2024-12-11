package com.back_LimpPlast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.cliente.UserService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private UserService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> cadastrarNovo(@RequestBody User cl) {

		return ResponseEntity.ok().body(service.cadastrarNovo(cl));
	}

	@PutMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> alterar(@RequestBody User cli) {

		try {
			return ResponseEntity.ok(service.alterarDados(cli));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<User>> listarTodos() {

		;
		return ResponseEntity.ok(service.ListarTodos());
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User> buscarPorid(@PathVariable(value = "id") int id) {

		try {
			return ResponseEntity.ok(service.buscarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<?> deletar(@PathVariable (value= "id") int id) {

		service.deletarPorId(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping(value = "/nome/{txt}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User> buscarNome(@PathVariable String txt) {

		return ResponseEntity.ok(service.buscarporNome(txt));
	}

}
