package com.back_LimpPlast.service.cliente;

import java.util.List;

import com.back_LimpPlast.model.User;

public interface UserService {
	
	public User cadastrarNovo(User cliente);
	
	public User alterarDados(User alterar);
	
	public List<User> ListarTodos();
	
	public User buscarporNome(String nome);
	
	public  void deletarPorId(int id);
	
	public User buscarPorId(int id);
 
}
