package org.example.java12;

import java.text.NumberFormat;
import java.util.Locale;

public class Java12Enhancements {
    public static void main(String[] args) {

        //improved switch expression
        System.out.println(calculator(10,2,'+'));
        System.out.println(newCalculator(10,2,'+'));

        //compact number formatting
        NumberFormat nf=NumberFormat.getCompactNumberInstance(
                Locale.US,NumberFormat.Style.SHORT
        );
        System.out.println(nf.format(22000));

        //New String Methods
        String s="hello\nworld";
        System.out.println(s.indent(2));
        String upper=s.transform(String::toUpperCase);
        System.out.println(upper);
    }


    //switch as a statement
    public static int calculator(int n1,int n2,char operator){
        switch(operator){
            case '+':
                return n1+n2;
            case '-':
                return n1-n2;
            case '*':
                return n1*n2;
            case '/':
                return n1/n2;
            default:
                return -1;
        }
    }

    //switch as an expression
    public static int newCalculator(int n1,int n2,char operator){
        return switch (operator){
            case '+'->n1+n2;
            case '-'->n1-n2;
            case '*'->n1*n2;
            case '/'->n1/n2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

}
