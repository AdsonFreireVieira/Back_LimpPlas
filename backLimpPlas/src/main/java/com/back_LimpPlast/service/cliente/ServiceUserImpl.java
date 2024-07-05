package com.back_LimpPlast.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_LimpPlast.dao.ClientesDao;
import com.back_LimpPlast.model.User;

@Service
public class ServiceUserImpl implements UserService {

	 @Autowired
	private ClientesDao dao; 
	 
	@Override
	public User cadastrarNovo(User cliente) {
		
		return dao.save(cliente);
	}

	@Override
	public User alterarDados(User alterar) {
		 
		return dao.save(alterar);
	}

	@Override
	public List<User> ListarTodos() {
		
		return dao.findAll();
	}

	@Override
	public User buscarporNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override
	public void deletarPorId(int id) {
		
		dao.deleteById(id);
		
	}

	@Override
	public User buscarPorId(int id) {
	
		return dao.findById(id).orElse(null);
	}

}
