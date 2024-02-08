package com.exam.prosourcemarsroverchallenge;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.prosourcemarsroverchallenge.controller.RoverController;
import com.exam.prosourcemarsroverchallenge.enums.CardinalDirection;
import com.exam.prosourcemarsroverchallenge.enums.Code;
import com.exam.prosourcemarsroverchallenge.request.CoordinateRequest;
import com.exam.prosourcemarsroverchallenge.response.CoordinateResponse;
import com.exam.prosourcemarsroverchallenge.service.RoverService;
import com.exam.prosourcemarsroverchallenge.service.impl.RoverServiceImpl;
 
@SpringBootTest
public class ProsourceMarsRoverChallengeApplicationTests {

	@InjectMocks
	private RoverService roverService = new RoverServiceImpl();

	@InjectMocks
	private RoverController roverController = new RoverController();

	@Test
	public void stringToListCodeTest(){
		var coordinateRequest = new CoordinateRequest();
		coordinateRequest.setInput("LMLMLMLMLM");
		List<Code> code = Arrays.asList(Code.L,Code.M,Code.L,Code.M,Code.L,Code.M,Code.L,Code.M,Code.L,Code.M);
		assertEquals(code, roverService.stringToListCode(coordinateRequest.getInput()));
	}

	@Test
	public void stringToListCodeTest_NotEqual(){
		var coordinateRequest = new CoordinateRequest();
		coordinateRequest.setInput("LMLMLMLML");
		List<Code> code = Arrays.asList(Code.L,Code.M,Code.L,Code.M,Code.L,Code.M,Code.L,Code.M,Code.L,Code.M);
		assertNotEquals(code, roverService.stringToListCode(coordinateRequest.getInput()));
	}

	@Test
	public void commandTest(){
		var coordinateRequest = new CoordinateRequest();
		coordinateRequest.setInput("LMLMLMLMLM");
		var coordinateResponse = CoordinateResponse.builder()
		.cardinalDirection(CardinalDirection.W)
		.x(-1)
		.y(0)
		.output("1, 0, W")
		.build();
		assertEquals(coordinateResponse, roverService.command(coordinateRequest));
	}

	@Test
	public void commandTest_NotEqual(){
		var coordinateRequest = new CoordinateRequest();
		coordinateRequest.setInput("LMLMLMLML");
		var coordinateResponse = CoordinateResponse.builder()
		.cardinalDirection(CardinalDirection.W)
		.x(-1)
		.y(0)
		.output("1, 0, W")
		.build();
		assertNotEquals(coordinateResponse, roverService.command(coordinateRequest));
	}
}
