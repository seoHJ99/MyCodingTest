package com.example.demo.noSpringDiTest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Main
public class A implements Alphabet {

    @Override
    public void className() {
        System.out.println("A");
    }
}
