package com.back_LimpPlast.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back_LimpPlast.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	
	public User findByNome(String nome);
	
	Optional <User> findByEmail(String email);
	
	@Query("select p from User p where p.nome =?1")
	 User findbyJPQL(String   nome );
		 
	 @Query("select p from User p where p.nome=:nome")
	 User findByJPQLNamedParameters(@Param("nome")String nome);
		 
	 
}