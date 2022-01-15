package ru.vsu.cs.ilyam.hashmultimap;

import ru.vsu.cs.ilyam.hashmap.ISimpleMap;
import ru.vsu.cs.ilyam.hashmap.SimpleHashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashMultiMap<K, V> implements IMultiMap<K, V> {
    private ISimpleMap<K, List<V>> map = new SimpleHashMap<>();
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        List<V> values = map.get(key);
        if(values == null) {
            values = new ArrayList<>();
            map.put(key, values);
        }
        values.add(value);
        size++;
    }

    @Override
    public Iterable<V> get(K key) {
        List<V> values = map.get(key);
        if(values != null) {
            return values;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean remove(K key, V value) {
        boolean wasRemoved = false;
        List<V> temp = map.get(key);
        if(temp != null) {
            wasRemoved = temp.remove(value);
            if(wasRemoved) {
                size--;
                if(temp.isEmpty()) {
                    map.remove(key);
                }
            }
        }
        return wasRemoved;
    }

    @Override
    public Iterable<V> removeAll(K key) {
        List<V> temp = map.get(key);
        if(temp != null) {
            size -= temp.size();
            map.remove(key);
        } else {
            temp = new ArrayList<>();
        }
        return temp;
    }

    @Override
    public void clear() {
        size = 0;
        map.clear();
    }

    @Override
    public Iterable<ISimpleMap.Entry<K, V>> entries() {
        List<ISimpleMap.Entry<K, V>> result = new ArrayList<>();
        for (ISimpleMap.Entry<K, List<V>> temp : map.entrySet()) {
            K key = temp.getKey();
            for (V value : temp.getValue()) {
                result.add(new ISimpleMap.Entry<>(key, value));
            }
        }
        return result;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (ISimpleMap.Entry<K, List<V>> entry : map.entrySet()) {
            set.add(entry.getKey());
        }
        return set;
    }

    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>();
        List<V> temp;
        for (ISimpleMap.Entry<K, List<V>> entry : map.entrySet()) {
            temp = map.get(entry.getKey());
            values.addAll(temp);
        }
        return values;
    }
}

