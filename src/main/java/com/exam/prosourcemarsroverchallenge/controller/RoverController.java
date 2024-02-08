package com.exam.prosourcemarsroverchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.prosourcemarsroverchallenge.enums.CardinalDirection;
import com.exam.prosourcemarsroverchallenge.request.CoordinateRequest;
import com.exam.prosourcemarsroverchallenge.response.CoordinateResponse;
import com.exam.prosourcemarsroverchallenge.service.RoverService;

@RestController
@RequestMapping("/rovercontrol")
public class RoverController {
    
    @Autowired
    private RoverService roverService;
    
    @PostMapping("/command")
    public CoordinateResponse command(@RequestBody CoordinateRequest coordinateRequest){
        try {
            return roverService.command(coordinateRequest);
        } catch (Exception e){
            return CoordinateResponse
            .builder()
            .cardinalDirection(CardinalDirection.N)
            .output("Wrong input combination! it must be 'M, L or R' only").build();
        }
    }   
}
