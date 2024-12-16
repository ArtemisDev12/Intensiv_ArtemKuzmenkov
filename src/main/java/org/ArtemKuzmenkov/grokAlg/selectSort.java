package org.ArtemKuzmenkov.grokAlg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public final class selectSort {
    public static <E> void sort(E[] array, Comparator<E> comparator) {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j < array.length; j++)
                if (comparator.compare(array[i], array[j]) > 0) {
                    E temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
    }

    public static void main(String[] args) {
        Integer[] array = { 10, 5, 6, 4, 5, 5, 7, 100, -1, -5, 0 };
        sort(array, Comparator.naturalOrder());
        Arrays.stream(array).forEach(System.out::println);

    }
}

