package com.example.prosourcemarsroverchallenge.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.prosourcemarsroverchallenge.enums.Code;
import com.example.prosourcemarsroverchallenge.request.CoordinateRequest;
import com.example.prosourcemarsroverchallenge.response.CoordinateResponse;

public interface RoverService {
    public CoordinateResponse command(CoordinateRequest coordinateRequest);
    default List<Code> stringToListCode(String input){
        return Arrays.asList(input.split(""))
        .stream()
        .map(Code::valueOf)
        .collect(Collectors.toList());
    }
}
