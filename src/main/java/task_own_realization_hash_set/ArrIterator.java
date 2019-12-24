package task_own_realization_hash_set;

import java.util.Iterator;

public class ArrIterator<E> implements Iterator<E> {
    private int index = 0;
    E[] values;

    public ArrIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
