package com.spring.cloud.countract.demo.contract.producer;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * This class demonstrates the contract test generation.
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RestApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBookWithId10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/book/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookContents").value("Book with the ID 10"));
    }

    @Test
    public void getBookWithIdMinus20() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/book/-20"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Incorrect book id"));
    }
}
