package com.back_LimpPlast.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.model.User;


@Service
public class ServiceUserImpl implements UserService {
	

	@Autowired
	private UserDao dao;

	@Override
	public User cadastrarNovo(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override 
	public User alterarDados(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	public List<User> ListarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public User buscarporNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findByNome(nome);
	}

	@Override
	public void deletarPorId(int id) {
		// TODO Auto-generated method stub
		
		dao.deleteById(id);
		
	}

	@Override
	public User buscarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	} 
	
	

}
