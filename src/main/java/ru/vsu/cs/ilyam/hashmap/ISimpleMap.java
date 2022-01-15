package ru.vsu.cs.ilyam.hashmap;

import java.util.Set;

public interface ISimpleMap<K, V> {

    public V put(K key, V value);

    public V get(K key);

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public boolean isEmpty();

    public int size();

    public Set<Entry<K, V>> entrySet();

    public Set<K> keySet();

    public Set<V> values();

    public void remove(K key);

    public void clear();

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return " {" +
                    "key = " + key +
                    ", value = " + value +
                    "} ";
        }
    }
}
