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

import com.back_LimpPlast.dto.ClientesDTO;
import com.back_LimpPlast.model.clientes;
import com.back_LimpPlast.service.cliente.IClienteService;

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
	public ResponseEntity<ClientesDTO> alterar(@RequestBody  clientes clientes , @PathVariable  int id) {
        
		 clientes.setId_Cliente(id);
	 
		clientes cliente = service.alterarDados(clientes);
		
	      ClientesDTO cDTO  = new ClientesDTO();
	      
	      cDTO.alterarClienteDTO(cliente);
	
		return ResponseEntity.ok().body(cDTO);
	}
	@GetMapping

	public ResponseEntity<ClientesDTO> listarTodos() {

		  ClientesDTO cDTO = null;
		  
		  List<clientes> client;
		  
		  client = service.ListarTodos();
		  cDTO.clienteListDTO(client);
		  
		return ResponseEntity.ok(cDTO);
	}

	@GetMapping("/{id}")

	public ResponseEntity<ClientesDTO> buscarPorid(@PathVariable int id) {
         
		ClientesDTO cd = null;
		clientes cliente = service.buscarPorId(id);
     
		
		
		cd.alterarClienteDTO(cliente);
		
		return ResponseEntity.ok(cd);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletar(@PathVariable Integer id) {

		service.deletarPorId(id);
		return ResponseEntity.ok("Removed");

	}

	@GetMapping("/nome/{txt}")


	public ResponseEntity<ClientesDTO> buscarNome(@PathVariable String txt) {

		clientes cliente = service.buscarporNome(txt);

		 ClientesDTO cd = new ClientesDTO();
		 
		 cd.alterarClienteDTO(cliente);
		 
		 return ResponseEntity.ok(cd);
	}

}
