package com.academy.lesson10;

import com.academy.lesson06.model.Abonent;
import com.academy.lesson06.tests.AbonentParser;
import com.academy.lesson06.tests.AbonentTestsDemo2;
import com.academy.lesson06.tests.ParseAbonentException;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        String[] abonentRawArray = {
                "  heLen iVanova 35 f 0501234567",
                "  Андрей Сидоров 26 m 0501234568",
                "  Peter Lvovich 37 m 0501234569",
        };

        String[] abonentRawArray2 = {
                "  Андрей Сидоров 26 m 0501234568",
                "  heLen iVanova 35 f 0501234567",
                "  Peter Lvovich 37 m 0501234569",
        };

        try {
            Abonent[] abonentArray = parseAbonents(abonentRawArray);
            Abonent[] abonentArray2 = parseAbonents(abonentRawArray2);
            List<Abonent> abonentList = new ArrayList<>();
            // 1 способ
            for (Abonent abonent : abonentArray) {
                abonentList.add(abonent);
            }
            System.out.println(abonentList);

            // 2 способ
            List<Abonent> abonentList2 = new ArrayList<>(Arrays.asList(abonentArray2));
            System.out.println(abonentList2);
            System.out.println(abonentList.equals(abonentList2));

            assert abonentList.equals(abonentList2);

            // через Set
            Set<Abonent> abonentSet = new HashSet<>(abonentList);
            Set<Abonent> abonentSet2 = new HashSet<>(abonentList2);
            System.out.println(abonentSet.equals(abonentSet2));


//            // 3 способ
//            List<Abonent> listTmp = new ArrayList<>(Arrays.asList(abonentArray2));
//            listTmp.add(new Abonent());

        } catch (ParseAbonentException e) {
            e.printStackTrace();
        }
    }

    private static Abonent[] parseAbonents(String[] abonentRawArray) throws ParseAbonentException {
        Abonent[] abonents = new Abonent[abonentRawArray.length];
        for (int i = 0; i < abonentRawArray.length; i++) {
//            String firstName = AbonentParser.parseFirstName(abonentRawArray[i]);
//            String lastName = "";
//            int age = 0;
//            char gender = 'f';
//            String phoneNumber = "";
            abonents[i] = AbonentParser.parseAbonent(abonentRawArray[i]);
        }
        return abonents;
    }
}
