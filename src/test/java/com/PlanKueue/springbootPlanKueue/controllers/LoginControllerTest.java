package com.PlanKueue.springbootPlanKueue.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

@SpringJUnitConfig
@WebMvcTest(Login.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowLoginForm() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void testProcessLogin() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "john")
                .param("password", "doe"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/"));
    }
}
