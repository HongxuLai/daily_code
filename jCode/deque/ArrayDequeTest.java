package deque;

import jh61b.junit.In;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    // test empty array deque
    @Test
    public void emptyDequeTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        assertTrue(d.isEmpty());
        assertEquals(0, d.size());
        assertNull(d.removeFirst());
        assertNull(d.removeLast());
        assertNull(d.get(0));
    }

    // test single item
    @Test
    public void singleItemTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();

        d.addFirst(10);
        assertEquals(1, d.size());
        assertEquals(Integer.valueOf(10), d.get(0));
        assertEquals(Integer.valueOf(10), d.removeFirst());
        assertTrue(d.isEmpty());

        d.addLast(20);
        assertEquals(1, d.size());
        assertEquals(Integer.valueOf(20), d.get(0));
        assertEquals(Integer.valueOf(20), d.removeLast());
        assertEquals(0, d.size());
    }

    // test many items
    @Test
    public void orderTestMixedAdds() {
        ArrayDeque<Integer> d = new ArrayDeque<>();

        d.addFirst(2);
        d.addFirst(1);
        d.addLast(3);
        // now the order is 1,2,3

        assertEquals(3, d.size());
        assertEquals(Integer.valueOf(1), d.get(0));
        assertEquals(Integer.valueOf(2), d.get(1));
        assertEquals(Integer.valueOf(3), d.get(2));

        assertEquals(Integer.valueOf(1), d.removeFirst());
        assertEquals(Integer.valueOf(3), d.removeLast());
        assertEquals(Integer.valueOf(2), d.removeFirst());
        assertTrue(d.isEmpty());
    }

    // test wrap-around
    @Test
    public void wrapAroundTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();

        for(int i = 0; i < 6; i++){
            d.addLast(i);
        }

        for(int i = 0; i < 4; i++){
            assertEquals(Integer.valueOf(i), d.removeFirst());
        }
        // [4,5];

        assertEquals(2, d.size());
        assertEquals(Integer.valueOf(4), d.get(0));
        assertEquals(Integer.valueOf(5), d.get(1));

        for(int i = 6; i <= 11; i++){
            d.addLast(i);
        }
        // [4,5,6,7,8,9,10,11];
        assertEquals(8, d.size());
        for (int i = 0; i < 8; i++) {
            assertEquals(Integer.valueOf(i + 4), d.get(i));
        }
    }

    // test enlarge the array
    @Test
    public void resizeGrowTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            d.addLast(i);
        }
        assertEquals(20, d.size());
        for (int i = 0; i < 20; i++) {
            assertEquals(Integer.valueOf(i), d.get(i));
        }
    }

    // test reduce the size
    @Test
    public void resizeShrinkTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < 32; i ++){
            d.addLast(i);
        }
        assertEquals(32, d.size());
        // [0,1,2...30,31]

        for (int i = 0; i < 28; i++) {
            assertEquals(Integer.valueOf(i), d.removeFirst());
        }
        assertEquals(4, d.size());
        // [28,29,30,31]

        for (int i = 0; i < 4; i++){
            assertEquals(Integer.valueOf(28 + i), d.get(i));
        }

        d.addFirst(100);
        d.addLast(200);
        assertEquals(Integer.valueOf(100), d.removeFirst());
        assertEquals(Integer.valueOf(200), d.removeLast());
    }
}
