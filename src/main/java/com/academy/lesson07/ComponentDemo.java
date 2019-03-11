package com.academy.lesson07;

import com.academy.lesson07.model.Button;
import com.academy.lesson07.model.Component;
import com.academy.lesson07.model.Label;

public class ComponentDemo {
    public static void main(String[] args) {
        String str = "HEllo"; // String str = new String("Hello");
        Component btn = new Button(); // А это уже полиморфизм
        btn.draw();
        // ***********
        System.out.println("***components***");
        Object[] components = new Object[] {
                new Label(),
                new Button(),
                new Button(),
                new Label(),
                "Hello",
                12
        };

        components[0] = new Button();

        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof Component) {
                Component element = (Component) components[i];
                element.draw();
            }
        }
    }
}
