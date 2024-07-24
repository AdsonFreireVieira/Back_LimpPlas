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

import com.back_LimpPlast.dto.Pedido_DTO;
import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.service.pedido.IServicePedido;

@RestController
@RequestMapping("/pedido")
public class pedidoController {

	@Autowired
	private IServicePedido service;

	@PostMapping
	public ResponseEntity<Pedido_DTO> cadastrarNovo(@RequestBody Pedido_DTO pDTO) {

		Pedido_DTO pedidDTO = service.cadastrarNovo(pDTO);

		if (pedidDTO != null) {

			return ResponseEntity.ok(pedidDTO);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<Pedido_DTO>> listarTodos() {

		return ResponseEntity.ok(service.listarPedido());

	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido_DTO> alterarPedido(@RequestBody Pedido_DTO pDTO, @PathVariable int id) {

		pDTO.setId(id);

		Pedido_DTO ped = service.alterarPedido(pDTO);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido_DTO> buscarPorId(@RequestBody Pedidos pedido, @PathVariable int id) {

		pedido.setId(id);
		Pedido_DTO ped = service.buscarPorId(id);
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
