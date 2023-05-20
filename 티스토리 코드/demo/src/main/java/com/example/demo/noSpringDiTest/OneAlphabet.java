package com.example.demo.noSpringDiTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OneAlphabet {
    private Alphabet a;

    @Autowired
    public OneAlphabet(Alphabet a) {
        this.a = a;
    }
}
