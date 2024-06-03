package com.back_LimpPlast.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.back_LimpPlast.model.Produtos;

public class ProdutoDTO {
	
	private  String nome;
	private double peso;
	private int unidades;
	private String cor;
	private int quantidades;
	
	
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
	
	
	
	
	

}
