package com.academy.lesson22.xml;

import com.academy.lesson22.model.LoginData;
import com.academy.lesson22.model.LoginDataProvider;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class XmlWriterDemo {
    public static void main(String[] args) {
        // Путь для xml файла - 'user.dir' - корень проекта
        String path = System.getProperty("user.dir") + "/test-data/login.xml";

        // Получаем данные для json файла
        List<LoginData> loginDataList = LoginDataProvider.provide();

        XStream xStream = new XStream();
        xStream.processAnnotations(LoginData.class);
        String xml = xStream.toXML(loginDataList);
        System.out.println(xml);

        try (Writer writer = new FileWriter(new File(path))) {
            writer.write(xml);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
