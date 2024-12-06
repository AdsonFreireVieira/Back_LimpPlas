package com.back_LimpPlast.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.back_LimpPlast.Exception.ResourceNotFoundException;
import com.back_LimpPlast.Exceptions.ResourceNotFoundException;
import com.back_LimpPlast.Exceptions.Exceptions;
import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.cliente.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ClienteController.class)
class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private UserService service;

	private User user;

	@BeforeEach

	void setup() {

		user = new User(12, "jose", "Jose@gmail.com", 99887733, 88990);

	}

	@DisplayName("CreateUSerController")
	@Test

	public void CreateUserTestControllerSucess() throws JsonProcessingException, Exception {

		given(service.cadastrarNovo(any(User.class))).willAnswer(invocation -> invocation.getArgument(0));

		ResultActions response = mockMvc.perform(
				post("/cliente").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(user)));

		response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.nome", is(user.getNome())))
				.andExpect(jsonPath("$.email", is(user.getEmail())));

	}

	@DisplayName("FindAllUSerController")
	@Test

	public void FindAllUserTestControllerSucess() throws JsonProcessingException, Exception {

		List<User> users = new ArrayList<>();

		users.add(user);
		users.add(new User(23, "MAria", "MAria@gmail", 988976547, 2332));

		given(service.ListarTodos()).willReturn(users);

		ResultActions response = mockMvc.perform(get("/cliente"));

		response.andExpect(jsonPath("$.size()", is(users.size())));	

	}

	@DisplayName("FindByIdTestController")
	@Test
	public void findByidUserControllerSucess() throws JsonProcessingException, Exception {
      
		given(service.buscarPorId(user.getId())).willReturn(user);

		ResultActions response = mockMvc.perform(get("/cliente/{id}", user.getId()));

		response.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.nome", is(user.getNome())))
				.andExpect(jsonPath("$.email", is(user.getEmail())));

	}
	@DisplayName("InvalidFindByIdTestController")
	@Test
	public void findByidInvalidControllerreturnNotFound() {
      
		given(service.buscarPorId(user.getId())).willThrow(ResourceNotFoundException.class);

		ResultActions response;
		try {
			response = mockMvc.perform(get("/cliente/{id}", user.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.andExpect(status(). isNotFound()).andDo(print());

	}
}
