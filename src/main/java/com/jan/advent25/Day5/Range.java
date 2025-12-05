package com.jan.advent25.Day5;

import com.jan.advent25.InputLoader;
import lombok.Getter;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Range {

    String path = "src/main/java/com/jan/advent25/Day5/input.txt";

    List<BigInteger> range = new LinkedList<>();
    @Getter
    List<BigInteger> ingredients  = new LinkedList<>();

    public Range(){
        this.loadRange();
        this.loadIngredients();
    }

    private void loadRange(){
        InputLoader loader = new InputLoader();
        List<String> strings = loader.loadFileLines(path);
        for(String line : strings){
            if(!line.contains("-"))break;
            String[] split = line.split("-");
            for(BigInteger i = BigInteger.valueOf(Long.parseLong(split[0])); i.compareTo(BigInteger.valueOf(Long.parseLong(split[1])))<=0; i = i.add(BigInteger.ONE)){
                range.add(i);
            }
        }
        System.out.println(range);
    }

    private void loadIngredients(){
        InputLoader loader = new InputLoader();
        List<String> strings = loader.loadFileLines(path);
        for(String line : strings){
            if(line.contains("-") || line.isEmpty())continue;
            ingredients.add(new BigInteger(line));
        }
        System.out.println(ingredients);
    }

    private boolean isFresh(BigInteger ingredient){
        return range.contains(ingredient);
    }

    public static void main(String[] args) {
        Range range = new Range();
        int counter = 0;
        for(BigInteger ingredient : range.getIngredients())
            if(range.isFresh(ingredient)) counter++;
        System.out.println(counter);
    }
}
