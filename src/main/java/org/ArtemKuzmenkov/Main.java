package org.ArtemKuzmenkov;

import org.ArtemKuzmenkov.task1.ArrayList_ArtemKuzmenkov;
import org.ArtemKuzmenkov.task1.IntensiveList;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        IntensiveList<Integer> test = new ArrayList_ArtemKuzmenkov<>(0);
        test.add(11);
        test.add(1);
        test.add(232);
        test.add(10);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
        test.quickSort(Comparator.naturalOrder());
        System.out.println();
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
    }
}