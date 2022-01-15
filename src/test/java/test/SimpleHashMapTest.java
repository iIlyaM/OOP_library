package test;


import org.junit.jupiter.api.Test;
import ru.vsu.cs.ilyam.hashmap.ISimpleMap;
import ru.vsu.cs.ilyam.hashmap.SimpleHashMap;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class SimpleHashMapTest {

    @Test
    public void testPutFunc() {
        ISimpleMap<Integer, String> testMap = new SimpleHashMap<>();
        testMap.put(1, "Tom");
        testMap.put(2, "Jerry");
        assertEquals(2, testMap.size());
        assertTrue(testMap.containsKey(1));
        assertTrue(testMap.containsValue("Jerry"));
        assertFalse(testMap.containsKey(76));
        assertFalse(testMap.containsValue("Omega"));
    }

    @Test
    public void testGetFunc() {
        ISimpleMap<String, String> testMap = new SimpleHashMap<>();
        testMap.put("1", "Limbo");
        testMap.put("2", "Alpha");
        testMap.put("28", "Tree");
        testMap.put("6a", "Alfredo");
        assertEquals("Limbo", testMap.get("1"));
        assertEquals("Alpha", testMap.get("2"));
        assertNull(testMap.get(""));
        assertEquals("Limbo", testMap.get("1"));
        assertNull(testMap.get("128"));
        assertEquals("Alfredo", testMap.get("6a"));
        assertEquals( "Tree" ,testMap.get("28"));
    }

    @Test
    public void testContainsKeyFunc() {
        ISimpleMap<Integer, Character> testMap = new SimpleHashMap<>();
        testMap.put(1, 'a');
        testMap.put(2, 'v');
        testMap.put(16, 'c');
        testMap.put(41, '6');
        testMap.put(35, 'A');
        testMap.put(9, 'B');

        assertTrue(testMap.containsKey(1));
        assertTrue(testMap.containsKey(2));
        assertTrue(testMap.containsKey(16));
        assertTrue(testMap.containsKey(41));
        assertTrue(testMap.containsKey(35));
        assertTrue(testMap.containsKey(9));
        assertFalse(testMap.containsKey(0));
        assertFalse(testMap.containsKey(56));
        assertFalse(testMap.containsKey(15));
        assertFalse(testMap.containsKey(42));
    }

    @Test
    public void testContainsValueFunc() {
        ISimpleMap<Integer, Character> testMap = new SimpleHashMap<>();
        testMap.put(65, 'L');
        testMap.put(16, 'F');
        testMap.put(35, '6');
        testMap.put(1, 'a');

        assertTrue(testMap.containsValue('L'));
        assertTrue(testMap.containsValue('F'));
        assertTrue(testMap.containsValue('6'));
        assertTrue(testMap.containsValue('a'));
        testMap.remove(1);
        assertFalse(testMap.containsValue('a'));
        assertFalse(testMap.containsValue('f'));
        assertFalse(testMap.containsValue('l'));
        assertFalse(testMap.containsValue('7'));

        testMap.put(12, 'G');

        assertTrue(testMap.containsValue('G'));
        assertFalse(testMap.containsValue('g'));
    }

    @Test
    public void testIsEmptyFunc() {
        ISimpleMap<Integer, String> testMap = new SimpleHashMap<>();

        assertTrue(testMap.isEmpty());
        testMap.put(1, "Hello");
        assertFalse(testMap.isEmpty());
    }

    @Test
    public void testSizeFunc() {
        ISimpleMap<Integer, Character> testMap = new SimpleHashMap<>();
        assertEquals(0, testMap.size());

        testMap.put(1, 'A');
        testMap.put(11, 'a');
        testMap.put(12, 'F');
        testMap.put(85, 'C');
        testMap.put(0, 'd');

        assertEquals(5, testMap.size());
    }

    @Test
    public void testRemoveFunc() {
        ISimpleMap<String, Integer> testMap = new SimpleHashMap<>();

        testMap.put("Bob", 45);
        testMap.put("Tom", 69);
        testMap.put("Sarah", 56);

        assertEquals(3, testMap.size());
        testMap.remove("Bob");
        assertEquals(2, testMap.size());
        assertNull(testMap.get("Bob"));

        testMap.remove("Sarah");
        assertEquals(1, testMap.size());
        assertNull(testMap.get("Sarah"));
    }

    @Test
    public void testClearFunc() {
        ISimpleMap<Integer, Character> testMap = new SimpleHashMap<>();
        testMap.put(65, 'L');
        testMap.put(16, 'F');
        testMap.put(35, '6');
        testMap.put(1, 'a');

        assertEquals(4, testMap.size());
        testMap.clear();
        assertEquals(0, testMap.size());
        assertTrue(testMap.isEmpty());
    }

    @Test
    public void testKeySetFunc() {
        ISimpleMap<Integer, String> testMap = new SimpleHashMap<>();
        testMap.put(1, "Timmy");
        testMap.put(12, "Axe");
        testMap.put(7, "Smile");
        testMap.put(87, "Lucky");

        Set<Integer> testSet = testMap.keySet();
        assertFalse(testSet.isEmpty());
        assertTrue(testSet.contains(1));
        assertTrue(testSet.contains(12));
        assertTrue(testSet.contains(7));
        assertTrue(testSet.contains(87));
        assertFalse(testSet.contains(0));
    }

    @Test
    public void testValuesFunc() {
        ISimpleMap<Integer, String> testMap = new SimpleHashMap<>();
        testMap.put(1, "Tom");
        testMap.put(2, "Jerry");

        Set<String> testSet = testMap.values();
        assertTrue(testSet.contains("Tom"));
        assertTrue(testSet.contains("Jerry"));
        assertFalse(testSet.contains("Dave"));

        testMap.remove(2);

        testSet = testMap.values();
        assertTrue(testSet.contains("Tom"));
        assertFalse(testSet.contains("Jerry"));
    }

    @Test
    public void testEntrySetFunc() {
        ISimpleMap<String, String> testMap = new SimpleHashMap<>();
        testMap.put("1", "Limbo");
        testMap.put("2", "Alpha");
        testMap.put("28", "Tree");

        Set<ISimpleMap.Entry<String, String>> testSet = testMap.entrySet();
        assertTrue(testSet.containsAll(testMap.entrySet()));

        testMap.put("45", "O");
        assertFalse(testSet.containsAll(testMap.entrySet()));
    }
}
