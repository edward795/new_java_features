package org.example.java14;

import java.util.ArrayList;
import java.util.HashMap;

public class Java14Enhancements {
    public static void main(String[] args) {

        //pattern matching for instanceof operator
        Object obj="Hello,World!";
        if(obj instanceof String){
            String s=(String) obj;
            System.out.println(s.toLowerCase());
        }

        if(obj instanceof String s){
            System.out.println(s.toLowerCase());
        }

        //Text Blocks
        /*
        Multiline strings with """ (triple quotes).
        Improves readability for JSON, SQL, HTML, XML, etc.
         */
        String json= """
                {
                    "id" : 1,
                    "name" : "Java"
                }
                """;

        //NullPointerExceptions now show which variable was null instead of just saying NullPointerException.
        Person person=null;
        person.age();

        /*
        Instead of just:

        Exception in thread "main" java.lang.NullPointerException


        You now get:

        Cannot invoke "Address.getCity()" because "person.getAddress()" is null
         */

        //Switch Expressions Standard
        int day=3;
        String type=switch(day){
            case 1,2,3,4,5->"Weekday";
            case 6,7->"Weekend";
            default -> throw new IllegalArgumentException("Invalid day");
        };

    }

    record Person(String name,int age){};
}
