package task_own_realization_collections;

import java.util.Iterator;
import java.util.Objects;

/**
 * This class is HashSet implementation using an ArrayList
 * Created by Bilous M. 20.12.2019
 */
public class MyHashSet<E> implements SimpleHashSet<E> {
    private Element[] elements;
    private int length;

    public MyHashSet(int length) {
        this.length = length;
        elements = (Element[]) new Object[length];
    }

    class Element {
        //        int hash;
        String value;
        Element next;

        public Element(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Element element = (Element) o;
            return Objects.equals(value, element.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    @Override
    public void add(E e) {
        Element[] tmp = elements;
    }

    @Override
    public boolean delete(E e) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ArrIterator(elements);
    }
}
