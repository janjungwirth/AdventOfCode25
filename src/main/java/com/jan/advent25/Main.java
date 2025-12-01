package com.jan.advent25;


import com.jan.advent25.day1.Dial2;
import com.jan.advent25.day1.InputLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputLoader inputLoader = new InputLoader();
        List<String> lines = inputLoader.loadFileLines("src/main/java/com/jan/advent25/day1/input.txt");

        for (String line : lines) {
            if(line.startsWith("R"))
                Dial2.getInstance().moveRight(Integer.parseInt(line.substring(1)));
            if(line.startsWith("L"))
                Dial2.getInstance().moveLeft(Integer.parseInt(line.substring(1)));
        }
        System.out.println(Dial2.getZEROS());

    }
}