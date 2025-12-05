package com.jan.advent25.Day5;

import com.jan.advent25.InputLoader;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RangeSpeedyBoy {

    private static final String PATH = "src/main/java/com/jan/advent25/Day5/input.txt";
    @Getter
    List<BigInteger> ingredients  = new LinkedList<>();

    @Getter
    private static class RangeNode{
        BigInteger start;
        BigInteger end;
        @Setter
        RangeNode next = null;

        RangeNode(BigInteger start, BigInteger end){
            this.start = start;
            this.end = end;
        }
    }

    public RangeSpeedyBoy() {
        ingredients = loadIngredients();
    }

    private static RangeNode loadRanges(){
        RangeNode head = new RangeNode(BigInteger.ZERO, BigInteger.ZERO);
        RangeNode current = head;
        InputLoader loader = new InputLoader();
        List<String> strings = loader.loadFileLines(PATH);
        for(String line : strings){
            if(!line.contains("-"))break;
            String[] split = line.split("-");
            current.setNext(new RangeNode(BigInteger.valueOf(Long.parseLong(split[0])), BigInteger.valueOf(Long.parseLong(split[1]))));
            current = current.getNext();
        }
        return head;
    }

    private LinkedList<BigInteger> loadIngredients(){
        LinkedList<BigInteger> result = new LinkedList<>();
        InputLoader loader = new InputLoader();
        List<String> strings = loader.loadFileLines(PATH);
        for(String line : strings){
            if(line.contains("-") || line.isEmpty())continue;
            result.add(new BigInteger(line));
        }
        return result;
    }

    private static boolean containsNumber(BigInteger number, RangeNode head){
        RangeNode current = head;
        while(current!=null){
            if(current.getStart().compareTo(number)<=0 && current.getEnd().compareTo(number)>=0)return true;
            current = current.next;
        }
        return false;
    }

    private static BigInteger calculateRangeSize(RangeNode head){
        BigInteger result = BigInteger.ZERO;
        RangeNode current = head;
        while(current!=null){
            result = result.add(current.getEnd().subtract(current.getStart()).add(BigInteger.ONE));
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
        RangeNode head = loadRanges();
        RangeSpeedyBoy rangeSpeedyBoy = new RangeSpeedyBoy();
        int freshCounter = 0;
        for(BigInteger ingredient : rangeSpeedyBoy.getIngredients()){
            if(containsNumber(ingredient, head)) freshCounter++;
        }
        System.out.println(freshCounter);

    }


    public static void printRanges(RangeNode head){
        RangeNode current = head;
        while(current.next!=null){
            System.out.println(current.getStart() + "-" + current.getEnd());
            current = current.getNext();
        }
    }


}
