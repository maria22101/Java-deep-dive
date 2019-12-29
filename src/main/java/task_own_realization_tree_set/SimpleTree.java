package task_own_realization_tree_set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is HashSet implementation
 * Created by Bilous M. 28.12.2019
 */
public class SimpleTree<E> implements Tree<E> {
    private Leaf<E> root;
    private List<E> list;
    private int size = 0;

    public SimpleTree() {
        list = new LinkedList<>();
        root = new Leaf<>(null);
    }

    @Override
    public boolean add(E e) {
        if (size == 0) {
            return initializeRootLeaf(e);
        }

        Leaf<E> newLeaf = new Leaf<>(e);
        Leaf<E> lastLeaf = findLeafForAdding(root, newLeaf);

        if (lastLeaf == null) {
            return false;
        }

        size++;
        newLeaf.parent = lastLeaf;

        if (lastLeaf.compareTo(newLeaf) < 0) {
            lastLeaf.right = newLeaf;
            return true;
        } else {
            lastLeaf.left = newLeaf;
            return true;
        }
    }

    private boolean initializeRootLeaf(final E e) {
        root.element = e;
        size++;
        return true;
    }

    // finding the last leaf of the tree where adding a newLeaf is possible
    private Leaf<E> findLeafForAdding(
            Leaf<E> oldLeaf,
            Leaf<E> newLeaf) {

        int compare = oldLeaf.compareTo(newLeaf);

        if (compare < 0 && oldLeaf.right != null) {
            return findLeafForAdding(oldLeaf.right, newLeaf);
        }

        if (compare > 0 && oldLeaf.left != null) {
            return findLeafForAdding(oldLeaf.left, newLeaf);
        }

        if (compare == 0) {
            return null;
        }

        return oldLeaf;
    }

    @Override
    public List<E> getAllLeafValues() {
        for (E e : this) {
            list.add(e);
        }
        return list;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Leaf<E> find(E e) {
        Leaf<E> searchingLeaf = new Leaf<>(e);
        return search(root, searchingLeaf);
    }

    private Leaf<E> search(
            Leaf<E> currentLeaf,
            Leaf<E> searchingLeaf) {
        int compare = currentLeaf.compareTo(searchingLeaf);

        if (compare < 0 && currentLeaf.right != null) {
            return search(currentLeaf.right, searchingLeaf);
        }

        if (compare > 0 && currentLeaf.left != null) {
            return search(currentLeaf.left, searchingLeaf);
        }

        if (compare == 0) {
            return searchingLeaf;
        }

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 0;
            Iterator<Leaf<E>> iterator = new TreeIterator<>(root);

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public E next() {
                count++;
                return iterator.next().element;
            }
        };
    }

    private class TreeIterator<E> implements Iterator<Leaf<E>> {
        private Leaf<E> next;

        private TreeIterator(Leaf<E> root) {
            next = root;
            goToLeftMost();
        }

        private void goToLeftMost() {
            while (next.left != null) {
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            return next != null && next.element != null;
        }

        @Override
        public Leaf<E> next() {
            Leaf<E> r = next;

            if (next.right != null) {
                return goRight(r);
            }

            return goUp(r);
        }

        private Leaf<E> goRight(Leaf<E> r) {
            next = next.right;
            while (next.left != null) {
                next = next.left;
            }
            return r;
        }

        private Leaf<E> goUp(Leaf<E> r) {
            while (true) {
                if (next.parent == null) {
                    next = null;
                    return r;
                }
                if (next.parent.left == next) {
                    next = next.parent;
                    return r;
                }

                next = next.parent;
            }
        }
    }

    // This class represents a tree element that contains:
    // 1. parent element;
    // 2. links to right and left "leaves";
    // 3. "value" - here it is an "element" field).
    class Leaf<E> implements Comparable<E> {
        private Leaf<E> parent;
        private Leaf<E> right;
        private Leaf<E> left;
        private E element;

        public Leaf(E element) {
            this.element = element;
        }

        @Override
        public int compareTo(Object ob) {
            Leaf<E> node = (Leaf<E>) ob;
            return this.hashCode() - node.hashCode();
        }

        @Override
        public int hashCode() {
            return 31 * 17 + element.hashCode();
        }
    }
}
