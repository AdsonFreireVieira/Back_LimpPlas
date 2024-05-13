	package com.back_LimpPlast.model;


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
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produtos produto;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
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