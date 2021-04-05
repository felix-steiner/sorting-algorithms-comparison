package com.sac.sac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberGeneratorTest {
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void generateNumbersWithEmptyValues() {
        int[] numbers = numberGenerator.generateNumbers(0, 0, 0);
        assertEquals(0, numbers.length);
    }

    @Test
    void generateNumbersOnlyWithZeros() {
        int[] numbers = numberGenerator.generateNumbers(0, 0, 10);
        assertEquals(10, numbers.length);
        assertEquals(0, min(numbers));
        assertEquals(0, max(numbers));
    }

    @Test
    void generateNumbers() {
        int[] numbers = numberGenerator.generateNumbers(-10, 10, 10);
        assertEquals(10, numbers.length);
        assertTrue(min(numbers) >= -10);
        assertTrue(max(numbers) <= 10);
    }

    private int max(int[] numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
        }
        return max;
    }

    private int min(int[] numbers) {
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
        }
        return min;
    }
}