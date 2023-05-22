package com.example.demo.noSpringDiTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EveryAlphabet {
    List<Alphabet> alphabetList;
    Map<String, Alphabet> alphabetMap;

    @Autowired
    public EveryAlphabet(List<Alphabet> alphabetList, Map<String, Alphabet> alphabetMap) {
        this.alphabetList = alphabetList;
        this.alphabetMap = alphabetMap;

        System.out.println("list = " + alphabetList);
        System.out.println("map = " + alphabetMap);
    }
}
