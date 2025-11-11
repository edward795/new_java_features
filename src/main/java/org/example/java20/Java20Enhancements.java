package org.example.java20;

public class Java20Enhancements {
    static ScopedValue<String> USER = ScopedValue.newInstance();

    static final ThreadLocal<String> user = new ThreadLocal<>();

    public static void main(String[] args) {

        //old way
        user.set("Ayyappa");
        System.out.println(user.get());


        //scoped values as replacement for thread local
        ScopedValue.where(USER, "Ayyappadas").run(() -> {
            System.out.println("Current user : " + USER.get());
        });

        try {
            System.out.println(USER.get());
        } catch (IllegalStateException e) {
            System.out.println("No user bound outside scope");
        }

        //record pattern matching

        Object obj=new Point(10,20);


        //old way
        if(obj instanceof Point){
            Point p=(Point)obj;
            System.out.println("The co-ordinates are : "+p.x()+","+p.y());
        }


        //new way
        if(obj instanceof Point(int x,int y)){
            System.out.println("The co-ordinates are : "+x+","+y);
        }

        //new switch case
        describe(new Point(5,5));
        describe(new Point(3,7));
        describe("Hello");

    }

    static void describe(Object obj){
        switch (obj){
            case Point(int x,int y) when x==y -> System.out.println("Diagonal point : "+x);
            case Point(int x,int y)-> System.out.println("Point at ("+x+", "+y+")");
            default -> System.out.println("Not a point");
        }
    }

    public record Point(int x,int y){};
}
