package org.example.java15;

//Sealed Classes
//Restrict which classes can extend or implement a class/interface.
/*
✅ Adds controlled inheritance.
✅ Useful for pattern matching, domain modeling, and safety.
 */
public sealed class Shape permits Circle, Square {
}
