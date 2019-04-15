package com.academy.lesson22.xml;

import com.academy.lesson22.model.LoginData;
import com.thoughtworks.xstream.XStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class XmlReaderDemo {
    public static void main(String[] args) {
        // Путь для xml файла - 'user.dir' - корень проекта
        String path = System.getProperty("user.dir") + "/test-data/login.xml";
        XStream xStream = new XStream();
        initXstreamSecurity(xStream);
        String xml = readFileAsString(path);
        xStream.processAnnotations(LoginData.class);
        List<LoginData> data = (List<LoginData>)xStream.fromXML(xml);
        System.out.println(data);
    }

    // Читаем из файла в строку как есть
    private static String readFileAsString(String path) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File(path)))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
        }
        return null;
    }

    // prevent security warning
    private static void initXstreamSecurity(XStream xStream) {
        Class<?>[] classes = new Class[] { LoginData.class };
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);
    }
}
