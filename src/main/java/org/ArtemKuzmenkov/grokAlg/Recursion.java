package org.ArtemKuzmenkov.grokAlg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Recursion {
    public static int sum(int... numbers) {
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        return numbers[0] + sum(Arrays.copyOfRange(numbers, 1, numbers.length));
    }

    public static void main(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(arrayElCount(new Integer[] {1, 2, 3, 4, 5}));
        System.out.println(max(1, 0, -1, 100, 11, 99));
        List<Integer> list = new ArrayList<>();
        list.add(100); list.add(2); list.add(354); list.add(45); list.add(35);
        System.out.println(quickSort(list));
    }

    public static <E> int arrayElCount(E[] array) {
        if (array.length == 0) return 0;
        return 1 + arrayElCount(Arrays.copyOfRange(array, 1, array.length));
    }

    public static int max(int... numbers) {
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        int max = max(Arrays.copyOfRange(numbers, 1, numbers.length));
        return Math.max(numbers[0], max);
    }

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) return list;
        Integer pivot = list.getFirst();
        List<Integer> left =  list.stream().skip(1).filter(el -> el < pivot).toList();
        List<Integer> right = list.stream().skip(1).filter(el -> el > pivot).toList();
        List<Integer> result = new ArrayList<>
                        (quickSort(left)); result.add(pivot); result.addAll(quickSort(right));
        return result;
    }
}
