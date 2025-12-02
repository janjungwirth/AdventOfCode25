package com.jan.advent25.day2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("expected true : " + RangeChecker.isValid(12345678));
        System.out.println("expected true : " +RangeChecker.isValid(123));

        System.out.println("expected flase : " +RangeChecker.isValid(123123));
        System.out.println("expected flase : " +RangeChecker.isValid(11));
        System.out.println("expected flase : " +RangeChecker.isValid(1212));
        RangeLoader loader = new RangeLoader();
        RangeChecker checker = new RangeChecker();

        loader.getRanges().forEach(checker::checkRange);
        long result = 0;
        for (Long capturedInvalidID : checker.getCapturedInvalidIDs()) {
            result+=capturedInvalidID;
        }
        System.out.println("result : " + result);

    }
}
