package com.back_LimpPlast.model;

import java.io.Serializable;
import java.time.LocalDate;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_pedidos")
public class Pedidos implements Serializable {
	
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private Integer id;
	
	
	@Column(name="data_pedido")
	private LocalDate data;
	
	@Column(name="quantidade")
	private int quantidade;
	
	@Column(name="desconto")
	private double desconto;
	
	@Column(name="status")
	private String status;
	
	@Column(name="valor_total")
	private  double valorTotal;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private User cliente;
	
	@OneToMany(mappedBy ="pedidos",cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonIgnoreProperties("pedidos")
	private List<itens_Pedido> itens;
	
	 
	public Pedidos() {
		// TODO Auto-generated constructor stub
	}
	

	
	public Pedidos(Integer id, LocalDate data, int quantidade, double desconto, String status, double valorTotal,
			User cliente, List<itens_Pedido> itens) {
		this.id = id;
		this.data = data;
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itens = itens;
	}




	public List<itens_Pedido> getItens() {
		return itens;
	}

	public void setItens(List<itens_Pedido> itens) {
		this.itens = itens;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public double getValor_Total() {	
			return valorTotal;
	}

	public void setValor_Total(double valor_Total) {
		this.valorTotal = valor_Total;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
