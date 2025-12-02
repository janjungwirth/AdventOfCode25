package com.jan.advent25.day2;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class RangeChecker {
    @Getter
    List<Long> capturedInvalidIDs = new LinkedList<>();
    public static boolean isValid(long input){
        String length = String.valueOf(input);
        int inputLenght = length.length();

        if(inputLenght%2!=0)
            return true;

        String firstHalf = length.substring(0, inputLenght/2);
        String secondHalf = length.substring(inputLenght/2);

        return !firstHalf.equals(secondHalf);
    }

    public List<Long> checkRange(Range range){
        List<Long> invalidIDs = new LinkedList<>();
        for(long i = range.getMin(); i<= range.getMax(); i++){
            if(!isValid(i))
                invalidIDs.add(i);
        }
        this.capturedInvalidIDs.addAll(invalidIDs);
        return invalidIDs;
    }
}
