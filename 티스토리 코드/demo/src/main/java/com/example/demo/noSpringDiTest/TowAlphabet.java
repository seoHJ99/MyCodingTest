package com.example.demo.noSpringDiTest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

//@RequiredArgsConstructor
@Component
public class TowAlphabet {
//    @Qualifier("BeanA")
    private final Alphabet first;
//    @Qualifier("BeanB")
    private final Alphabet second;

    @Autowired
    public TowAlphabet(@Main Alphabet first, @Qualifier("BeanB") Alphabet second) {
        this.first = first;
        this.second = second;
    }

//    @Autowired
//    public void setFirst(Alphabet a){
//        first = a;
//    }
//
//    @Autowired
//    public void setSecond(Alphabet b){
//        second = b;
//    }
//
//    @Autowired
//    public void injection(Alphabet a, Alphabet b){
//        first = a;
//        second = b;
//    }
}
