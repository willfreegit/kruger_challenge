package com.will.vaccination.Person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.will.vaccination.person.domain.Person;
import com.will.vaccination.person.infrastructure.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(PersonController.class)
public class PersonWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonController personController;

    @Test
    public void getAllPersonTest() throws Exception{
        Person person = new Person("010","aaa","bbb","xxx",null,null,null);
        when(personController.getAllPersons()).thenReturn(new ResponseEntity(Arrays.asList(person), HttpStatus.OK));
        this.mockMvc.perform(get("/person/getAllPersons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].identification", is("010")));
    }

    @Test
    public void addPersonTest() throws Exception{
        Person person = new Person();
        person.setName("will");
        person.setIdentification("0104112347");
        person.setEmail("xxxx@hotmail.com");
        person.setLastname("zzzz");
        when(personController.addPerson(person)).thenReturn(new ResponseEntity(HttpStatus.CREATED));
        this.mockMvc.perform(post("/person/addPerson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(person))
        ).andExpect(status().isCreated());
    }

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
