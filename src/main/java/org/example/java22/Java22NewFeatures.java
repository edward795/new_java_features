package org.example.java22;

import java.util.List;

public class Java22NewFeatures {
    public static void main(String[] args) {
        //unnamed variables & patterns
        List<String> list=List.of("apple","orange","guava");
        for(var _:list){
            System.out.println("unnamed variables...");
        }

        try{
            int res=10/0;
        }catch (Exception _){
            System.out.println("Exception "+"Exception occurred...");
        }

        //3. JEP 423 – Region-based Heap Memory (Final)
        //
        //New heap memory model where heap is split into independent regions.
        //Improves performance & scalability for large heap applications.

        //preview features,statements in switch
        testSwitch(0,1,1);

        //7. JEP 463 – Implicitly Declared Classes & Instance Main Methods
        //
        //Write Java like a scripting language.
        //
        //void main() {
        //    System.out.println("Hello!");
        //}
        //
        //
        //No class definition needed.

        //8. JEP 458 – Launch Multi-File Source-Code Programs
        //
        //Run Java files with dependencies without compiling.
        //
        //java Main.java Helper.java Utils.java

    }

    public static void testSwitch(int n,int x,int y){
        switch (n){
            case 0->{x++;y++;}
            case 1->{x++;y--;}
            case 2->{x--;y++;}
            case 3->{x--;y--;}
            default -> System.out.println("Other");
        }
    }
}
