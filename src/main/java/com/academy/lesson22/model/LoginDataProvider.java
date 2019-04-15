package com.academy.lesson22.model;

import java.util.ArrayList;
import java.util.List;

public class LoginDataProvider {
    public static List<LoginData> provide() {
        List<LoginData> loginData = new ArrayList<>();

        loginData.add(new LoginData("dimabologov@gmail.com", "456456Qwerty", "Invalid password."));
        loginData.add(new LoginData("123", "456456Qwerty", "Invalid email address."));
        loginData.add(new LoginData("", "123", "An email address required."));

        return loginData;
    }
}
