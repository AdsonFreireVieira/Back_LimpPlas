package backLimpPlas.serviceUser;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.back_LimpPlast.service.cliente.ServiceUserImpl;

import dto.UserDTO;

@DataJpaTest
public class ServiceUserTest {

	
	ServiceUserImpl service;
	
	UserDTO user= new UserDTO("nome", "nome@gmailcom",9999999, 3432);
	
	UserDTO reUser = service.cadastrarNovo(user);
	
	
	
	
}
