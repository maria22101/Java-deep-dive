package task_code_from_video_collections;

import java.util.Iterator;

/**
 * This class is realization of ArrayList - on base of an array
 * Created by Bilous M. 18.12.2019
 */
public class MyArrayList<E> implements Simple<E> {

    public static void main(String[] args) {
        Simple<String> strings = new MyArrayList<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");
        strings.forEach(System.out::println);
    }

    private E[] values;

    public MyArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int elemNumberAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, elemNumberAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}
