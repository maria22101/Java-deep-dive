package task_concurrent_modif_exception_example;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/**
 * This class demonstrates:
 * - situation when ConcurrentModificationException is generated;
 * - options to avoid facing ConcurrentModificationException.
 * Created by Bilous M. 04.01.2020.
 */
public class ConcurrentModifException {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        // It is unsafe to remove elements while iterating. ConcurrentModificationExceptions is generated:
        try {
            for (Integer integer : integers) {
                integers.remove(1);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Elements removal from the collection that is being iterated is forbidden");
        }


        // Option_1 for safe elements removal - the iterator to be used:
        Iterator<Integer> iter = integers.iterator();
        while (iter.hasNext()) {
            Integer integer = iter.next();
            if (integer == 2) {
                iter.remove();
            }
        }
        System.out.println(integers); // "2" is removed from the list

        // Option_2 for safe elements removal - removeIf method to be used:
        integers.removeIf(integer -> integer == 3);
        System.out.println(integers); // "3" is removed from the list
    }
}
