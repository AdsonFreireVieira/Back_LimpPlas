package com.back_LimpPlast.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back_LimpPlast.model.Clientes;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	
	
	@PostMapping
  public ResponseEntity<Clientes> cadastrarNovo(@RequestBody Clientes cliente){
		
		
	}

}
