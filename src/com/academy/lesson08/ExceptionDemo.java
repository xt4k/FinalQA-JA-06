package com.academy.lesson08;

import static com.academy.lesson06.tests.AbonentTestsDemo2.parseFirstName;

public class ExceptionDemo {
    public static void main(String[] args) {
//        String abonentRawString = "  heLen iVanova 35 f 0501234567";
        String abonentRawString = "";
        String name = parseFirstName(abonentRawString);
        System.out.println(name);

        // => Abonent
    }
}
