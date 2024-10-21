package com.back_LimpPlast.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.back_LimpPlast.model.User;


@DataJpaTest
class UserDaoTest {
	
	@Autowired
	
	private UserDao repository;
	
	
	@DisplayName("Return Create User")
	@Test
	
	void testSavesUser() {
		User user = new User("Adson","@gmail.com", 2222222, 3445);
		
		User savedUser = repository.save(user);
		
		assertNotNull(savedUser);
        assertTrue(savedUser.getId()>0);	
	}
	@DisplayName("ListFindAllUsers")
	@Test
	void testfindAllReturnListUsers() {
		User user = new User("Adson","@gmail.com", 2222222, 3445);
		User user1 = new User("jose","j@gmail.com", 333333, 3533);
		User user2 = new User("Adriano","A@gmail.com", 223444222, 4445);


		
	    repository.save(user);
	    repository.save(user1);
	    repository.save(user2);
		
		List<User>  userList = repository.findAll();
		
		assertNotNull(userList);
        assertEquals(3,userList.size());
	}

	@DisplayName("Return User findById")
	@Test
	
	void testfindById() {
		User user = new User("Adson","@gmail.com", 2222222, 3445);
		
	        repository.save(user);
	        
	      User savedUser = repository.findById(user.getId()).get();	
		
		assertNotNull(savedUser);
        assertEquals(user.getId() , savedUser.getId());	
	}
}
