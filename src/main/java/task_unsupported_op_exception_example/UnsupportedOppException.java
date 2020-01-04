package task_unsupported_op_exception_example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class demonstrates situations when UnsupportedOperationExceptions are generated:
 * 1. When adding or deleting elements from a List generated from Arrays.asList as such list
 * is unmodifiable and does not implement add() and remove() methods.
 * 2. When removing an element using Iterator for an unmodifiable list.
 * Created by Bilous M. 04.01.2020.
 */
public class UnsupportedOppException {

    public static void main(String[] args) {
        List<String> str = Arrays.asList("Rose", "Poppy", "Camille", "Sunflower");

        try {
            str.add("Geranium");
        }catch (UnsupportedOperationException e){
            System.out.println("operation add() not supported here");
        }

        try {
            str.remove("Poppy");
        }catch (UnsupportedOperationException e){
            System.out.println("operation remove() not supported here");
        }

        Iterator<String> it = str.iterator();
        try {
            while (it.hasNext()) {
                if(it.next().equals("Poppy")) {
                    it.remove();
                }
            }
        }catch (UnsupportedOperationException e){
            System.out.println("operation remove() with iterator not supported here");
        }
    }
}
