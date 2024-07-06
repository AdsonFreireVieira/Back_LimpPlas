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

import com.back_LimpPlast.dto.UserDTO;
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
	public ResponseEntity<UserDTO> alterar(@RequestBody User cli, @PathVariable int id) {

		cli.setId_Cliente(id);
		
		UserDTO clienteObj = new  UserDTO(service.alterarDados(cli));

		return ResponseEntity.ok().body(clienteObj);
	}

	@GetMapping

	public ResponseEntity<List<UserDTO>> listarTodos() {

		
		List<UserDTO> clienteObj = UserDTO.convertList(service.ListarTodos());
		return ResponseEntity.ok(clienteObj);
	}

	@GetMapping("/{id}")

	public ResponseEntity<UserDTO> buscarPorid(@PathVariable int id) {

		User cliente = service.buscarPorId(id);
		
		UserDTO clienteObj = new UserDTO(cliente);
		return ResponseEntity.ok(clienteObj);
				}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletar(@PathVariable Integer id) {

		service.deletarPorId(id);
		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/nome/{txt}")

	public ResponseEntity<UserDTO> buscarNome(@PathVariable String txt) {

		 UserDTO clienteObj = new UserDTO(service.buscarporNome(txt));
		return ResponseEntity.ok(clienteObj);
	}

}
