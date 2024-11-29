package com.back_LimpPlast.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.cliente.ServiceUserImpl;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

	@Mock
	private UserDao repository;

	@InjectMocks 
	private ServiceUserImpl service;

	private User user;

	@BeforeEach
	void setup() {
		user = new User(30, "jose", "jose@bol.com", 99340034, 3343434);

	}

	@DisplayName("Return Create User")
	@Test
	void testSavesUser() {

		given(repository.save(user)).willReturn(user);

		User returnUser = service.cadastrarNovo(user);

		assertNotNull(returnUser);

	}

	@DisplayName("ListFindAllUsers")
	@Test
	void testfindAllReturnListUsers() {

		User user1 = new User("jose", "j@gmail.com", 333333, 3533);
		User user2 = new User("Adriano", "A@gmail.com", 223444222, 4445);

		given(repository.findAll()).willReturn(List.of(user, user1, user2));

		List<User> userList = repository.findAll();

		assertNotNull(userList);
		assertEquals(3, userList.size());
	}

	@DisplayName("Return User findById")
	@Test

	void testfindById() {

		given(repository.findById(user.getId())).willReturn(Optional.of(user));

		User savedUser = service.buscarPorId(user.getId());

		assertNotNull(savedUser);
		assertEquals(user.getId(), savedUser.getId());
	}

	@DisplayName("Return User findByEmail")
	@Test

	void testfindByEmail() {

        
		given(repository.findByEmail(user.getEmail())).willReturn(Optional.of(user));

		User savedUser = repository.findByEmail(user.getEmail()).get();
		
		

		assertNotNull(savedUser);
		assertEquals(user.getEmail(), savedUser.getEmail());
	}

	@DisplayName("Return User  UPDATE")
	@Test

	void testUpdateReturnTrue() {
  
		 given(repository.save(user)).willReturn(user);
		
		
		User savedUser = service.alterarDados(user);
		savedUser.setNome("luiz");
		savedUser.setEmail("luis@gmail.com");

		User userUpdate = repository.save(savedUser);

		assertNotNull(savedUser);
		assertEquals("luiz", userUpdate.getNome());
		assertEquals("luis@gmail.com", userUpdate.getEmail());
	}

	@Test
	@DisplayName("DeleteUSer")

	void TesteDeleteUserReturn() {
 
		 
		doNothing().when(repository).deleteById(user.getId());

		service.deletarPorId(user.getId());

		  verify(repository,times(1)).deleteById(user.getId());

	}

	@DisplayName("Return User findBy NAme JPQL")
	@Test

	void testfindByNameUser() {

		
		given(repository.findByNome(user.getNome())).willReturn(user);

		User savedUser = service.buscarporNome(user.getNome());

		assertNotNull(savedUser);
		assertEquals("jose", savedUser.getNome());
	}



}
