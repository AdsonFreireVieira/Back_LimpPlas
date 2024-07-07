package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.Produtos;

public class ProdutoDTO {
	
	private Integer id;
	private  String nome;
	private double peso;
	private int unidades;
	private String cor;
	private int  litros;
	private int quantidades;
	private String medida;
	private double valor;
	
	
	
	
	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getMedida() {
		return medida;
	}


	public void setMedida(String medida) {
		this.medida = medida;
	}


	public int getLitros() {
		return litros;
	}


	public void setLitros(int litros) {
		this.litros = litros;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(String nome,String cor,int unidades,int quantidade, double peso) {
		
		this.cor = cor;
		this.nome = nome;
		this.unidades = unidades;
		this.quantidades = quantidade;
		this.peso = peso;
		
	}
	
	
	public static  ProdutoDTO  toDTO(Produtos produto){
		
		
		return new ProdutoDTO(produto.getNome(),produto.getCor(),produto.getUnidades(),produto.getQuantidade(),produto.getPeso());
	
		
	}
	
	public static List<ProdutoDTO> convertList(List<Produtos> listProdutos){
		
		return listProdutos.stream().map(ProdutoDTO :: toDTO).collect(Collectors.toList());
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
	public int getQuantidades() {
		return quantidades;
	}
	public void setQuantidades(int quantidades) {
		this.quantidades = quantidades;
	}
	
	public static Produtos convertToProduto(ProdutoDTO  produtoDTO) {
		
		Produtos  produto = new Produtos();
		
		produto.setId(produtoDTO.getId());
		produto.setCor(produtoDTO.getCor());
		produto.setLitros(produtoDTO.getLitros());
		produto.setMedida(produtoDTO.getMedida());
		produto.setNome(produtoDTO.getNome());
		produto.setQuantidade(produtoDTO.getQuantidades());
		produto.setUnidades(produtoDTO.getUnidades());
		produto.setValor(produtoDTO.getValor());
		
		return produto;
		
	}
	
	public static ProdutoDTO convertTOProdutoDTO(Produtos produtos) {
		
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		produtoDTO.setId(produtos.getId());
		produtoDTO.setCor(produtos.getCor());
		produtoDTO.setLitros(produtos.getLitros());
		produtoDTO.setMedida(produtos.getMedida());
		produtoDTO.setNome(produtos.getNome());
		produtoDTO.setQuantidades(produtos.getQuantidade());
		produtoDTO.setUnidades(produtos.getUnidades());
		produtoDTO.setValor(produtos.getValor());
		
		return produtoDTO;
	}
	
	
	
	
	
	
	
	
	
	

}
