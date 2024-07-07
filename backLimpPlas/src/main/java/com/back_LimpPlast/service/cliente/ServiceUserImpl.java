package com.back_LimpPlast.service.cliente;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

		var user = UserDTO.converttoUser(userDTO);

		dao.save(user);

		return UserDTO.converttoDTO(user);
	}

	@Override
	public UserDTO alterarDados(UserDTO userDTO) {

		var user = UserDTO.converttoUser(userDTO);

		dao.save(user);

		return UserDTO.converttoDTO(user);
	}

	@Override
	public List<UserDTO> ListarTodos() {

		return dao.findAll().stream().map(UserDTO::toDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO buscarporNome(String nome) {

		return UserDTO.converttoDTO(dao.findByNome(nome));
	}

	@Override
	public void deletarPorId(int id) {

		dao.deleteById(id);

	}

	@Override
	public UserDTO buscarPorId(int id) {

		return UserDTO.converttoDTO(dao.findById(id).orElse(null));
	}

}
