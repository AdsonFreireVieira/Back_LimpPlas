package com.back_LimpPlast.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.back_LimpPlast.dao.UserDao;
import com.back_LimpPlast.model.User;

@DataJpaTest
class UserRepositoryTest {

	@Autowired

	private UserDao repository;
	
  private User user;
	
	@BeforeEach
	public void setup() {
		 user = new User("Adson", "@gmail.com", 2222222, 3445);
		
	}

	@DisplayName("Return Create User")
	@Test

	void testSavesUser() {
		 	
		User savedUser = repository.save(user);

		assertNotNull(savedUser);
		assertTrue(savedUser.getId() > 0);
	}

	@DisplayName("ListFindAllUsers")
	@Test
	void testfindAllReturnListUsers() {

		User user1 = new User("jose", "j@gmail.com", 333333, 3533);
		User user2 = new User("Adriano", "A@gmail.com", 223444222, 4445);

		repository.save(user);
		repository.save(user1);
		repository.save(user2);

		List<User> userList = repository.findAll();

		assertNotNull(userList);
		assertEquals(3, userList.size());
	}

	@DisplayName("Return User findById")
	@Test

	void testfindById() {

		repository.save(user);

		User savedUser = repository.findById(user.getId()).get();

		assertNotNull(savedUser);
		assertEquals(user.getId(), savedUser.getId());
	}

	@DisplayName("Return User findByEmail")
	@Test

	void testfindByEmail() {

		repository.save(user);

		User savedUser = repository.findByEmail(user.getEmail()).get();

		assertNotNull(savedUser);
		assertEquals(user.getEmail(), savedUser.getEmail());
	}

	@DisplayName("Return User  UPDATE")
	@Test

	void testUpdateReturnTrue() {

		repository.save(user);

		User savedUser = repository.findById(user.getId()).get();

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


		repository.save(user);

		repository.deleteById(user.getId());
		Optional<User> UserOptional = repository.findById(user.getId());

		assertTrue(UserOptional.isEmpty());

	}

	@DisplayName("Return User findBy NAme JPQL")
	@Test

	void testfindByNameUser() {

		repository.save(user);

		User savedUser = repository.findbyJPQL(user.getNome());

		assertNotNull(savedUser);
		assertEquals("Adson" , savedUser.getNome());
	}
	@DisplayName("Return User findBy NAme JPQL")
	@Test

	void testfindByNameParameter() {

		repository.save(user);

		User savedUser = repository.findByJPQLNamedParameters(user.getNome());

		assertNotNull(savedUser);
		assertEquals("Adson" , savedUser.getNome());
	}

}
