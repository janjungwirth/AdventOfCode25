package com.jan.advent25.Day6;

import com.jan.advent25.InputLoader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class MathLoader {
    InputLoader loader = new InputLoader();
    List<String> lines = loader.loadFileLines("src/main/java/com/jan/advent25/Day6/input.txt");
    List<MathProblem> problems = new LinkedList<>();

    @Getter
    @AllArgsConstructor
    @ToString
    private static class MathProblem{
        List<BigInteger> numbers = new LinkedList<>();
        @Setter
        int ID;
        @Setter
        char operator;
    }


    private void lineFormatter(){
        int numbers = 4;
        List<List<BigInteger>> groups = new LinkedList<>();
        List<Character> operators = new LinkedList<>();
        for(String line : lines){

            String[] split = line.split(" ");

            if(line.startsWith("+") || line.startsWith("*")){
                for(String s : split){
                    if(!s.isEmpty())
                        operators.add(s.charAt(0));
                }
            }else{
                List<BigInteger> lineGroup = new LinkedList<>();
                for(String s : split){
                    if(!s.isEmpty())
                        lineGroup.add(BigInteger.valueOf(Long.parseLong(s)));
                }
                groups.add(lineGroup);
            }
        }
        for(int i = 0; i < groups.getFirst().size(); i++){
            LinkedList<BigInteger> ints = new LinkedList<>();
            for(int j = 0; j < numbers; j++){
                ints.add(groups.get(j).get(i));
            }
            problems.add(new MathProblem(ints,i, operators.get(i)));
        }
    }

    public static void main(String[] args) {
        MathLoader loader = new MathLoader();
        loader.lineFormatter();
        BigInteger result = BigInteger.ZERO;
        for(MathProblem problem : loader.problems){
            BigInteger i = switch (problem.getOperator()) {
                case '+': yield problem.getNumbers().stream().reduce(BigInteger::add).get();
                case '*': yield problem.getNumbers().stream().reduce(BigInteger::multiply).get();
                default:
                    throw new IllegalStateException("Unexpected value: " + problem.getOperator());
            };
            System.out.println(problem.getNumbers()+" "+i+ " " + problem.getOperator());
            result= result.add(new BigInteger(String.valueOf(i)));
        }
        System.out.println(result);
    }

    private void showProbolems(){
        problems.forEach(System.out::println);
    }

}
