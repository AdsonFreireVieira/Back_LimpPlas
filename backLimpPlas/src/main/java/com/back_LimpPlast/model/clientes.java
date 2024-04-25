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
	
	@Column(name="nome", nullable = false)
    private String nome;
	
	@Column(name="email",nullable = false)
    private String email;
	
	@Column(name="telefone",nullable = false)
    private  int telefone;
	
	@Column(name="documento",nullable = false)
    private int  documento;
	
	
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
	public int getDocumento() {
		return documento;
	}
	public void setDocumento( int documento) {
		this.documento = documento;
	}
	
	
    
    
    
}