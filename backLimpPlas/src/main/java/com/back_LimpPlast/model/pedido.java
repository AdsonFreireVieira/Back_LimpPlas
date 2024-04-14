package com.back_LimpPlast.model;

import java.util.Date;
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
@Table(name="tbl_pedido")
public class pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private Integer id;
	
	@Column(name="data_Pedido",nullable = false)
	private Date data;
	
	@Column(name="quantidade")
	private int quantidade;
	
	@Column(name="desconto")
	private double desconto;
	
	@Column(name="status", nullable = false)
	private String status;
	
	@Column(name="valor_Total")
	private  double valor_Total;
	
	@ManyToOne
	@JoinColumn(name="id_Cliente")
	 private clientes cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<itens_Pedido> itens;

	public double getValor_Total() {	
		return valor_Total;
	}

	public void setValor_Total(double valor_Total) {
		this.valor_Total = valor_Total;
	}

	public clientes getCliente() {
		return cliente;
	}

	public void setCliente(clientes cliente) {
		this.cliente = cliente;
	}

	public List<itens_Pedido> getItens() {
		return itens;
	}

	public void setItens(List<itens_Pedido> itens) {
		this.itens = itens;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
