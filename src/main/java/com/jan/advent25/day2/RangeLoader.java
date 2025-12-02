package com.jan.advent25.day2;

import com.jan.advent25.InputLoader;
import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RangeLoader {
    private InputLoader loader = new InputLoader();
    private String filePath = "src/main/java/com/jan/advent25/day2/inputDay2.txt";
    @Getter
    private List<Range> ranges = new LinkedList<>();

    public RangeLoader(String filePath){
        this.filePath = filePath;
        this.ranges = this.load();
    }
    public RangeLoader(){
        this.ranges = this.load();
    }


    private List<Range> load(){
        List<Range> result = new LinkedList<>();
        String input = loader.loadFileLines(filePath).getFirst();

        List<String> split = Arrays.stream(input.split(",")).toList();
        for(String element : split){
            String[] split1 = element.split("-");
            Range entry = new Range(Long.parseLong(split1[0]), Long.parseLong(split1[1]));
            result.add(entry);
        }
        return result;
    }
}
