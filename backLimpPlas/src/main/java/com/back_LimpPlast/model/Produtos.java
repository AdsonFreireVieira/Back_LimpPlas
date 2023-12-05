package com.back_LimpPlast.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_produtos")
public class Produtos {
	
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id_produto")
 private  Integer id;
 
 @Column(name="nome_produto")
 private String nome;
 
 @Column(name="peso")
 private double peso;
 
 @Column(name="unidade")
 private  int unidades;
 
 @Column(name="cor")
 private String cor;
 
 @Column(name="litros")
 private int litros;
 
 @Column(name="medida")
 private String medida;
 
 @Column(name="valor")
 private double valor;

 @Column(name="quantidade")
 private int quantidade;
 
 @Column(name="classificacao")
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
 
 

}
