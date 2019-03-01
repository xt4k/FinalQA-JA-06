package com.academy.lesson06.tests;

import com.academy.lesson06.model.Abonent;

public class AbonentTestsDemo2 {
    public static void main(String[] args) throws ParseAbonentException {
        String abonentRawString = "  heLen iVanova 35 f 0501234567";
        // Parse abonent
        // Парсим абонента и результат записываем в поля класса
        Abonent abonent = new Abonent();
        abonent.setFirstName(AbonentParser.parseFirstName(abonentRawString));
        abonent.setLastName(AbonentParser.parseLastName(abonentRawString));
        abonent.setAge(AbonentParser.parseAge(abonentRawString));
        abonent.setGender(AbonentParser.parseGender(abonentRawString));
        abonent.setPhoneNumber(AbonentParser.parsePhoneNumber(abonentRawString));

        // LOG
        // Выводим данные абонента (теперь в одну строку)
        System.out.println("Abonent: " + abonent);

        // Test
        // Теперь проверка в одну строку
        Abonent expectedAbonent = new Abonent("Helen", "Ivanova", 35, 'f', "0501234567");
        assert abonent.equals(expectedAbonent);
    }
}
