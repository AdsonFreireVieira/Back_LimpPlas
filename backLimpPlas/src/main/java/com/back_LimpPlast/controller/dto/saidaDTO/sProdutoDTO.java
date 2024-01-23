package com.back_LimpPlast.controller.dto.saidaDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import com.back_LimpPlast.controller.entradaDTO.eProdutoDTO;
import com.back_LimpPlast.model.produtos;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class sProdutoDTO {
	

	private String nome;
	private int unidade;
	private double peso;
	private String cor;
	private int litros;
	private String medida;
	private double valor;
	private String classificacao;
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
	
	
	public sProdutoDTO sConvertProdutoDTO(produtos produto) {
		
		sProdutoDTO sPDTO = new sProdutoDTO();
		
		sPDTO.setClassificacao(produto.getClassificacao());
		sPDTO.setCor(produto.getCor());
		sPDTO.setLitros(produto.getLitros());
		sPDTO.setMedida(produto.getMedida());
		sPDTO.setNome(produto.getNome());
		sPDTO.setPeso(produto.getPeso());
		sPDTO.setUnidade(produto.getUnidades());
		sPDTO.setValor(produto.getValor());
		
		return sPDTO;
	}
	
 	public List<sProdutoDTO>listConvertProdutoDTO(List<produtos>  listProduto) {
		
		 List<sProdutoDTO> lpDTO = new ArrayList<>();
		 
		 BeanUtils.copyProperties(lpDTO,listProduto);
		 
		 return lpDTO;
	}
	
	



}










