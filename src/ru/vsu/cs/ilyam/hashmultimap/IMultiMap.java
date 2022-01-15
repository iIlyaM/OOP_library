package ru.vsu.cs.ilyam.hashmultimap;

import ru.vsu.cs.ilyam.hashmap.ISimpleMap;

import java.util.List;
import java.util.Set;

public interface IMultiMap<K, V> {

    public int size();

    public boolean isEmpty();

    public void put(K key, V value);

    public Iterable<V> get(K key);

    public boolean remove(K key, V value);

    public Iterable<V> removeAll(K key);

    public void clear();

    public Iterable<ISimpleMap.Entry<K, V>> entries();

    public Set<K> keySet();

    public List<V> values();
}
