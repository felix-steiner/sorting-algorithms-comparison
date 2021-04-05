package com.sac.sac.algorithms;

public class Selectionsort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            int temp = numbers[minimumIndex];
            numbers[minimumIndex] = numbers[i];
            numbers[i] = temp;
        }
        return numbers;
    }
}
