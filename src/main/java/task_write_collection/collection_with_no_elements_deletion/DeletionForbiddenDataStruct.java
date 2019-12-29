package task_write_collection.collection_with_no_elements_deletion;

import java.util.Collection;

/**
 * This interface declares methods to be implemented by a class
 * that allows elements adding and forbids their deletion.
 * Created by Bilous M. 29.12.2019
 */
public interface DeletionForbiddenDataStruct<E> extends Iterable<E> {
    E set(int index, E element);
    boolean add(E e);
    void add(int index, E element);

    E remove(int index);
    boolean remove(Object o);
    void clear();
    boolean removeAll(Collection<?> c);

    int size();
}
