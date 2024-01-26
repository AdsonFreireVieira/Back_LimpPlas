package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.clientes;

public class clienteDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private int telefone;
	private int documento;
	
	public clienteDTO() {
		// TODO Auto-generated constructor stub
	}
	
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
	
	
	public clienteDTO(int id, String nome, String email, int telefone, int documento) {
		// TODO Auto-generated constructor stub
	}
	
	public clienteDTO(clientes obj) {
		this.id = obj.getId_Cliente();
		this.nome =obj.getNome();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.documento =  obj.getDocumento();
	}

	public clientes convertToClientes(clienteDTO dto){
		
		clientes cl = new clientes();
		
		cl.setDocumento(dto.getDocumento());
		cl.setEmail(dto.getEmail());
		cl.setNome(dto.getNome());
        cl.setTelefone(dto.getTelefone());
        
        return cl;
	}
	
	public static List<clienteDTO> listClienteDTO(List<clientes> listcliente){
		
			
		return listcliente.stream().map(entidade -> 
		       new clienteDTO(entidade.getDocumento(),entidade.getEmail(),entidade.getNome(),entidade.getTelefone(),entidade.getDocumento()))
			.collect(Collectors.toList());
	}
	
}
