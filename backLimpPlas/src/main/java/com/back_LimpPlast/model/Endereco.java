	package com.back_LimpPlast.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_enderecos")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer id;

	@Column(name = "nome_rua", nullable = false)
	private String rua;

	@Column(name = "numero", nullable = false)
	private int numero;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Column(name = "cidade", nullable = false)
	private String cidade;

	@Column(name = "cep", nullable = false)
	private int cep;

	@Column(name = "bairro", nullable = false)
	private String bairro;

	@ManyToOne
	@JoinColumn(name="cliente_id")

	private User cliente;

	public User getCliente() {
		return cliente;
	}
	
  
	
	


	public Endereco(Integer id, String rua, int numero, String estado, String cidade, int cep, String bairro,
			User cliente) {
		
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.bairro = bairro;
		this.cliente = cliente;
	}


	public Endereco( String rua, int numero, String estado, String cidade, int cep, String bairro,
			User cliente) {
		
		this.rua = rua;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.bairro = bairro;
		this.cliente = cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}