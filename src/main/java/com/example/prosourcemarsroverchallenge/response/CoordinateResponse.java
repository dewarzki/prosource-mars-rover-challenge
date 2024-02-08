package com.example.prosourcemarsroverchallenge.response;

import com.example.prosourcemarsroverchallenge.enums.CardinalDirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoordinateResponse {
    private int x;
    private int y;
    private CardinalDirection cardinalDirection = CardinalDirection.N;
    private String output;
    public void incX(){
        x += 1;
    }
    public void decX(){
        x -= 1;
    }
    public void incY(){
        y += 1;
    }
    public void decY(){
        y -= 1;
    }
    public Object thenReturn(CoordinateResponse coordinateResponse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'thenReturn'");
    }
}
