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

import com.back_LimpPlast.dto.pedidoDTO;
import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.service.pedido.IServicePedido;

@RestController
@RequestMapping("/pedido")
public class pedidoController {

	@Autowired
	private IServicePedido service;

	@PostMapping
	public ResponseEntity<Pedidos> cadastrarNovo(@RequestBody Pedidos pDTO) {

		Pedidos ped = service.cadastrarNovo(pDTO);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<pedidoDTO>> listarTodos() {

		return ResponseEntity.ok(service.listarPedido());

	}

	@PutMapping("/{id}")
	public ResponseEntity<pedidoDTO> alterarPedido(@RequestBody pedidoDTO pDTO, @PathVariable int id) {

		pDTO.setId(id);

		pedidoDTO ped = service.alterarPedido(pDTO);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<pedidoDTO> buscarPorId(@RequestBody Pedidos pedido, @PathVariable int id) {

		pedido.setId(id);
		pedidoDTO ped = service.buscarPorId(id);
		if (ped != null) {
			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPedido(@PathVariable int id) {

		service.deletarPedido(id);

		return ResponseEntity.ok("Removed");
	}
}
