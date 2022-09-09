package testintegrado.app.controllers;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import testintegrado.app.controller.PersonControllers;
import testintegrado.app.entity.Person;
import testintegrado.app.repository.PersonRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
@TestPropertySource(properties = {"spring.datasource.url=jdbc:postgresql://localhost:5432/teste"})
public class PersonControllerTest {
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