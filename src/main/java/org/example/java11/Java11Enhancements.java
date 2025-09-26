package org.example.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.BiFunction;

public class Java11Enhancements {
    public static void main(String[] args) throws IOException {

        //var keyword enhancement in lambda

        //Before Java 11
        BiFunction<Integer,Integer,Integer> add=(a,b)->a+b;

        //After Java 11
        BiFunction<Integer,Integer,Integer> add1=(var a ,var b)->a+b;


        //Stream api improvements
        String text="  Hello,World  \n" +
                "  My first Program in Java ";
        System.out.println(text.isBlank());
        System.out.println(text.strip());
        System.out.println("Hi!".repeat(3));

        System.out.println();
        text.lines().forEach(System.out::println);

        //Optional Enhancements
        Optional<String> sampleTxt=Optional.of(" ");
        System.out.println(sampleTxt.isEmpty());
        System.out.println(sampleTxt.isPresent());

        //File I/O Enhancements
        Path path=Path.of("src/main/resources/example.txt");
        Files.writeString(path,"Hello Java 11");
        String content=Files.readString(path);
        System.out.println(content);
    }
}
