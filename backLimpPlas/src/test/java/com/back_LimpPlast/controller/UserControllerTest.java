package com.back_LimpPlast.controller;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.back_LimpPlast.model.User;
import com.back_LimpPlast.service.cliente.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper mapper;
    
    @MockBean
    private UserService service;
    
    private User user;
    
    @BeforeEach
    public void setup() {
        // Given / Arrange
        user = new User(
             "Augusto",
            "Augusto@gmail.com.br",
              334566,
                556454);
    }
    
    @Test
    @DisplayName(" Create Person then Return Saved Person")
    void testthenReturnSavedPerson() throws JsonProcessingException, Exception {
        
        // Given / Arrange
        given(service.cadastrarNovo(any(User.class)))
            .willAnswer((invocation) -> invocation.getArgument(0));
        
        // When / Act
        ResultActions response = mockMvc.perform(post("/cliente")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(user)));
        
        // Then / Assert
        response.andDo(print()).
            andExpect(status().isOk())
            .andExpect(jsonPath("$.nome", is(user.getNome())))
            .andExpect(jsonPath("$.email", is(user.getEmail())));
    }

}