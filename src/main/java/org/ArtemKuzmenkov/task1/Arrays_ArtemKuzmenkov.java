package org.ArtemKuzmenkov.task1;

import java.util.Comparator;

public abstract class Arrays_ArtemKuzmenkov {
    /**
     * Реализует алгоритм быстрой сортировки для массива элементов с использованием компаратора.
     *
     * @param <E> тип элементов массива
     * @param array массив, который нужно отсортировать
     * @param left индекс левой границы текущей части массива
     * @param right индекс правой границы текущей части массива
     * @param comparator компаратор для сравнения элементов массива
     *
     * @throws NullPointerException если массив или компаратор равны null
     */
    public static  <E> void  quickSort(E[] array, int left, int right, Comparator<E> comparator) {
        if (left > right) return;
        E supEl = array[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (comparator.compare(array[i], supEl) < 0) i++;
            while (comparator.compare(array[j], supEl) > 0) j--;
            if (i <= j) {
                swap(array, i, j);
                i++; j--;
            }
        }
        quickSort(array, left, j, comparator);
        quickSort(array, i, right, comparator);
    }
    /**
     * Меняет местами два элемента в массиве по указанным индексам.
     *
     * @param <E> тип элементов массива
     * @param array массив, в котором нужно поменять элементы
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     *
     * @throws ArrayIndexOutOfBoundsException если i или j выходят за пределы массива
     * @throws NullPointerException если массив равен null
     */
    private static  <E> void swap(E[] array, int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
