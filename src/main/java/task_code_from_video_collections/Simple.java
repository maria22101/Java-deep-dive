package task_code_from_video_collections;

public interface Simple<E> extends Iterable{
    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index, E e);
}
