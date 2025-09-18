package org.example.java9;

import java.util.List;
import java.util.stream.Stream;

public class StreamAPIImprovements {
    public static void main(String[] args) {

        List<Integer> nums= List.of(1,2,3,4,5,6,7,8);

        //takeWhile
        nums.stream().takeWhile(n->n<5)
                .forEach(System.out::print);


        System.out.println();

        //dropWhile
        nums.stream().dropWhile(n->n<5)
                .forEach(System.out::print);


        //iterate
        //iterate old impl
        Stream.iterate(1,n->n+2)
                .limit(10)
                .forEach(System.out::print);

        System.out.println();

        //iterate new impl
        Stream.iterate(1,n->n<50,n->n+2)
                .forEach(System.out::print);

    }
}
