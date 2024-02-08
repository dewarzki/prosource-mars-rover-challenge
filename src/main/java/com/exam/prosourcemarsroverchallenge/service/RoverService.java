package com.exam.prosourcemarsroverchallenge.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.exam.prosourcemarsroverchallenge.enums.Code;
import com.exam.prosourcemarsroverchallenge.request.CoordinateRequest;
import com.exam.prosourcemarsroverchallenge.response.CoordinateResponse;

public interface RoverService {
    public CoordinateResponse command(CoordinateRequest coordinateRequest);
    default List<Code> stringToListCode(String input){
        return Arrays.asList(input.split(""))
        .stream()
        .map(Code::valueOf)
        .collect(Collectors.toList());
    }
}
