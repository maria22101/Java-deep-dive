package task_write_collection.collection_with_no_elements_deletion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class is implementation of a data structure based on an ArrayList
 * that allows elements adding and forbids their deletion.
 * Created by Bilous M. 29.12.2019
 */
public class NoElementsDeletionBox<E> implements DeletionForbiddenDataStruct<E> {
    ArrayList<E> storage;

    public NoElementsDeletionBox() {
        storage = new ArrayList<>();
    }

    @Override
    public E set(int index, E element) {
        storage.add(index, element);
        return element;
    }

    @Override
    public boolean add(E e) {
        storage.add(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        storage.add(index, element);
    }

    private void deleteRejectionProcessing() {
        try {
            throw new DeletionForbiddenException();
        }catch (DeletionForbiddenException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public E remove(int index) {
        deleteRejectionProcessing();
        return null;
    }

    @Override
    public boolean remove(Object o) {
        deleteRejectionProcessing();
        return false;
    }

    @Override
    public void clear() {
        deleteRejectionProcessing();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        deleteRejectionProcessing();
        return false;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                E result = storage.get(index);
                index++;
                return result;
            }
        };
    }
}
