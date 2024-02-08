package com.exam.prosourcemarsroverchallenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.exam.prosourcemarsroverchallenge.request.CoordinateRequest;
import com.exam.prosourcemarsroverchallenge.service.RoverService;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebMvcTest
public class RoverControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;   
    @MockBean
    private RoverService roverService;

    @SuppressWarnings("null")
    @Test
    public void commandTestAPI() throws Exception {
        var coordinateRequest = new CoordinateRequest();
		coordinateRequest.setInput("LMLMLMLMLM");
        
        mockMvc.perform(post("/rovercontrol/command")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(coordinateRequest)))
            .andExpect(status().isOk());
    }

    @SuppressWarnings("null")
    @Test
    public void commandTestAPI_WrongPostMappingParams() throws Exception {
        var coordinateRequest = new CoordinateRequest();
		coordinateRequest.setInput("LMLMLMLMLM");

        mockMvc.perform(post("/rovercontrol/commander")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(coordinateRequest)))
            .andExpect(status().isNotFound());
    }
}