package task_code_from_video_collections;

import java.util.Iterator;

/**
 * This class is LinkedList implementation
 * Created by Bilous M. 20.12.2019
 */
public class MyLinkedList<E> implements Linked<E>, Iterable<E>, DescendingIterator<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    /**
     * When initiating a class instance we will get the relevance
     * between the first and the last elements
     */
    public MyLinkedList() {
        lastNode = new Node<>(null, firstNode, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> previous = lastNode;
        previous.setCurr(e);
        lastNode = new Node(null, previous, null);
        previous.setNext(lastNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.setCurr(e);
        firstNode = new Node(null, null, next);
        firstNode.setNext(next);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> target = firstNode.getNext();
        for (int i = 0; i < counter; i++) {
            target = target.getNext();
        }
        return target.getCurr();
    }

    private Node<E> getNextNode(Node<E> currentNode) {
        return currentNode.getNext();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    private static class Node<E> {
        private E curr;
        private Node<E> next;
        private Node<E> prev;

        public Node(E curr, Node<E> prev, Node<E> next) {
            this.curr = curr;
            this.prev = prev;
            this.next = next;
        }

        public E getCurr() {
            return curr;
        }

        public void setCurr(E curr) {
            this.curr = curr;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
