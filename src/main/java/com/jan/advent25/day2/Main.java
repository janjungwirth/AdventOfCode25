package com.jan.advent25.day2;


public class Main {
    public static void main(String[] args) {
        //System.out.println("expected true : " + RangeChecker.isValidExtended(12345678L));
        //System.out.println("expected true : " +RangeChecker.isValidExtended(123L));
        //System.out.println("expected flase : " +RangeChecker.isValidExtended(123123L));
        //System.out.println("expected flase : " +RangeChecker.isValidExtended(11L));
        //System.out.println("expected flase : " +RangeChecker.isValidExtended(1212L));
        //System.out.println("expected flase : " +RangeChecker.isValidExtended(1111111L));
        //System.out.println("expected flase : " +RangeChecker.isValidExtended(2121212121L));
        RangeLoader loader = new RangeLoader("src/main/java/com/jan/advent25/day2/inputDay2.txt");
        RangeChecker checker = new RangeChecker();

        loader.getRanges().forEach(checker::checkRange);
        long result = 0;


        for (Long capturedInvalidID : checker.getCapturedInvalidIDs()) {
            result += capturedInvalidID;
        }


        System.out.println(checker.getCapturedInvalidIDs());
        System.out.println("result : " + result);

    }
}
