package com.jan.advent25.day3;

import com.jan.advent25.InputLoader;

import java.util.ArrayList;
import java.util.List;

public class MainPartOne {

    public static void main(String[] args) {
        InputLoader inputLoader = new InputLoader();
        List<String> lines = inputLoader.loadFileLines("src/main/java/com/jan/advent25/day3/input.txt");
        List<Battery> batteries = new ArrayList<>();

        for(String line : lines){
            batteries.add(new Battery(line));
        }

        int result = 0;
        for(Battery battery : batteries){
            result = result + battery.calculateJoltage();
        }

        System.out.println(result);
    }

}
