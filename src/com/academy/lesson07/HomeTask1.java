package com.academy.lesson07;

import com.academy.lesson07.model.Button;
import com.academy.lesson07.model.Component;
import com.academy.lesson07.model.Label;
import com.academy.lesson07.model.VisualComponent;

public class HomeTask1 {
    public static void main(String[] args) {
        VisualComponent anonymous = new VisualComponent() {
            @Override
            public void draw() {
                System.out.println("anonymous variable");
            }
        };

        VisualComponent anonymousLambda = () -> System.out.println("anonymous lambda");
        VisualComponent[] vComponents = new VisualComponent[] {
                new Button(),
                new Label(),
                new Component(),
                new VisualComponent() {
                    @Override
                    public void draw() {
                        System.out.println("Anonymous component");
                    }
                },
                () -> System.out.println("Lambda component"),
                anonymous,
                anonymous,
                anonymousLambda,
                HomeTask1::printDefaultComponent
        };

        for (VisualComponent element : vComponents)
            element.draw();
    }

    private static void printDefaultComponent() {
        System.out.println("Default component from main");
    }
}
