package task_own_realization_hash_map;

public interface Book<K, V> extends Iterable<V> {
    boolean insert(K key, V value);
    boolean delete(K key);
    V get(K key);
    int size();
}
