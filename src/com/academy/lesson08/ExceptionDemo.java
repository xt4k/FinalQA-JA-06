package com.academy.lesson08;

import com.academy.lesson06.tests.AbonentParser;
import com.academy.lesson06.tests.ParseAbonentException;


public class ExceptionDemo {
    public static void main(String[] args) {
//        String abonentRawString = "  heLen iVanova 35 f 0501234567";
        String abonentRawString = "";
        // 1 Обработать ситуацию ParseAbonentException
        // 2 Обработать ситуацию любая другая ошибка
        String name = null;
        try {
            name = AbonentParser.parseFirstName(abonentRawString);
        } catch (ParseAbonentException e) {
            System.out.println("Empty row. Details: " + e);
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Unknown error. Details: " + e);
            System.exit(1);
        }
        System.out.println(name);
        // ДЗ
        // => Abonent
    }
}
