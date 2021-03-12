import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ArrayQueueTest {
    public Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new ArrayQueue<Integer>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("enqueue some strings then call size and isEmpty should get right number")
    void testEnqueue() {
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        assertEquals(20, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("enqueue some items then dequeue then call size and isFull isEmpty should get right number")
    void dequeue() {
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        assertEquals(15, queue.size());
        assertEquals(0, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(11, queue.size());
        queue.enqueue(14);
        assertEquals(12, queue.size());
        queue.enqueue(14);
        assertEquals(13, queue.size());

    }

    @Test
    @DisplayName("push some items then pop call size get right size")
    void size() {
        for (int i = 0; i < 16; i++) {
            queue.enqueue(i);
        }
        assertEquals(16, queue.size());
        for (int i = 0; i < 6; i++) {
            queue.dequeue();
        }
        assertEquals(10, queue.size());
        assertEquals(6, queue.dequeue());
        queue.enqueue(9);
        assertEquals(10, queue.size());
    }

    @Test
    void isEmpty() {
    }
}