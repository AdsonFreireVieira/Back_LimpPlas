	package com.back_LimpPlast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_ItensPedido")
public class itens_Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_itens")
	private Integer id;
	
	@Column(name="valor_total",nullable = false)
	private double valor_total;
	
	@Column(name="quantidade" , nullable = false)
	private int quantidade;
	

	@ManyToOne
	@JoinColumn(name="id_produto")
	private  Produtos produto;
	
	@ManyToOne
	@JoinColumn(name="id_Pedido")
	@JsonIgnoreProperties("itens")
	private pedido pedido;
		
	
	public Integer getId() {
		return id;
	}
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public pedido getPedido() {
		return pedido;
	}
	public void setPedido(pedido pedido) {
		this.pedido = pedido;
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