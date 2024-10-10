package com.back_LimpPlast.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_clientes")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "telefone", nullable = false)
	private int telefone;

	@Column(name = "documento", nullable = false)
	private  int documento;



public User() {
	// TODO Auto-generated constructor stub
}
	public User(Integer id, String nome, String email, int telefone, int documento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.documento = documento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId_Cliente() {
		return id;
	}

	public void setId_Cliente(Integer id_Cliente) {
		this.id = id_Cliente;
	}
 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

}