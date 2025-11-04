package org.example.java17;


import java.util.random.RandomGenerator;

public class Java17Enhancements {
    public static void main(String[] args) {
        //new pseudo random number generator api
        RandomGenerator gen = RandomGenerator.of("L64X128MixRandom");
        int n = gen.nextInt();
        System.out.println("random num : " + n);
    }

    /*
    🧾 3. Records Enhancements (JEP 395 + JEP 406 integration)

        Records from Java 16 get improved behavior:
        They now work seamlessly with switch pattern matching and serialization frameworks.

        ✅ Why it matters:
        Perfect for concise, immutable data carriers that integrate with modern Java patterns.

        🪶 5. JDK Internals Strongly Encapsulated (JEP 403)

        Java 17 fully seals internal APIs (like sun.misc.Unsafe) except for critical reflection use.

        ✅ Why it matters:
        Improves security, stability, and enforces the module system design started in Java 9.

        🧩 6. Foreign Function & Memory API (JEP 412 — Incubator)

        A new API for Java to interact with native code and memory safely — replacing JNI.

        ✅ Why it matters:
        Safer and easier native interoperability — part of Project Panama.

        ⚙️ 7. Deprecation & Removal Changes
        🧹 Removed: RMI Activation System (JEP 407)

        The legacy Remote Method Invocation (RMI) Activation system was removed.
        ✅ Very few apps used it — simplifies the runtime.

        ⚠️ Deprecated: Applet API (JEP 398)

        The java.applet package was deprecated for removal — web applets are obsolete.

        🧭 8. Enhanced Pseudo-Random Generator (JEP 356)

        Includes new algorithms like LXM and Jumpable/Leapable RNGs.
        ✅ Great for simulations, ML, and scientific apps.

        📦 9. New MacOS Ports (JEP 382 & 391)

        JEP 382: macOS/AArch64 (Apple Silicon M1) port

        JEP 391: macOS x64 improvements

        ✅ Why it matters:
        Full native support for Apple M1 chips — faster startup and lower power consumption.

        🔒 10. Context-Specific Deserialization Filters (JEP 415)

        Adds fine-grained control over Java object deserialization — allows defining rules for what classes can be deserialized.

        ✅ Why it matters:
        Protects against deserialization vulnerabilities (a common attack vector).

        ⚙️ 11. Smaller JVM Enhancements

        ZGC (JEP 391) — Further optimizations; now supports concurrent class unloading.

        JEP 406 — Pattern Matching for switch (Preview).

        Improved JIT compiler & performance.
     */

    //Pattern matching for switch case
    static String formatter(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case String s -> String.format("string %s", s);
            default -> o.toString();
        };
    }
}

//Sealed classes
//Purpose: Control which classes can extend or implement a class/interface.
//Helps you create closed class hierarchies — very useful for domain modeling.
sealed class Shape permits Circle, Rectangle {
}

final class Circle extends Shape {
}

non-sealed class Rectangle extends Shape {
}
