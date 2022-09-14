package testintegrado.app.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import testintegrado.app.abstrato.ControllerTeste;
import testintegrado.app.controller.PersonControllers;
import testintegrado.app.entity.Person;
import testintegrado.app.repository.PersonRepository;


public class PersonControllerTest extends ControllerTeste {
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private PersonControllers personControllers;
    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(personControllers).build();
    }

    @Test
    public void save() throws Exception {
        Person joao = new Person(null, "jao", 22);
        String jsonString = new ObjectMapper().writeValueAsString(joao);

        mockMvc.perform(post("/pessoas").contentType("application/json").content(jsonString))
                .andExpect(status().isOk());
    }
    @Test
    public void listOfPerson() throws Exception {
        Person joao = new Person(null, "jao", 22);
        String jsonString = new ObjectMapper().writeValueAsString(joao);

        mockMvc.perform(post("/pessoas").contentType("application/json").content(jsonString))
                .andExpect(status().isOk());

        mockMvc.perform(get("/pessoas").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].name").value("jao"));


    }
}