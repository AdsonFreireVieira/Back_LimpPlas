package com.back_LimpPlast.service.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back_LimpPlast.model.User;


public interface UserService {
	
	public  User cadastrarNovo(User user);
	
	public User alterarDados(User user);
	
	public List<User> ListarTodos();
	
	public User buscarporNome(String nome);
	
	public  void deletarPorId(int id);
	
	public User buscarPorId(int id);
 
}
