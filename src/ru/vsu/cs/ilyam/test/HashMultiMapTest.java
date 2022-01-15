package ru.vsu.cs.ilyam.test;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.ilyam.hashmultimap.HashMultiMap;
import ru.vsu.cs.ilyam.hashmultimap.IMultiMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashMultiMapTest {

    @Test
    public void testPutFunc() {
        IMultiMap<String, Integer> testMultiMap = new HashMultiMap<>();
        testMultiMap.put("Bob", 8);
        testMultiMap.put("John", 6);
        testMultiMap.put("Bob", 12);
        testMultiMap.put("Charlie", 10);
        assertEquals(4, testMultiMap.size());
        int counter = 0;
        for (Object i : testMultiMap.get("Bob")) {
            counter++;
        }
        assertEquals(2, counter);

        counter = 0;
        for (Object i : testMultiMap.get("John")) {
            counter++;
        }

        assertEquals(1, counter);
    }

    @Test
    public void testGetFunc() {
        IMultiMap<String, Integer> testMultiMap = new HashMultiMap<>();
        testMultiMap.put("Tree", 1);
        testMultiMap.put("Stone", 12);
        testMultiMap.put("Fire", 6);
        testMultiMap.put("Stone", 15);
        testMultiMap.put("Stone", 16);
        testMultiMap.put("Stone", 0);
        testMultiMap.put("Fire", 65);

        int counter = 0;
        for (Object i : testMultiMap.get("Tree")) {
            counter++;
        }
        assertEquals(1, counter);
        counter = 0;

        for (Object i : testMultiMap.get("Stone")) {
            counter++;
        }
        assertEquals(4, counter);
        counter = 0;

        for (Object i : testMultiMap.get("Fire")) {
            counter++;
        }
        assertEquals(2, counter);
    }

    @Test
    public void testRemoveFunc() {
        IMultiMap<String, Integer> testMultiMap = new HashMultiMap<>();
        testMultiMap.put("Bob", 8);
        testMultiMap.put("Charlie", 10);
        testMultiMap.put("John", 6);
        testMultiMap.put("Bob", 12);
        assertEquals(4, testMultiMap.size());

        int counter = 0;
        for (Object i : testMultiMap.get("Bob")) {
            counter++;
        }
        assertEquals(2, counter);
        counter = 0;

        assertTrue(testMultiMap.remove("Bob", 8));
        assertFalse(testMultiMap.remove("Bob", 9));

        for (Object i : testMultiMap.get("Bob")) {
            counter++;
        }

        assertEquals(3, testMultiMap.size());
        assertEquals(1, counter);
    }

    @Test
    public void testRemoveAllFunc() {
        IMultiMap<Integer, Character> testMultiMap = new HashMultiMap<>();
        testMultiMap.put(1, 'j');
        testMultiMap.put(1, 'a');
        testMultiMap.put(1, 'v');
        testMultiMap.put(1, 'a');
        testMultiMap.put(2, 'c');
        assertEquals(5, testMultiMap.size());

        int counter = 0;
        for (Object i : testMultiMap.removeAll(1)) {
            counter++;
        }

        assertEquals(4, counter);
    }

    @Test
    public void testClearFunc() {
        IMultiMap<String, Integer> testMultiMap = new HashMultiMap<>();
        testMultiMap.put("Bob", 8);
        testMultiMap.put("John", 6);
        testMultiMap.put("Bob", 12);
        testMultiMap.put("Charlie", 10);
        testMultiMap.put("Charlie", 13);
        testMultiMap.put("Joe", 9);
        assertEquals(6, testMultiMap.size());

        testMultiMap.clear();
        assertEquals(0, testMultiMap.size());
        assertTrue(testMultiMap.isEmpty());
    }

    @Test
    public void testKeySetFunc() {
        IMultiMap<String, String> testMultiMap = new HashMultiMap<>();
        testMultiMap.put("Rob", "Stone");
        testMultiMap.put("Mike", "Perry");
        testMultiMap.put("Josh", "Yang");
        testMultiMap.put("Rob", "Strong");
        testMultiMap.put("Kate", "Woo");

        assertEquals(4, testMultiMap.keySet().size());
        assertEquals(5, testMultiMap.size());

        testMultiMap.remove("Rob", "Strong");

        assertEquals(4, testMultiMap.keySet().size());
        assertEquals(4, testMultiMap.size());

        testMultiMap.remove("Mike", "Perry");

        assertEquals(3, testMultiMap.keySet().size());
        assertEquals(3, testMultiMap.size());
    }

    @Test
    public void testValuesFunc() {
        IMultiMap<String, Integer> testMultiMap = new HashMultiMap<>();
        testMultiMap.put("Tom", 187);
        testMultiMap.put("Tom", 165);
        testMultiMap.put("Mike", 165);
        testMultiMap.put("Josh", 171);
        testMultiMap.put("Mary", 168);
        testMultiMap.put("Walter", 175);
        testMultiMap.put("Kyle", 180);

        assertEquals(7, testMultiMap.values().size());

        List<Integer> testList = new ArrayList<>();
        testList.add(187);
        testList.add(165);
        testList.add(165);
        testList.add(171);
        testList.add(168);
        testList.add(175);
        testList.add(180);

        List<Integer> valList = testMultiMap.values();

        int count = 0;
        for (int i = 0; i < valList.size(); i++) {
            if(testList.contains(valList.get(i))) {
                count++;
            }
        }
        assertEquals(7, count);
    }
}

