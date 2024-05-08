	package com.back_LimpPlast.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class itens_Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_itens")
	private Integer id;
	
	@Column(name="valor_unitario" , nullable = false)
	private double valor_unitario;
	
	@Column(name="quantidade" , nullable = false)
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produtos produto;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private pedido pedidos;
	
	
	public double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
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
	public pedido getPedidos() {
		return pedidos;
	}
	public void setPedidos(pedido pedidos) {
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