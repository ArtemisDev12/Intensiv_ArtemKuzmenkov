package org.ArtemKuzmenkov.grokAlg;

import java.util.Comparator;

public final class binarySearchAlg {
    public static void main(String[] args) {
        Integer[] a = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(a, 6, Comparator.naturalOrder()));
    }
    public static <T> int binarySearch(T[] a, T key, Comparator<T> c) {
        int start = 0, end = a.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (c.compare(a[mid], key) > 0) {
                end = mid - 1;
            }
            else if (c.compare(a[mid], key) < 0) {
                start = mid + 1;
            }
            else return mid;
        }
        return -1;
    }
}
