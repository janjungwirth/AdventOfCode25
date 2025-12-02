package com.jan.advent25.day1;


import com.jan.advent25.InputLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputLoader inputLoader = new InputLoader();
        List<String> lines = inputLoader.loadFileLines("src/main/java/com/jan/advent25/day1/input.txt");

        for (String line : lines) {
            if(line.startsWith("R"))
                Dial1.getInstance().moveRight(Integer.parseInt(line.substring(1)));
            if(line.startsWith("L"))
                Dial1.getInstance().moveLeft(Integer.parseInt(line.substring(1)));
        }
        System.out.println(Dial1.getZEROS());

    }
}