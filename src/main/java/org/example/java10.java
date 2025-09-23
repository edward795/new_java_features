package org.example;

import java.util.ArrayList;

public class java10 {
    public static void main(String[] args) {

        //addition of var local variable
        var list= new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.stream().forEach(System.out::println);


    }
}
