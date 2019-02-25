package com.academy.lesson09;

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
    }
}
