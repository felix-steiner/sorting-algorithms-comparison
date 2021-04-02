package com.sac.sac;

public class NumberGenerator {
    public int[] generateNumbers(int min, int max, int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
        }
        return numbers;
    }
}
