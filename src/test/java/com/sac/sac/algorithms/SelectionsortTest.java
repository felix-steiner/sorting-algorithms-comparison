package com.sac.sac.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionsortTest {
    Selectionsort selectionsort;

    @BeforeEach
    void setUp() {
        selectionsort = new Selectionsort();
    }

    @Test
    void sortNull() {
        assertThrows(NullPointerException.class, () -> selectionsort.sort(null));
    }

    @Test
    void sortEmpty() {
        int[] numbers = {};
        int[] sorted = selectionsort.sort(numbers);
        assertArrayEquals(new int[]{}, sorted);
        assertEquals(0, sorted.length);
    }

    @Test
    void sort() {
        int[] numbers = new int[]{3, 7, 3, 2, 9};
        int[] sorted = selectionsort.sort(numbers);
        assertArrayEquals(new int[]{2, 3, 3, 7, 9}, sorted);
        assertEquals(5, sorted.length);
    }
}