package com.example.demo.noSpringDiTest;

import org.springframework.stereotype.Component;

@Component
public class A implements Alphabet {

    @Override
    public void className() {
        System.out.println("A");
    }
}
