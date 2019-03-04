package com.academy.lesson11;

import java.util.ArrayList;
import java.util.List;

public class SubscriberDemo {
    public static void main(String[] args) {
        // Operators
        Operator operatorLife = new Operator();
        operatorLife.setId(1L);
        operatorLife.setName("Life");

        Operator operatorKievstar = new Operator();
        operatorLife.setId(2L);
        operatorLife.setName("Kievstar");

        Operator operatorVodafone = new Operator();
        operatorLife.setId(3L);
        operatorLife.setName("Vodafone");

        // Subscribers
        Subscriber subscriber1 = new Subscriber();
        subscriber1.setId(1L);
        subscriber1.setFirstName("Иван");
        subscriber1.setLastName("Васильев");
        subscriber1.setGender(Gender.MALE);
        subscriber1.setAge(23);
        subscriber1.setPhoneNumber("380630025465");
        subscriber1.setOperator(operatorLife);

        Subscriber subscriber2 = new Subscriber();
        subscriber1.setId(2L);
        subscriber1.setFirstName("Катя");
        subscriber1.setLastName("Петрова");
        subscriber1.setGender(Gender.FEMALE);
        subscriber1.setAge(34);
        subscriber1.setPhoneNumber("380670058694");
        subscriber1.setOperator(operatorKievstar);

        List<Subscriber> subscribers = new ArrayList<>();

        //
    }
}
