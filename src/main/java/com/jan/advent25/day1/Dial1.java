package com.jan.advent25.day1;

import lombok.Getter;

public class Dial1 {
    @Getter
    private static final Dial1 instance = new Dial1();

    @Getter
    private static int position = 50;

    @Getter
    private static int ZEROS = 0;

    private Dial1(){}
    public Dial1 moveRight(int steps) {
        for(int i = steps; i > 0; i--){
            position+=1;
            if(position == 100)
                position = 0;
        }
        if(position == 0)
            ZEROS++;
        return instance;
    }

    public Dial1 moveLeft(int steps) {
        for(int i = steps; i > 0; i--){
            position-=1;
            if(position < 0)
                position = 99;
        }
        if(position == 0)
            ZEROS++;
        return instance;
    }

}
