package com.example.prosourcemarsroverchallenge.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.prosourcemarsroverchallenge.enums.CardinalDirection;
import com.example.prosourcemarsroverchallenge.enums.Code;
import com.example.prosourcemarsroverchallenge.request.CoordinateRequest;
import com.example.prosourcemarsroverchallenge.response.CoordinateResponse;
import com.example.prosourcemarsroverchallenge.service.RoverService;

@Service
public class RoverServiceImpl implements RoverService{

    @Override
    public CoordinateResponse command(CoordinateRequest coordinateRequest) {
        List<Code> code = stringToListCode(coordinateRequest.getInput());
        CoordinateResponse coordinateResponse = new CoordinateResponse();
        code.forEach(c -> direction(c, coordinateResponse));
        coordinateResponse.setOutput(Math.abs(coordinateResponse.getX()) + ", " + Math.abs(coordinateResponse.getY()) + ", " + coordinateResponse.getCardinalDirection());
        return coordinateResponse;
    }
 
    private void direction(Code code, CoordinateResponse coordinateResponse){
        switch(code){
            case M:
                mDirection(coordinateResponse);
                break;
            case L:
                lDirection(coordinateResponse);
                break;
            case R:
                rDirection(coordinateResponse);
            default:
                break;
        }
    }

    private void mDirection(CoordinateResponse coordinateResponse){
        switch (coordinateResponse.getCardinalDirection()) {
            case N:
                coordinateResponse.incY();
                break;
            case S:
                coordinateResponse.decY();
                break;
            case E:
                coordinateResponse.incX();
                break;
            case W:
                coordinateResponse.decX();
                break;
            default:
                break;
        }
    }

    private void lDirection(CoordinateResponse coordinateResponse){
        switch (coordinateResponse.getCardinalDirection()) {
            case N:
                coordinateResponse.setCardinalDirection(CardinalDirection.W);
                break;
            case S:
                coordinateResponse.setCardinalDirection(CardinalDirection.E);
                break;
            case E:
                coordinateResponse.setCardinalDirection(CardinalDirection.N);
                break;
            case W:
                coordinateResponse.setCardinalDirection(CardinalDirection.S);
                break;
            default:
                break;
        }
    }

    private void rDirection(CoordinateResponse coordinateResponse){
        switch (coordinateResponse.getCardinalDirection()) {
            case N:
                coordinateResponse.setCardinalDirection(CardinalDirection.E);
                break;
            case S:
                coordinateResponse.setCardinalDirection(CardinalDirection.W);
                break;
            case E:
                coordinateResponse.setCardinalDirection(CardinalDirection.S);
                break;
            case W:
                coordinateResponse.setCardinalDirection(CardinalDirection.N);
                break;
            default:
                break;
        }
    }
}
