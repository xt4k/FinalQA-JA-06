package com.academy.lesson13;

import com.academy.lesson11.Gender;
import com.academy.lesson11.Subscriber;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeTask {
    private static final int COUNT_SUBSCRIBERS = 200;
    private static final String MAN_FIRST_NAMES_PATH = "d:/teaching/telesens-academy/QA-JA-06/Tasks/Lesson 11/мужские имена.txt";
    private static final String WOMAN_FIRST_NAMES_PATH = "d:/teaching/telesens-academy/QA-JA-06/Tasks/Lesson 11/женские имена.txt";
    private static final String MAN_LAST_NAMES_PATH = "d:/teaching/telesens-academy/QA-JA-06/Tasks/Lesson 11/мужские фамилии.txt";
    private static final String WOMAN_LAST_NAMES_PATH = "d:/teaching/telesens-academy/QA-JA-06/Tasks/Lesson 11/женские фамилии.txt";

    private static List<String> manFirstNames = new ArrayList<>();
    private static List<String> womanFirstNames = new ArrayList<>();
    private static List<String> manLastNames = new ArrayList<>();
    private static List<String> womanLastNames = new ArrayList<>();

    public static void main(String[] args) {
        // Подготавливаем данные
        manFirstNames = prepareData(MAN_FIRST_NAMES_PATH);
        womanFirstNames = prepareData(WOMAN_FIRST_NAMES_PATH);
        manLastNames = prepareData(MAN_LAST_NAMES_PATH);
        womanLastNames = prepareData(WOMAN_LAST_NAMES_PATH);

        Random random = new Random();

        for (int n = 1; n <= COUNT_SUBSCRIBERS; n++) {
            Subscriber subscriber = generateNextSubscriber(random);
            insertSubscriberToDB(subscriber);
        }
    }

    private static List<String> prepareData(String path) {
        List<String> result = new ArrayList<>();
        try(BufferedReader bfr = new BufferedReader(new FileReader(path))) {
            String row;
            while ((row = bfr.readLine()) != null) {
                result.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // TODO
    private static void insertSubscriberToDB(Subscriber subscriber) {
        System.out.println(subscriber);
    }

    private static Subscriber generateNextSubscriber(Random random) {

        Subscriber subscriber = new Subscriber();
        // Наполняем
        String firstName;
        String lastName;
        int nextIndex;
        if (random.nextBoolean()) {
            // допустим мужчина
            nextIndex = random.nextInt(manFirstNames.size());
            firstName = manFirstNames.get(nextIndex);
            nextIndex = random.nextInt(manLastNames.size());
            lastName = manLastNames.get(nextIndex);
            subscriber.setGender(Gender.MALE);
        } else {
            // женщина
            nextIndex = random.nextInt(womanFirstNames.size());
            firstName = womanFirstNames.get(nextIndex);
            nextIndex = random.nextInt(womanLastNames.size());
            lastName = womanLastNames.get(nextIndex);
            subscriber.setGender(Gender.FEMALE);
        }
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        // ?? Гауссово
        subscriber.setAge(random.nextInt(86)+5);
        return subscriber;
    }


}
