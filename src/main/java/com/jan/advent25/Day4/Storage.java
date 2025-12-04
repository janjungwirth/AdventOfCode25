package com.jan.advent25.Day4;

import com.jan.advent25.InputLoader;

import java.util.LinkedList;
import java.util.List;


public class Storage {
    char[][] storage;

    private void initStorage() {
        InputLoader loader = new InputLoader();
        List<String> strings = loader.loadFileLines("src/main/java/com/jan/advent25/Day4/input.txt");

        storage = new char[strings.size()][strings.get(0).length()];

        for (int x = 0; x < strings.size(); x++) {
            char[] line = strings.get(x).toCharArray();
            for (int y = 0; y < line.length; y++) {
                storage[x][y] = line[y];
            }
        }
    }

    public void printStorage() {
        for(char[] chars : storage){
            for(char c : chars){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public int getAdjesentCount(int x, int y) {
        int count = 0;
        for(int i = x-1; i <= x+1; i++) {
            for(int j = y-1; j <= y+1; j++) {
                if(i == x && j == y) continue;
                if(i >= 0 && i < storage.length && j >= 0 && j < storage[0].length) {
                    if(storage[i][j] == '@' || storage[i][j] == '#') count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.initStorage();
        //storage.partOne();
        storage.partTwo();

    }

    public void partOne(){
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < storage.length; i++) {
            for(int j = 0; j < storage[0].length; j++) {
                if(storage[i][j] != '@') continue;
                list.add(this.getAdjesentCount(i,j));
            }
        }

        System.out.println(list.stream().filter(integer -> {
            return integer < 4;
        }).count());
    }


    public void partTwo(){
        int amount = 0;
        int amountPrev;
        do{
            amountPrev = amount;
            for(int i = 0; i < storage.length; i++) {
                for(int j = 0; j < storage[0].length; j++) {
                    if(storage[i][j] != '@') continue;
                    if(this.getAdjesentCount(i,j)<4){
                        amount++;
                        storage[i][j] = '#';
                    }
                }
            }

            //printStorage();
            for(int i = 0; i < storage.length; i++) {
                for(int j = 0; j < storage[0].length; j++) {
                    if(storage[i][j] == '#') storage[i][j] = '.';
                }
            }

            //System.out.println(amountPrev);
        }while(amountPrev != amount);

        System.out.println(amount);
    }

}
