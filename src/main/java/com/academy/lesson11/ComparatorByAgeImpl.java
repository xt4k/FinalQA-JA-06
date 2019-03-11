package com.academy.lesson11;

import java.util.Comparator;

public class ComparatorByAgeImpl implements Comparator<Subscriber> {

    // 1 способ
//    @Override
//    public int compare(Subscriber o1, Subscriber o2) {
//        if (o1.getAge() < o2.getAge())
//            return -1;
//
//        if (o1.getAge() > o2.getAge())
//            return 1;
//
//        // if (o1.getAge() == o2.getAge())
//        return 0;
//    }

    // 2 способ
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
       return Integer.compare(o1.getAge(), o2.getAge());
    }
}
