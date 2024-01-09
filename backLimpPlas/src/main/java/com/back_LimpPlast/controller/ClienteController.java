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

import com.back_LimpPlast.controller.entradaDTO.eClienteDTO;
import com.back_LimpPlast.model.clientes;
import com.back_LimpPlast.service.cliente.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@PostMapping
	public ResponseEntity<eClienteDTO> cadastrarNovo(@RequestBody eClienteDTO eDTO) {

		eClienteDTO dto = new eClienteDTO();
		clientes cliente = dto.convertCliente(dto);

		clientes cl =service.cadastrarNovo(cliente);
 
		 dto = dto.convertDTO(cliente);
		if (cliente != null) {
			return ResponseEntity.ok(dto);

		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<eClienteDTO> alterar(@RequestBody eClienteDTO eDTO, @PathVariable int id) {
        
		clientes cl = new  clientes();
		eClienteDTO dto = new eClienteDTO();
		
		cl = eDTO.convertCliente(eDTO);
		
		cl = service.alterarDados(cl);
		
		dto = eDTO.convertDTO(cl);

		return ResponseEntity.ok().body(dto);
	}

	@GetMapping

	public ResponseEntity<List<clientes>> listarTodos() {

		return ResponseEntity.ok(service.ListarTodos());
	}

	@GetMapping("/{id}")

	public ResponseEntity<clientes> buscarPorid(@PathVariable int id) {

		clientes cliente = service.buscarPorId(id);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletar(@PathVariable Integer id) {

		service.deletarPorId(id);
		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/nome/{txt}")

	public ResponseEntity<clientes> buscarNome(@PathVariable String txt) {

		clientes cliente = service.buscarporNome(txt);

		return ResponseEntity.ok(cliente);
	}

}
