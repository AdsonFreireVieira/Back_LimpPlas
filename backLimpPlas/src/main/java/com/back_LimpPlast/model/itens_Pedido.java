	package com.back_LimpPlast.model;


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
public class itens_Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_itens")
	private Integer id;
	
	
	@Column(name="quantidade" , nullable = false)
	private int quantidade;
	
	@Column(name="valor_itens")
	private double valorItens;
	
	 @ManyToOne
	@JoinColumn(name="produto_id")
       private Produtos produto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	@JsonIgnoreProperties("itens")
	private Pedidos pedidos;
		
	
	
	public double getValorItens() {
		return valorItens;
	}

	public void setValorItens(double valorItens) {
		this.valorItens = valorItens;
	}

	public Integer getId() {
		return id;
	}
 
	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	
	}
}