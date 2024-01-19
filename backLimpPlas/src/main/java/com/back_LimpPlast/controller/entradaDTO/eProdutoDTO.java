package com.back_LimpPlast.controller.entradaDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.back_LimpPlast.model.produtos;

public class eProdutoDTO {

	private int id;
	private String nome;
	private int unidade;
	private double peso;
	private String cor;
	private int litros;
	private String medida;
	private double valor;
	private String classificacao;
	private int quantidade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getUnidade() {
		return unidade;
	}
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
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
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public  produtos convertToProduto(eProdutoDTO produto) {
		
		produtos prod = new produtos();
		
		prod.setClassificacao(produto.getClassificacao());
		prod.setCor(produto.getCor());
		prod.setId(produto.getId());
		prod.setLitros(produto.getLitros());
	    prod.setMedida(produto.getMedida());
	    prod.setNome(produto.getNome());
	    prod.setPeso(produto.getPeso());
	    prod.setQuantidade(produto.getQuantidade());
	    prod.setUnidades(produto.getUnidade());
	    prod.setValor(produto.getValor());
	
	     return prod;
	}
	
	public List<produtos> listConvertProduto(List<eProdutoDTO> lDTO){
		
		List<produtos> lpDTO = new ArrayList<>();
		
	      BeanUtils.copyProperties(lDTO, lpDTO);		
		 
	      return lpDTO;
		
	}
	
}




























