package task_own_realization_hash_map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class is a HashMap realization on an array of Node(s).
 * Node - is the corresponding inner class.
 * Created by Bilous M. 24.12.2019
 */
public class ReferenceBook<K, V> implements Book<K, V> {

    public static void main(String[] args) {
        ReferenceBook<String, String> strings = new ReferenceBook<>();
        strings.insert("1", "a");
        strings.insert("2", "b");
        strings.insert("3", "c");
        strings.insert("4", "d");
        strings.insert("5", "e");
        strings.insert("6", "f");
        strings.insert("7", "g");
        strings.insert("8", "h");
        strings.insert("9", "j");
        strings.insert("10", "k");
        strings.insert("11", "l");
        strings.insert("12", "m");
        strings.insert("13", "n");
        strings.insert("14", "o");
        strings.insert("15", "p");
        strings.insert("16", "q");
        strings.insert("17", "hello");
        strings.forEach(System.out::println);
    }

    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;

    public ReferenceBook() {
        hashTable = new Node[16];
        this.threshold = hashTable.length * 0.75f;
    }

    private int hash(Node<K, V> node) {
        return node.hashCode() % hashTable.length;
    }

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    @Override
    public boolean insert(final K key, final V value) {
        if (size + 1 >= threshold) {
            arrayDoubling();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);

        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes(); // collision is processed here onward
        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) ||
                    collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(final K key) {
        int index = hash(key);

        if (hashTable[index] == null) {
            return false;
        }

        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index] = null;
            return true;
        }

        List<Node<K, V>> nodeList = hashTable[index].getNodes(); // collision occurred earlier
        for (Node<K, V> node : nodeList) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);
                return true;
            }
        }

        return false;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (index < hashTable.length &&
                hashTable[index] != null) {

            if (hashTable[index].getNodes().size() == 1) {
                return hashTable[index].getNodes().get(0).getValue();
            }

            List<Node<K, V>> nodeList = hashTable[index].getNodes();
            for (Node<K, V> node : nodeList) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int counterArray = 0;
            int valuesCounter = 0;
            Iterator<Node<K, V>> subIterator = null; // reference to the "nodes" field (List) of the Node

            @Override
            public boolean hasNext() {
                if (valuesCounter == size) {
                    return false;
                }

                if (isMoveToNextCellPossible()) {
                    subIterator = hashTable[counterArray].getNodes().iterator();
                    counterArray++;
                } else {
                    return false;
                }

                return subIterator.hasNext();
            }

            private boolean isMoveToNextCellPossible() {
                while (counterArray < hashTable.length && hashTable[counterArray] == null) {
                    counterArray++;
                }
                return counterArray < hashTable.length && hashTable[counterArray] != null;
            }

            @Override
            public V next() {
                valuesCounter++;
                return subIterator.next().getValue();
            }
        };
    }

    private void arrayDoubling() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        threshold = hashTable.length * 0.75f;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    // method for re-writing the node's value in the nodes List
    // in case of the equal keys
    private boolean keyExistButValueNew(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final V value) {

        if (newNode.getKey().equals(nodeFromList.getKey()) &&
                !newNode.getValue().equals(nodeFromList.getValue())) {

            nodeFromList.setValue(value);
            return true;
        }

        return false;
    }

    // method for adding the node to the nodes List in case of the collision:
    // equal hashCode but different key and value
    private boolean collisionProcessing(
            final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final List<Node<K, V>> nodes) {

        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)) {

            nodes.add(newNode);
            size++;
            return true;
        }

        return false;
    }

    /**
     * class Node is for creating a Node instance:
     * empty Node - where the List nodes length = zero
     * not empty Node without collision - a node where the List nodes length = 1
     * not empty Node with collision - a node where the List nodes length > 1
     * Fields "key" and "value" are always null on the first level,
     * storage for a key-value pair assumed to be in the List nodes - on the second level.
     */
    public class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        public List<Node<K, V>> getNodes() {
            return nodes;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<K, V> node = (Node<K, V>) o;
            return Objects.equals(key, node.key) &&
                    Objects.equals(value, node.value) ||
                    Objects.equals(hash, node.hashCode());
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }
    }

}
