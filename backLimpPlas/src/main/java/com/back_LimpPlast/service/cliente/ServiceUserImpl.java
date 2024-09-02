package com.back_LimpPlast.service.cliente;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.model.User;

import dto.UserDTO;
import mapper.GenericModelMapper;



@Service
public class ServiceUserImpl implements UserService {
	
	GenericModelMapper<UserDTO , User>  mapperToUser =  new GenericModelMapper<>(User.class);
	GenericModelMapper<User, UserDTO> mapperToDTO = new GenericModelMapper<>(UserDTO.class);
	

	@Autowired
	private UserDao dao; 
	
	
@Override
	public UserDTO cadastrarNovo(UserDTO userDTO) {
         
	 var  user =  mapperToUser.map(userDTO);
	
	return  mapperToDTO.map(dao.save(user));
		
	}

	@Override
	public UserDTO alterarDados(UserDTO userDTO) {
		
		var user = mapperToUser.map(userDTO);
		
          return mapperToDTO.map(dao.save(user));
		
	}

	@Override
	public List<UserDTO> ListarTodos() {

		  
		return mapperToDTO.mapList(dao.findAll());
		
	}

	@Override
	public UserDTO buscarporNome(String nome) {

		
		return mapperToDTO.map(dao.findByNome(nome));
		
	}

	@Override
	public void deletarPorId(int id) {

		dao.deleteById(id);

	}

	@Override
	public UserDTO buscarPorId(int id) {

		
		return mapperToDTO.map(dao.findById(id).orElse(null));
		
	}

}
