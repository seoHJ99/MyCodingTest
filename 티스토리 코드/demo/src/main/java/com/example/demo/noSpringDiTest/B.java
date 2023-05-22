package com.example.demo.noSpringDiTest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
@Qualifier("BeanB")
public class B implements Alphabet {
    @Override
    public void className() {
        System.out.println("B");
    }
}
