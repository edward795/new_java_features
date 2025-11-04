package org.example.java15;

public class Java15Enhancements {
    public static void main(String[] args) {
        //Simplify writing multiline strings (e.g., JSON, HTML, SQL).
        String html = """
                <html>
                    <body>
                        <p>Hello, World!</p>
                    </body>
                </html>
                """;

        /*
        ✅ Cleaner syntax
        ✅ No need for \n or string concatenation
        ✅ Better readability
         */


        /*
        4. JEP 371: Hidden Classes

            Purpose:
            Support frameworks that generate classes at runtime (like proxies or lambdas)
            without polluting the main class namespace.

            Example:
            Used internally by libraries like ByteBuddy, ASM, and frameworks like Spring or Graal.

            ✅ Hidden from normal reflection
            ✅ Cannot be directly loaded by other classes
            ✅ Improves dynamic language performance

            5. JEP 377: Z Garbage Collector (ZGC) – Production Ready

            ➡️ Moved out of experimental stage.

            Purpose:
            Ultra-low latency garbage collector designed for large heaps (multi-terabyte).

            ✅ Pause times < 10ms
            ✅ Scales from small to very large heaps
            ✅ Concurrent, compacting, and now production-ready

            6. JEP 375: Pattern Matching for instanceof (Second Preview)

            ➡️ Improved from Java 14 preview.

            Example:

            if (obj instanceof String s) {
                System.out.println(s.toLowerCase());
            }


            ✅ No explicit casting
            ✅ Cleaner, more readable conditionals

            7. JEP 379: Shenandoah GC – Production Ready

            ➡️ Promoted from experimental to stable.

            Purpose:
            Another low-pause GC (developed by Red Hat).
            Optimized for low-latency apps, similar to ZGC but different design.

            ✅ Short pauses independent of heap size
            ✅ Works well for concurrent workloads

            8. JEP 383: Reimplement the Legacy DatagramSocket API

            Purpose:
            Modernized the old DatagramSocket and MulticastSocket APIs.

            ✅ Better maintainability and performance
            ✅ Same external behavior, cleaner internal implementation

            9. JEP 385: Deprecate RMI Activation for Removal

            Purpose:
            Deprecated the outdated RMI Activation system — rarely used, complex, and insecure.

            ✅ Simplifies RMI stack
            ✅ Expected removal in future versions
         */

    }
}

final class Circle extends Shape {
};

final class Square extends Shape {
};
