public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_SIZE = 16;
    private E[] array;
    private int front, tail;

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int capacity) {
        array = (E[]) new Object[capacity];
        front = tail = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) resize(array.length * 2);
        array[tail] = e;
        tail = (tail + 1) % array.length;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("no data in there");
        final E it = array[front];
        front = (front + 1) % array.length;
        return it;
    }

    @Override
    public int size() {
        int size = 0;
        if (tail > front) {
            size = tail - front;
        } else {
            size = array.length - front + tail;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail && tail == 0;
    }

    private void resize(int capacity) {
        final E[] oldArray = array;
        array = (E[]) new Object[capacity];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[(front + i) % oldArray.length];
        }
        front = 0;
        tail = oldArray.length - 1;
    }

    private boolean isFull() {
        return (tail + 1) % array.length == front;
    }
}
