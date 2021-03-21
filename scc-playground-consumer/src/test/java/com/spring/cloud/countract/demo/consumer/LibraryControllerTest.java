package com.spring.cloud.countract.demo.consumer;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.spring.cloud.countract.demo:scc-playground-producer:+:stubs:8090")
public class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnArticleForCorrectActicleId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/library/123"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"article\":\"Book with the ID 123\"}"));
    }

    @Test
    public void shouldReturnErrorForIncorrectActicleId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/library/-222"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("{\"message\":\"not able to find the article\"}"));
    }

    @Test
    public void shouldReturnArticleForCorrectActicleIdWithRestDocsGeneratedStub() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/library/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"article\":\"Book with the ID 10\"}"));
    }

    @Test
    public void shouldReturnErrorForIncorrectActicleIdWithRestDocsGeneratedStub() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/library/-20"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("{\"message\":\"not able to find the article\"}"));
    }
}
