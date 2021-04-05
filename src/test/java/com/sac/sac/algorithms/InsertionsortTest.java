package com.sac.sac.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionsortTest {
    Insertionsort insertionsort;

    @BeforeEach
    void setUp() {
        insertionsort = new Insertionsort();
    }

    @Test
    void sortNull() {
        assertThrows(NullPointerException.class, () -> insertionsort.sort(null));
    }

    @Test
    void sortEmpty() {
        int[] numbers = {};
        int[] sorted = insertionsort.sort(numbers);
        assertArrayEquals(new int[]{}, sorted);
        assertEquals(0, sorted.length);
    }

    @Test
    void sort() {
        int[] numbers = new int[]{3, 7, 3, 2, 9};
        int[] sorted = insertionsort.sort(numbers);
        assertArrayEquals(new int[]{2, 3, 3, 7, 9}, sorted);
        assertEquals(5, sorted.length);
    }
}