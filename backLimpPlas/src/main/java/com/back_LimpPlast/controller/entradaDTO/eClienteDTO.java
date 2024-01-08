package com.back_LimpPlast.controller.entradaDTO;

import com.back_LimpPlast.model.clientes;

public class eClienteDTO {

	private Integer id;
	private String nome;
	private String email;
	private int telefone;
	private int documento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public eClienteDTO convertDTO(clientes cliente) {

		eClienteDTO eDTO = new eClienteDTO();

		eDTO.setId(cliente.getId_Cliente());
		eDTO.setNome(cliente.getNome());
		eDTO.setDocumento(cliente.getDocumento());
		eDTO.setEmail(cliente.getEmail());
		eDTO.setTelefone(cliente.getTelefone());

		return eDTO;
	}
	
	
	
	public clientes convertCliente(eClienteDTO dto) {
		
		clientes cl = new clientes();
		
		cl.setId_Cliente(dto.getId());
		cl.setNome(dto.getNome());
		cl.setEmail(dto.getEmail());
		cl.setTelefone(dto.getTelefone());
		cl.setDocumento(dto.getDocumento());
		
		return cl;
	}
		
		

}
