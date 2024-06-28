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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_itens_pedidos")
public class itens_Pedido implements Serializable {
	
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_itens")
	private Integer id;
	
	
	@Column(name="quantidade" , nullable = false)
	private int quantidade;
	
	 @ManyToOne
	@JoinColumn(name="produto_id")
       private Produtos produto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	@JsonIgnoreProperties("itens")
	private Pedidos pedidos;
		
	
	
	public Integer getId() {
		return id;
	}
 
	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}
	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}