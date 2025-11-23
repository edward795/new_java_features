package org.example.java21;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
import java.util.concurrent.*;

import static java.lang.StringTemplate.STR;
import static java.lang.foreign.ValueLayout.JAVA_INT;

public class Java21Enhancements {
    static final ScopedValue<String> USER = ScopedValue.newInstance();

    public static void main(String[] args) {
        //virtual threads
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                int id = i;
                executor.submit(() -> {
                    System.out.println("Task " + id + " on " + Thread.currentThread());
                    Thread.sleep(500);
                    return null;
                });
            }
        }

        //structured concurrency
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> user = scope.fork(() -> getUser()).get();
            Future<Integer> orders = scope.fork(() -> getOrders()).get();

            scope.join();
            scope.throwIfFailed();

            System.out.println(user.resultNow() + " has " + orders.resultNow() + " orders ");
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Record Patterns
        Object obj = new Point(5, 10);
        if (obj instanceof Point(int x, int y)) {
            System.out.println("x=" + x + "y=" + y);
        }

        //Pattern Matching for switch
        Object obj1 = "Ayyappadas";
        System.out.println(formatter(obj1));

        //scoped values
        ScopedValue.where(USER,"Ayyappadas").run(()->{
            System.out.println("Current User : "+USER.get());
        });

        //Sequenced Collections
       SequencedCollection<String> sequencedList=new ArrayList<>(List.of("A","B","C"));
        System.out.println(sequencedList.getFirst());
        System.out.println(sequencedList.getLast());
        sequencedList.addFirst("Start");
        sequencedList.addLast("End");
        System.out.println(sequencedList);

        //foreign function & memory api
        try(Arena arena=Arena.ofConfined()){
            MemorySegment segment=arena.allocate(JAVA_INT);
            segment.set(JAVA_INT,0,42);
            System.out.println(segment.get(JAVA_INT,0));
        }

        //unnamed patterns and variables
       process((Point) obj);

        //string templates
//        int age=25;
//        String name="Ayyappadas";
//        String msg=STR."Hello \{name},you are \{age} years old";
//        System.out.println(msg);
    }


    static String formatter(Object obj) {
        return switch (obj) {
            case String s when s.length() > 5 -> "long string";
            case String s -> s;
            case null      -> "null";
            default        -> "other";
        };
    }

    static void process(Point p){
        if(p instanceof Point(int _,int y)){
            System.out.println("Only care about y="+y);
        }
    }

    static Future<String> getUser() throws InterruptedException {
        return CompletableFuture.completedFuture("Ayyappadas");
    }

    static Future<Integer> getOrders() throws InterruptedException {
        return CompletableFuture.completedFuture(5);
    }

    public record Point(int x, int y) {
    }
}
