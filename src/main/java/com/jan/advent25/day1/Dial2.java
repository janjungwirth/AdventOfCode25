package com.jan.advent25.day1;

import lombok.Getter;

public class Dial2 {
    @Getter
    private static final Dial2 instance = new Dial2();

    @Getter
    private static int position = 50;

    @Getter
    private static int ZEROS = 0;

    private Dial2(){}
    public Dial2 moveRight(int steps) {
        for(int i = steps; i > 0; i--){
            position+=1;
            if(position == 100) {
                position = 0;
                ZEROS++;
            }
        }
        return instance;
    }

    public Dial2 moveLeft(int steps) {
        for(int i = steps; i > 0; i--){
            position-=1;
            if(position < 0) {
                position = 99;
                ZEROS++;
            }
        }
        return instance;
    }

}
