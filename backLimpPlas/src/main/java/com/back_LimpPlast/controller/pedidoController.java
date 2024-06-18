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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back_LimpPlast.model.Pedidos;
import com.back_LimpPlast.model.itens_Pedido;
import com.back_LimpPlast.service.pedido.IServicePedido;

@RestController
@RequestMapping("/pedido")
public class pedidoController {

	@Autowired
	private IServicePedido service;

	@PostMapping
	public ResponseEntity<Pedidos> cadastrarNovo(@RequestBody Pedidos pedido) {

		Pedidos ped = service.cadastrarNovo(pedido);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<Pedidos>> listarTodos() {

		return ResponseEntity.ok(service.listarPedido());

	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedidos> alterarPedido(@RequestBody Pedidos pedido, @PathVariable int id) {

		pedido.setId(id);

		Pedidos ped = service.alterarPedido(pedido);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedidos> buscarPorId(@RequestBody Pedidos pedido, @PathVariable int id) {

		pedido.setId(id);
		Pedidos ped = service.buscarPorId(id);
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
