package com.back_LimpPlast.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_cliente")
public class clientes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private  Integer id_Cliente;
	
	@Column(name="nome_cliente",length = 100, nullable = false)
    private String nome;
	
	@Column(name="email",length = 100)
    private String email;
	
	@Column(name="telefone")
    private  int telefone;
	
	@Column(name="cnpj")
    private String cnpj;
	
	
	public Integer getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(Integer id_Cliente) {
		this.id_Cliente = id_Cliente;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
    
    
    
}