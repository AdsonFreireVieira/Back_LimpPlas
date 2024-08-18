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

import com.back_LimpPlast.service.pedido.IServicePedido;

import dto.PedidoDTO;

@RestController
@RequestMapping("/pedido")
public class pedidoController {

	@Autowired
	private IServicePedido service;

	@PostMapping
	public ResponseEntity<PedidoDTO> cadastrarNovo(@RequestBody PedidoDTO pDTO) {

		PedidoDTO pedidDTO = service.cadastrarNovo(pDTO);

		if (pedidDTO != null) {

			return ResponseEntity.ok(pedidDTO);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> listarTodos() {

		return ResponseEntity.ok(service.listarPedido());

	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoDTO> alterarPedido(@RequestBody PedidoDTO pDTO, @PathVariable int id) {

		pDTO.setId(id);

		PedidoDTO ped = service.alterarPedido(pDTO);

		if (ped != null) {

			return ResponseEntity.ok(ped);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable int id) {

		return ResponseEntity.ok(service.buscarPorId(id));
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPedido(@PathVariable int id) {

		service.deletarPedido(id);

		return ResponseEntity.ok("Removed");
	}
}
