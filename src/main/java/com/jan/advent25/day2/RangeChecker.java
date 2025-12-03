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

    public static boolean isValidExtended(long input){
        if(input < 10) return true;

        String check = String.valueOf(input);
        int inputLength = check.length();

        char[] checkBits = check.toCharArray();
        char checkBit = checkBits[0];
        boolean con = true;
        for(char c : checkBits){
            if (c != checkBit) {
                con = false;
                break;
            }
        }
        if(con) return false;

        //Case uneven in thirds eg. 999 : 1111111
        if(inputLength%2!=0) {
            if (checkInThirds(check)) {
                return false;
            }
        }

        if(inputLength%2==0) {
            String firstHalf = check.substring(0, inputLength/2);
            String secondHalf = check.substring(inputLength/2);
            if(firstHalf.equals(secondHalf))
                return false;
            else{
                if(check.length()>2)
                    return !checkInThirds(check) && !(check.split(check.substring(0, 2)).length == 0);
                else return true;
            }
        }
        return true;
    }

    private static boolean checkInThirds(String length) {
        int inputLenght = length.length();

        String firstThird = length.substring(0, inputLenght / 3);
        String secondThird = length.substring(inputLenght / 3, (inputLenght / 3) * 2);
        String thirdThird = length.substring((inputLenght / 3) * 2);
        return firstThird.equals(secondThird) && secondThird.equals(thirdThird);
    }

    public List<Long> checkRange(Range range){
        List<Long> invalidIDs = new LinkedList<>();
        for(long i = range.getMin(); i<= range.getMax(); i++){
            if(!isValidExtended(i))
                invalidIDs.add(i);
        }
        this.capturedInvalidIDs.addAll(invalidIDs);
        return invalidIDs;
    }
}
