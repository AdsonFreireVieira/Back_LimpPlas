package com.back_LimpPlast.service.cliente;

import java.util.List;

import com.back_LimpPlast.model.clientes;

public interface IClienteService {
	
	public clientes cadastrarNovo(clientes cliente);
	
	public clientes alterarDados(clientes alterar);
	
	public List<clientes> ListarTodos();
	
	public clientes buscarporNome(String nome);
	
	public  void deletarPorId(int id);
	
	public clientes buscarPorId(int id);
 
}
