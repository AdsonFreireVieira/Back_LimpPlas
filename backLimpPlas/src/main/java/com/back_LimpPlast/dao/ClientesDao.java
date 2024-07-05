package com.back_LimpPlast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_LimpPlast.model.User;

public interface ClientesDao extends JpaRepository<User, Integer> {

	
	public User findByNome(String nome);
}
