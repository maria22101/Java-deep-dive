package task_code_from_video_collections;

/**
 * This interface declares methods to be implemented by a class
 * constructing a LinkedList
 * Created by Bilous M. 20.12.2019
 */
public interface Linked<E> {
    void addLast(E e);
    void addFirst(E e);
    int size();
    E getElementByIndex(int counter);
}
