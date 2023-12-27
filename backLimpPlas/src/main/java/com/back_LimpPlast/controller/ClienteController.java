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
import org.springframework.web.service.annotation.DeleteExchange;

import com.back_LimpPlast.model.Clientes;
import com.back_LimpPlast.service.cliente.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService service;	
	
 @PostMapping
  public ResponseEntity<Clientes> cadastrarNovo(@RequestBody Clientes cliente){
		
	 Clientes clientes = service.cadastrarNovo(cliente);
	 
	 if(clientes != null) {
		return ResponseEntity.ok(service.cadastrarNovo(cliente));
		
	}
	 return ResponseEntity.badRequest().build();
 }
 
 @PutMapping
 public ResponseEntity<Clientes> alterar(Clientes clientes){
	 
	 Clientes cliente = service.alterarDados(clientes);
	 
	 if(cliente != null) {
		 
		return ResponseEntity.ok().body(cliente);
	 }
	 
	 return ResponseEntity.badRequest().build();
 }
 
 @GetMapping
 
 public ResponseEntity<List<Clientes>>listarTodos(){
	
	 return ResponseEntity.ok(service.ListarTodos());
	 
 }
 @GetMapping("/{id}")
 
 public ResponseEntity<Clientes> buscarPorid(@PathVariable int id){
	 
	  Clientes cliente = service.buscarPorId(id);
	  
	  if(cliente != null) {
	 
	 return ResponseEntity.ok(cliente);
	  }
	  
	  return ResponseEntity.badRequest().build();
 }
 
 
 
 @DeleteMapping("/{id}")
 
 public ResponseEntity<?> deletar(@PathVariable Integer id){
	 
	 service.deletarPorId(id);
	 return ResponseEntity.ok("Removed");
			
 }
 
 
 @GetMapping("{txt}")
 
 public ResponseEntity<Clientes> buscarPorNome(@PathVariable String txt){
	 
	 Clientes cliente = service.buscarporNome(txt);
    
	  if(cliente != null) {
		  return ResponseEntity.ok(cliente);
	  }
	  return ResponseEntity.badRequest().build()
 
 }
 

}











