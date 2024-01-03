package com.back_LimpPlast.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_LimpPlast.model.pedido;
import com.back_LimpPlast.service.pedido.IServicePedido;

@RestController
@RequestMapping("/pedido")
public class pedidoController {

	@Autowired
	private IServicePedido service;

	@PostMapping
	public ResponseEntity<pedido> cadastrarNovo(@RequestBody pedido pedido) {

		pedido ped = service.cadastrarNovo(pedido);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<pedido> alterarPedido(@RequestBody pedido pedido, @PathVariable int id) {

		pedido.setId(id);

		pedido ped = service.alterarPedido(pedido);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{data}")
	public ResponseEntity<List<pedido>> listarTodos(@PathVariable Date data) {

		return ResponseEntity.ok(service.BuscarPorData(data));

	}

	@GetMapping("/{id}")
	public ResponseEntity<pedido> buscarPorId(@RequestBody pedido pedido, @PathVariable int id) {

		pedido.setId(id);

		pedido ped = service.buscarPorId(id);
		if (ped != null) {
			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();

	}

}
