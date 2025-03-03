public class ArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int first = 0;
    private int size = 0;
    private static final int CAPACITY = 1000;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) throws IllegalStateException {
        if (size == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (first + size) % data.length;
        data[avail] = e;
        size++;
    }

    public E first() {
        if (isEmpty())
            return null;
        return data[first];
    }

    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return answer;
    }


}
