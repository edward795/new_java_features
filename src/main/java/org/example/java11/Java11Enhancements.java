package org.example.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.BiFunction;

public class Java11Enhancements {
    public static void main(String[] args) throws IOException, InterruptedException {

        //var keyword enhancement in lambda

        //Before Java 11
        BiFunction<Integer,Integer,Integer> add=(a,b)->a+b;

        //After Java 11
        BiFunction<Integer,Integer,Integer> add1=(var a ,var b)->a+b;


        //Stream api improvements
        String text="  Hello,World  \n" +
                "  This is my first Program in Java \n"
                +"  Java is a great language.";

        System.out.println("is the text blank ? :"+text.isBlank());
        System.out.println("extracting the lines : ");
        text.lines().forEach(System.out::println);
        System.out.println(text.strip());
        System.out.println(text.stripIndent());
        System.out.println(text.stripTrailing());

        //Optional Enhancements
        Optional<String> sampleTxt=Optional.of(" ");
        System.out.println(sampleTxt.isEmpty());
        System.out.println(sampleTxt.isPresent());

        //File I/O Enhancements
        Path path=Path.of("src/main/resources/example.txt");
        Files.writeString(path,"Hello Java 11");
        String content=Files.readString(path);
        System.out.println(content);

        //Paths.get() --> Paths.of() enhancement
        //single path
        Path path1=Path.of("folder/file.txt");
        System.out.println(path1);

        //multiple parts of a path
        //relative path
        Path path2=Path.of("folder","subfolder","file.txt");
        System.out.println(path2);

        //absolute path
        Path path3=Path.of("/Users/ayyappadas/Documents/test.txt");
        System.out.println(path3);

        //URI support
        URI uri=URI.create("file:///Users/ayyappadas/text.txt");
        Path path4=Path.of(uri);
        System.out.println(uri);

        //New HTTP client API(standard)
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .build();
        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //Running Single source file
        //you can now run single source files in java without compiling first
        //java HelloWorld.java

    }
}
