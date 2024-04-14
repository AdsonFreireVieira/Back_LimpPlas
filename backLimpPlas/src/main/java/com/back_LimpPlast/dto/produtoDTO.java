package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.Produtos;

public class produtoDTO {

	 private  Integer id;
	 
	 private String nome;
	 
	 private double peso;
	 
	 private  int unidades;
	 
	 private String cor;
	 
	 private int litros;
	 
	 private String medida;
	 
	 private double valor;

	 private int quantidade;
	
	 private String classificacao;
	 
	  

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getLitros() {
		return litros;
	}

	public void setLitros(int litros) {
		this.litros = litros;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	 
	
	 public produtoDTO (Produtos produto) {

	 this.id = produto.getId();
	 this.cor = produto.getCor();
	 this.classificacao = produto.getClassificacao();
	 this.litros = produto.getLitros();
	 this.medida = produto.getMedida();
	 this.nome = produto.getNome();
	 this.peso = produto.getPeso();
	 this.quantidade = produto.getQuantidade();
	 this.unidades = produto.getUnidades();
	 this.valor = produto.getValor();
	 
	 }
	 
	 public produtoDTO() {
		
	}
	 public  Produtos ConvertProduto(produtoDTO pDTO){
		 
		 Produtos prod = new  Produtos();
		 
		 prod.setCor(pDTO.getCor());
		 prod.setLitros(pDTO.getLitros());
		 prod.setMedida(pDTO.getMedida());
		 prod.setNome(pDTO.getNome());
		 prod.setPeso(pDTO.getPeso());
		 prod.setClassificacao(pDTO.getClassificacao());
		 prod.setUnidades(pDTO.getUnidades());
		 prod.setValor(pDTO.getValor());
		 return prod;
		 
	 }

	 
	 public List<produtoDTO> listDTO(List<Produtos> produtos){
		 
		 return produtos.stream().map(produtoDTO::new).collect(Collectors.toList());
	 }

}
















