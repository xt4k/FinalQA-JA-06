package com.academy.lesson09;

import com.academy.lesson06.model.Abonent;

import java.util.Arrays;

public class GenericDemo {
    public static void main(String[] args) {
        Container<String> container = new Container<>();
        container.setValue("Hello");
        String msg = container.getValue();
        System.out.println(msg);

        Container<Integer> integerContainer = new Container<>();
        integerContainer.setValue(23);
        Integer n = integerContainer.getValue();
        System.out.println(n);
//        integerContainer.setValue("Hello"); // так нельзя

        Container<Object> containerObj = new Container<>();
//        Container containerObj = new Container();
        containerObj.setValue(1);
        int m = (int)containerObj.getValue();
        System.out.println(m);

        PairContainer<Integer, String> pair = new PairContainer<>();
        pair.setFirstValue(2);
        pair.setSecondValue("2");

        System.out.println(pair.getFirstValue() + "=>" + pair.getSecondValue());

        Container<Container<String>> containerNested = new Container<>();
        containerNested.setValue(container);

        Container<Container<PairContainer<Integer, Abonent>>> hardCodeContainer = null;

        System.out.println("========");
        PairContainer<Integer[], String[]> pairContainer = new PairContainer<>();
        String[] arrStr = {"1", "2", "3"};
        System.out.println(Arrays.toString(arrStr));
        pairContainer.setFirstValue(new Integer[]{1, 2, 3});
        pairContainer.setSecondValue(arrStr);
        System.out.println(pair);
        System.out.println(pairContainer);
    }
}
