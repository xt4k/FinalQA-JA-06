package com.academy.lesson07.model;

public class Component implements VisualComponent{

    @Override
    public void draw() {
        System.out.println("Component");
    }
}
