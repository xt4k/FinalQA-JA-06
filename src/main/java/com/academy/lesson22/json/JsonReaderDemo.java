package com.academy.lesson22.json;

import com.mysql.cj.xdevapi.JsonArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReaderDemo {
    public static void main(String[] args) {
        // Путь для json файла - 'user.dir' - корень проекта
        String path = System.getProperty("user.dir") + "/test-data/login.json";

        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader(path)) {
            Object jsonObj = parser.parse(reader);
            JSONArray json = (JSONArray) jsonObj;
            System.out.println(json);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
