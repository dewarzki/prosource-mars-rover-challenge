package com.exam.prosourcemarsroverchallenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.prosourcemarsroverchallenge.controller.RoverController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    RoverController roverController;

    @Test
	void contextLoads() throws Exception {
		assertThat(roverController).isNotNull();
	}
}
