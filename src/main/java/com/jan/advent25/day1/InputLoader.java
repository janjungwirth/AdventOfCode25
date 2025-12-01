package com.jan.advent25.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class InputLoader {

    public List<String> loadFileLines(String input){
        try(BufferedReader br = new BufferedReader(new FileReader(Path.of(input).toFile()))){
            return br.lines().toList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
