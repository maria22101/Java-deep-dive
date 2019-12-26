package task_own_realization_hash_set;

/**
 * This interface declares methods to be implemented by a class
 * constructing a HashSet
 * Created by Bilous M. 20.12.2019
 */
public interface SimpleHashSet<E> extends Iterable<E>{
    boolean insert(E e);
    boolean delete(E e);
    boolean contains(Object o);
    void clear();
    int size();
    boolean isEmpty();
}
