package ie.atu.testpackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExercise2 {
    public static void main(String[] args) {
        String filePath = "input.txt";

        try {
            
            long wordCount = Files.lines(Paths.get(filePath)) 
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(word -> word.length() > 5)  
                .map(String::toUpperCase) 
                .peek(System.out::println) 
                .count();

            System.out.println("\nTotal words processed: " + wordCount);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}