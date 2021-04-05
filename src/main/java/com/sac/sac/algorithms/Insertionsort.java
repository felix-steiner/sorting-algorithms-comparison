package com.sac.sac.algorithms;

public class Insertionsort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] numbers) {
        int temp;
        for (int i = 1; i < numbers.length; i++) {
            temp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > temp) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = temp;
        }
        return numbers;
    }
}
