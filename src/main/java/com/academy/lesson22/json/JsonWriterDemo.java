package com.academy.lesson22.json;

import com.academy.lesson22.model.LoginData;
import com.academy.lesson22.model.LoginDataProvider;
import com.mysql.cj.xdevapi.JsonArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class JsonWriterDemo {

    public static void main(String[] args) {
        // Путь для json файла - 'user.dir' - корень проекта
        String path = System.getProperty("user.dir") + "/test-data/login.json";

        // Получаем данные для json файла
        List<LoginData> loginDataList = LoginDataProvider.provide();

        // Генерируем json файл
        JSONArray jsonArray = new JSONArray();
        for (LoginData loginData : loginDataList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("login", loginData.getLogin());
            jsonObject.put("password", loginData.getPassword()); // Cast
            jsonObject.put("msg", loginData.getMsg());

            jsonArray.add(jsonObject);
        }

        System.out.println(jsonArray.toJSONString());

        try (Writer writer = new FileWriter(
                new File(path))) {
            // Превращаем json объект в строку и сохраняем в файл
            writer.write(jsonArray.toJSONString());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
