package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.Endereco;

public class EnderecoDTO {
	
	private  Integer id;
	private String bairro;
	private String cidade;
	private int cep;
	private String  nome_rua;
    private int numero;
    private String estado;
    private  UserDTO cliente;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getNome_rua() {
		return nome_rua;
	}
	public void setNome_rua(String nome_rua) {
		this.nome_rua = nome_rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public UserDTO getCliente() {
		return cliente;
	}
	public void setCliente(UserDTO cliente) {
		this.cliente = cliente;
	}
    
	public EnderecoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public static EnderecoDTO converToEnderecoDTO( Endereco endereco) {
		
		var enderecoDTO = new EnderecoDTO();
		
		var endDTO = UserDTO.convertToUserDTO(endereco.getCliente());
		
		enderecoDTO.setId(endereco.getId());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setEstado(endereco.getEstado());
		enderecoDTO.setNome_rua(endereco.getRua());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setCliente(endDTO);
		
		return enderecoDTO;
		
	}
	
	public static Endereco convertToEndereco(EnderecoDTO endDTO) {
		
		var endereco = new Endereco();
		
		var end = UserDTO.convertToUser(endDTO.getCliente());
		
		 endereco.setBairro(endDTO.getBairro());
		 endereco.setCep(endDTO.getCep());
		 endereco.setCidade(endDTO.getCidade());
		 endereco.setCidade(endDTO.getCidade());
		 endereco.setEstado(endDTO.getEstado());
		 endereco.setId(endDTO.getId());
		 endereco.setRua(endDTO.getNome_rua());
		 endereco.setCliente(end);
		 
		 return endereco;
		
	}
	
	public static List<EnderecoDTO> convertListDTO(List<Endereco> listEndereco){
		
		return listEndereco.stream().map(EnderecoDTO :: converToEnderecoDTO).collect(Collectors.toList());
	}

}






















