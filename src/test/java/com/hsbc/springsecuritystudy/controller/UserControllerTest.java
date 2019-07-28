package com.hsbc.springsecuritystudy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldGetUsers() throws Exception {
        this.mvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void shouldGetUser() throws Exception {
        this.mvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void shouldCreateUser() throws Exception {
        String result = this.mvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"username\":\"Jayden\",\"password\":\"test\"}"))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void should400WhenCreateUser() throws Exception {
        String result = this.mvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"username\":\"Jayden\",\"password\":\"\"}"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void shouldUpdateUser() throws Exception{
        String result = this.mvc.perform(put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"username\":\"Aiyi\",\"password\":\"\"}"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
}
