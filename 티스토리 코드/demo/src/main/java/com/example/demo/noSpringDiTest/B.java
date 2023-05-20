package com.example.demo.noSpringDiTest;

import org.springframework.stereotype.Component;

public class B implements Alphabet {
    @Override
    public void className() {
        System.out.println("B");
    }
}
