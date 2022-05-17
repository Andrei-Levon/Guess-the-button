package com.example.demo;

public class Randomizer {
    Boolean[] answers = {false, false, false};

    Randomizer() {
    }

    public void random() {
        int a = (int) (Math.random() * answers.length);
        answers[a] = true;
    }

}
