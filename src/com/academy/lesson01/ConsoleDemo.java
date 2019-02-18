package com.telesens.academy.lesson01;

import java.util.Scanner;

public class ConsoleDemo {
    public static void main(String[] args) {
        System.out.println("Моя первая программа!");
        // Ввод размера фигуры
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер: ");


        int size = scanner.nextInt();

        // Вывод фигуры
        for  (int i = 1; i <= size; i++)
            // 1 способ
//            System.out.println(String.format("%." + i + "s", "********"));

            // 2 способ
            //        System.out.println(
////                String.format("%03d", 0).replace("0", "*"));
            System.out.println(
                    String.format("%0" + i + "d", 0).replace("0", "*"));
    }
}
