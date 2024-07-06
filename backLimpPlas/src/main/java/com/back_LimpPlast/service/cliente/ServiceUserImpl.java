package com.back_LimpPlast.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.dto.UserDTO;
import com.back_LimpPlast.model.User;

@Service
public class ServiceUserImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public UserDTO cadastrarNovo(UserDTO userDTO) {

		User newUser = new User();

		newUser.setId_Cliente(userDTO.getId());
		newUser.setEmail(userDTO.getEmail());
		newUser.setDocumento(userDTO.getDocumento());
		newUser.setNome(userDTO.getNome());
		newUser.setTelefone(userDTO.getTelefone());

		var user = dao.save(newUser);

		UserDTO uDTO = new UserDTO(user);

		uDTO.setDocumento(user.getDocumento());
		uDTO.setId(user.getId());
		uDTO.setEmail(user.getEmail());
		uDTO.setNome(user.getNome());
		uDTO.setTelefone(user.getTelefone());

		return uDTO;
	}

	@Override
	public UserDTO alterarDados(UserDTO userDTO) {

		User newUser = new User();

		newUser.setId_Cliente(userDTO.getId());
		newUser.setEmail(userDTO.getEmail());
		newUser.setDocumento(userDTO.getDocumento());
		newUser.setNome(userDTO.getNome());
		newUser.setTelefone(userDTO.getTelefone());

		var user = dao.save(newUser);

		UserDTO uDTO = new UserDTO(user);

		uDTO.setDocumento(user.getDocumento());
		uDTO.setId(user.getId());
		uDTO.setEmail(user.getEmail());
		uDTO.setNome(user.getNome());
		uDTO.setTelefone(user.getTelefone());

		return uDTO;
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
