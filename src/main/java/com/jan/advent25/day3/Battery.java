package com.jan.advent25.day3;


import java.util.LinkedList;
import java.util.List;

public class Battery {
    private String line;

    public Battery(String line){
        StringBuilder builder = new StringBuilder(line);
        builder.reverse();
        this.line = builder.toString();
    }

    public int getHighestPosition(String line, int index){
        int result = 0;
        int max=0;
        List<Integer> list = convertStringToIntegerList(line);
        for (int i = index; i < list.size()-index; i++) {
            int check = list.get(i);
            if(check > max) {
                max = check;
                result = i;
            }
        }
        return result;
    }
    public void replaceIndexToA(int index){
        char[] array = line.toCharArray();
        array[index] = 'a';
        line = new String(array);
    }

    private List<Integer> convertStringToIntegerList (String line){
        char[] chars = line.toCharArray();
        List<Integer> result = new LinkedList<>();
        for (char aChar : chars) {
            result.add(Integer.parseInt(String.valueOf(aChar)));
        }
        return result;
    }

    public int calculateJoltage(){
        int highestPosition = getHighestPosition(this.line, 0);
        int one = Integer.parseInt(String.valueOf(line.toCharArray()[highestPosition]));
        replaceIndexToA(highestPosition);

        String[] split = line.split("a");

        int left = -1;
        int right= -1;
        if(!split[0].isEmpty())
            left = Integer.parseInt(String.valueOf(split[0].toCharArray()[this.getHighestPosition(split[0], 0)]));

        if(split.length > 1 && !split[1].isEmpty())
            right = Integer.parseInt(String.valueOf(split[1].toCharArray()[this.getHighestPosition(split[1], 0)]));

        int resultOne = one*10+(left!=-1?left:-9999);
        int resultTwo = right*10+one;

        return Math.max(resultOne, resultTwo);
    }


}
