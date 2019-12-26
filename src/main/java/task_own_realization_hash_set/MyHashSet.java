package task_own_realization_hash_set;

import java.util.*;

/**
 * This class is HashSet implementation using an array
 * Created by Bilous M. 20.12.2019
 */
public class MyHashSet<E> implements SimpleHashSet<E> {
    private Element<E>[] hashTable;
    private int size;
    private float threshold;

    public MyHashSet() {
        hashTable = new Element[16];
        threshold = hashTable.length * 0.75f;
    }

    private int hash(Element<E> element) {
        return element.hashCode() % hashTable.length;
    }

    private int hash(E value) {
        return (31 * 17 + value.hashCode()) % hashTable.length;
    }

    @Override
    public boolean insert(E value) {
        if (size + 1 >= threshold) {
            arrayDoubling();
        }

        Element<E> newElement = new Element<>(value);
        int index = hash(newElement);

        if (hashTable[index] == null) {
            return simpleAdd(index, newElement);
        }

        List<Element<E>> elementList = hashTable[index].getElementsList();
        for (Element<E> innerElement : elementList) {
            if (collisionProcessing(elementList, innerElement, newElement)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(E value) {
        int index = hash(value);

        if (hashTable[index] == null) {
            return false;
        }

        if (hashTable[index].getElementsList().size() == 1) {
            hashTable[index] = null;
            size--;
            return true;
        }

        List<Element<E>> elementList = hashTable[index].getElementsList();
        for (Element<E> innerElement : elementList) {
            if (value.equals(innerElement.getValue())) {
                elementList.remove(innerElement);
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        try {
            Element<E> elementToFind = new Element<>((E) o);

            for (Element<E> element : hashTable) {
                if (element != null && element.getElementsList().size() != 0) {
                    return element.getElementsList()
                            .stream()
                            .anyMatch(el -> el.getValue().equals(o));

                }
            }

        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    @Override
    public void clear() {

        for (Element<E> element : hashTable) {
            if (element != null && element.getElementsList().size() != 0) {
                element.getElementsList()
                        .stream()
                        .forEach(innerElem -> {
                            innerElem = null;
                            size--;
                        });

            }
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void arrayDoubling() {
        Element<E>[] oldHashTable = hashTable;
        hashTable = new Element[oldHashTable.length * 2];
        size = 0;
        threshold = hashTable.length * 0.75f;

        for (Element<E> elem : oldHashTable) {
            if (elem != null) {
                for (Element<E> innerElem : elem.getElementsList()) {
                    insert(innerElem.value);
                }
            }
        }
    }

    private boolean simpleAdd(int index, Element<E> newElement) {
        hashTable[index] = new Element<>(null);
        hashTable[index].getElementsList().add(newElement);
        size++;
        return true;
    }

    private boolean collisionProcessing(
            List<Element<E>> elementList,
            Element<E> innerElement,
            Element<E> newElement) {

        if (innerElement.hashCode() == newElement.hashCode() &&
                !Objects.equals(innerElement.value, newElement.value)) {
            elementList.add(newElement);
            size++;
            return true;
        }
        return false;
    }

    /**
     * class Element is for creating an Element instance - for storage in the MyHashSet:
     * empty Element - when the elementsList length = zero
     * not empty Element without collision - when the elementsList length = 1
     * not empty Element with collision - when the elementsList length > 1
     * Field "value" is always null on the first level,
     * storage for the value assumed to be in the elementsList - on the second level.
     */
    class Element<E> {
        private List<Element<E>> elementsList;
        private E value;

        public Element(E value) {
            this.value = value;
            elementsList = new LinkedList<>();
        }

        public List<Element<E>> getElementsList() {
            return elementsList;
        }

        public E getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Element)) return false;
            Element<E> element = (Element<E>) o;
            return Objects.equals(value, element.value);
        }

        @Override
        public int hashCode() {
            return 31 * 17 + value.hashCode();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int hashTableCounter = 0;
            int valuesCounter = 0;
            Iterator<Element<E>> subIterator = null; // reference to the "elementsList" field of the Element

            @Override
            public boolean hasNext() {
                if (valuesCounter == size) {
                    return false;
                }

                if (isMoveToNextHashTableElemPossible()) {
                    subIterator = hashTable[hashTableCounter]
                            .getElementsList()
                            .iterator();
                    hashTableCounter++;
                } else {
                    return false;
                }

                return subIterator.hasNext();
            }

            private boolean isMoveToNextHashTableElemPossible() {
                while (hashTableCounter < hashTable.length && hashTable[hashTableCounter] == null) {
                    hashTableCounter++;
                }
                return hashTableCounter < hashTable.length && hashTable[hashTableCounter] != null;
            }

            @Override
            public E next() {
                valuesCounter++;
                return subIterator.next().getValue();
            }
        };
    }

    public Element<E>[] getHashTable() {
        return hashTable;
    }
}
