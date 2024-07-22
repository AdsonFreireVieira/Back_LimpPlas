package com.back_LimpPlast.service.cliente;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.dto.UserDTO;


@Service
public class ServiceUserImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public UserDTO cadastrarNovo(UserDTO userDTO) {

		var user = UserDTO.convertToUser(userDTO);

		dao.save(user);

		return UserDTO.convertToUserDTO(user);
	}

	@Override
	public UserDTO alterarDados(UserDTO userDTO) {

		var user = UserDTO.convertToUser(userDTO);

		dao.save(user);

		return UserDTO.convertToUserDTO(user);
	}

	@Override
	public List<UserDTO> ListarTodos() {

		return UserDTO.convertToListDTO( dao.findAll());
	}

	@Override
	public UserDTO buscarporNome(String nome) {

		return UserDTO.convertToUserDTO(dao.findByNome(nome));
	}

	@Override
	public void deletarPorId(int id) {

		dao.deleteById(id);

	}

	@Override
	public UserDTO buscarPorId(int id) {

		return UserDTO.convertToUserDTO(dao.findById(id).orElse(null));
	}

}
