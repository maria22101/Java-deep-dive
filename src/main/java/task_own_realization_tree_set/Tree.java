package task_own_realization_tree_set;

import java.util.List;

/**
 * This interface declares methods to be implemented by a class
 * that constructs a TreeSet
 * Created by Bilous M. 29.12.2019
 */
public interface Tree<E> extends Iterable<E> {
    boolean add(E e);
    List<E> getAllLeafValues();
    int size();
    SimpleTree<E>.Leaf<E> find(E e);
}
