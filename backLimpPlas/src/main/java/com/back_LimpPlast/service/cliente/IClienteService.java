package com.back_LimpPlast.service.cliente;

import java.util.List;

import com.back_LimpPlast.model.Clientes;

public interface IClienteService {
	
	public Clientes cadastrarNovo(Clientes cliente);
	
	public Clientes alterarDados(Clientes alterar);
	
	public List<Clientes> ListarTodos();
	
	public Clientes buscarporNome(String nome);
	
	public  void deletarPorId(int id);
	
	public Clientes buscarPorId(int id);
 
}
