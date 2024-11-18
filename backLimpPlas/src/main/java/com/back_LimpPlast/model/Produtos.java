package com.back_LimpPlast.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_produtos")
public class Produtos implements Serializable{
	

	private static final long serialVersionUID = 1L;

@Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id_produto")
 private  Integer id;
 
 @Column(name="nome" , nullable = false)
 private String nome;
 
 @Column(name="peso" , nullable = false)
 private double peso;
 
 @Column(name="unidades" , nullable = false)
 private  int unidades;
 
 @Column(name="cor" , nullable = false)
 private String cor;
 
 @Column(name="litros" , nullable = false)
 private int litros;
 
 @Column(name="medida" , nullable = false)
 private String medida;
 
 @Column(name="valor", nullable = false)
 private double valor;

 @Column(name="quantidade",nullable = false)
 private int quantidade;
 


public Produtos(Integer id, String nome, double peso, int unidades, String cor, int litros, String medida, double valor,
		int quantidade) {
	
	this.id = id;
	this.nome = nome;
	this.peso = peso;
	this.unidades = unidades;
	this.cor = cor;
	this.litros = litros;
	this.medida = medida;
	this.valor = valor;
	this.quantidade = quantidade;
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
 

}
