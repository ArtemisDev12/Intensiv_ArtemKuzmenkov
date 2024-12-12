package org.ArtemKuzmenkov.task1;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayList_ArtemKuzmenkov<E> implements IntensiveList<E> {

    /**
     * Используется для хранения элементов коллекции.
     */
    private Object[] data;

    /**
     * Хранит число элементов в коллекции.
     * Никак не связан с длиной массива для хранения элементов коллекции.
     */
    private int size;

    /**
     * Стандартная вместимость коллекции.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Хранит состояние коллекции - отсортирована она или нет.
     */
    private boolean isSorted;

    public ArrayList_ArtemKuzmenkov() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList_ArtemKuzmenkov(int capacity) {
        data = new Object[capacity];
    }

    /**
     * Функция вычисления стандартного размера расширения коллекции.
     * @return Возвращает расширенный размер самого массива данных коллекции
     */
    private int extendCapacity() {
        return (int) (data.length * 1.5 + 1);
    }

    /**
     * Проверяет, корректна ли заданная позиция в коллекции.
     * @param index представляет собой проверяемую позицию.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Расширяет массив данных коллекции
     */
    private void extendData() {
        if (data.length > 0) data = Arrays.copyOf(data, extendCapacity());
        else data = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Проверяет, нужно ли расширение коллекции в данный момент и если да, то расширяет ее.
     */
    private void extendIfNeeded() {
        if (data.length == size) extendData();
    }

    /**
     * Внутренняя функция для возвращения элемента с заданной позиции,
     * позволяет избежать привидение типа в дальнейшем.
     * @param index представляет позицию элемента.
     * @return возвращает элемент в заданной позиции.
     */
    private E elementData(int index) {
        //noinspection unchecked
        return (E) data[index];
    }
    /**
     * @return возвращает размер коллекции (количество ее элементов).
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Добавляет элемент в конец коллекции.
     * @param element представляет элемент, добавляемый в конец коллекции.
     */
    @Override
    public void add(E element) {
        extendIfNeeded();
        data[size++] = element;
        isSorted = false;
    }

    /**
     * Добавляет элемент коллекции в выбранную позицию.
     * @param index представляет собой позицию, куда будет вставлен элемент.
     * @param element представляет элемент, добавляемый в позицию index.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона (index < 0 || index >= size()).
     */
    @Override
    public void add(int index, E element) {
        checkIndex(index);
        extendIfNeeded();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
        isSorted = false;
    }

    /**
     * Получение элемента коллекции по заданной позиции.
     * @param index представляет собой позицию, откуда будет получен элемент коллекции.
     * @return возвращает элемент коллекции с заданной позиции.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона (index < 0 || index >= size()).
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return elementData(index);
    }

    /**
     * Функция заменяет один элемент на другой, возвращая первый.
     * @param index представляет собой позицию заменяемого элемента в коллекции.
     * @param element представляет собой элемент, который заменит собой элемент в позиции index.
     * @return возвращает элемент, который был заменен.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона (index < 0 || index >= size()).
     */
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E old = elementData(index);
        data[index] = element;
        isSorted = false;
        return old;
    }

    /**
     * Удаление элемента в заданной позиции.
     * @param index представляет собой позицию элемента в коллекции.
     * @return возвращает удаляемый элемент.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона (index < 0 || index >= size()).
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        E old = elementData(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return old;
    }

    /**
     * Очищает коллекцию и устанавливает стандартный размер равный 10.
     */
    @Override
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Сортирует коллекцию по правилу, указанному в Comparator.
     * @param comparator представляет собой объект Comparator, реализованный для нужной сортировки.
     */
    @Override
    public void quickSort(Comparator<E> comparator) {
        if (!isSorted) {
            //noinspection unchecked
            Arrays_ArtemKuzmenkov.quickSort((E[]) data, 0, size - 1, comparator);
            isSorted = true;
        }
    }



    /**
     * @return возвращает состояние коллекции, отсортирована она или нет.
     */
    @Override
    public boolean isSorted() {
        return isSorted;
    }

    /**
     * Обрезает коллекцию до указанного размера.
     * @param size представляет собой размер обрезания коллекции.
     * @throws IllegalArgumentException размер некорректен size < 0 или size > размера коллекции.
     */
    @Override
    public void split(int size) {
        if (size < this.size && size >= 0) {
            this.size = size;
            data = Arrays.copyOf(data, size);
        }
        else
            throw new IllegalArgumentException("Incorrect size");
    }
}
