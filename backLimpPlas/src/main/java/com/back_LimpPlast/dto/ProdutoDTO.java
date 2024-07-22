package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.Produtos;

public class ProdutoDTO {
	
	private Integer id;
	private String cor;
	private int litros;
    private String medida;
     private String nome;
     private double peso;
     private int quantidade;
     private int unidades;
     private double valor;
     
     
     
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public ProdutoDTO() {
		// TODO Auto-generated constructor stub
	}
     
	public ProdutoDTO(Produtos produto) {
		
		this.id = produto.getId();
		this.cor = produto.getCor();
		this.litros = produto.getLitros();
		this.nome = produto.getNome();
		this.peso = produto.getPeso();
		this.quantidade = produto.getQuantidade();
		this.medida = produto.getMedida();
		this.unidades = produto.getUnidades();
		this.valor= produto.getValor();
		
		
	}
	
	public static ProdutoDTO convertParaProdutoDTO(Produtos produto) {
	   
		 ProdutoDTO produtoDTO = new ProdutoDTO();
		 
		 produtoDTO.setId(produto.getId());
		 produtoDTO.setCor(produto.getCor());
		 produtoDTO.setLitros(produto.getLitros());
		 produtoDTO.setMedida(produto.getMedida());
		 produtoDTO.setNome(produto.getNome());
		 produtoDTO.setPeso(produto.getPeso());
		 produtoDTO.setQuantidade(produto.getQuantidade());
		 produtoDTO.setUnidades(produto.getUnidades());
		 produtoDTO.setValor(produto.getValor());
		 
		 return  produtoDTO;
	}
	
	public static Produtos convertParaProduto(ProdutoDTO produtoDTO) {
		   
		 Produtos produto = new Produtos();
		 
		 produto.setId(produtoDTO.getId());
		 produto.setCor(produtoDTO.getCor());
		 produto.setLitros(produtoDTO.getLitros());
		 produto.setMedida(produtoDTO.getMedida());
		 produto.setNome(produtoDTO.getNome());
		 produto.setPeso(produtoDTO.getPeso());
		 produto.setQuantidade(produtoDTO.getQuantidade());
		 produto.setUnidades(produtoDTO.getUnidades());
		 produto.setValor(produtoDTO.getValor());
		 
		 return  produto;

	}
	
	
	public static  List<ProdutoDTO> convertLisDTO(List<Produtos> listProdutos){
		
		return listProdutos.stream().map(ProdutoDTO :: convertParaProdutoDTO).collect(Collectors.toList());
		
	}
	
	
     

}
