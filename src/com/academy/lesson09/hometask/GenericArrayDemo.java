package com.academy.lesson09.hometask;

import java.util.Iterator;

public class GenericArrayDemo {
    public static void main(String[] args) {
        String[] strArr = {"1", "2", "3", "10"};
//        GenericArray<String> genStrArray = new GenericArray<>(new String[10]);
        GenericArray<String> genStrArray = new GenericArray<>(strArr);

        genStrArray.set(0, "1");
        String str = genStrArray.get(0);

        System.out.println(str);
        assert str.equals("1");

        System.out.println(genStrArray);

//        for (String element : genStrArray) {
//            System.out.println(element);
//        }

        System.out.println("group foreach demo");
        Group group = new Group();

        for(int element : group)
            System.out.println(element);

        System.out.println("Так работает foreach");
        Iterator<Integer> iterator = group.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
