package com.back_LimpPlast.service.cliente;

import java.util.List;

import com.back_LimpPlast.dto.UserDTO;

public interface UserService {
	
	public UserDTO cadastrarNovo(UserDTO userDTO);
	
	public UserDTO alterarDados(UserDTO userDTO);
	
	public List<UserDTO> ListarTodos();
	
	public UserDTO buscarporNome(String nome);
	
	public  void deletarPorId(int id);
	
	public UserDTO buscarPorId(int id);
 
}
