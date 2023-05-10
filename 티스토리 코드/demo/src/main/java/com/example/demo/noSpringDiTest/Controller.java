package com.example.demo.noSpringDiTest;


public class Controller {

    private final Alphabet alphabet;

    public Controller(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    public void mainClassName (){
        alphabet.className();
    }
}
