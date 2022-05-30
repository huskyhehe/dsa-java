package adt.heapimpl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<Key> implements Iterable<Key> {
    private Key[] pq;                       // store items at indices 1 to size
    private int size;                       // number of items on priority queue
    private Comparator<Key> comparator;     // optional comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        size = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     * @param  comparator the order in which to compare the keys
     */
    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        size = 0;
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     * @param  keys the array of keys
     */
    public MaxPQ(Key[] keys) {
        size = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < size; i++)
            pq[i + 1] = keys[i];
        for (int k = size / 2; k >= 1; k --)
            sink(k);
        assert isMaxHeap();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    /**
     * Returns a largest key on this priority queue.
     * @return the largest key on this priority queue
     * @throw NoSuchElementException if this priority queue is empty
     */
    public Key getMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue underflow");
        }
        return pq[1];
    }

    /**
     * Removes and returns a largest key on this priority queue.
     * @return the largest key on this priority queue
     * @throw NoSuchElementException if this priority queue is empty
     */
    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue underflow");
        }
        Key max = pq[1];

        exchange(1, size --);
        sink(1);
        pq[size + 1] = null;         // to avoid loitering and help with garbage collection

        if ((size > 0) && (size == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        assert isMaxHeap();
        return max;
    }

    public void insert(Key x) {

        // double size of array if necessary
        if (size == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++ size] = x;
        swim(size);
        assert isMaxHeap();
    }





    // resize the underlying array to have the given capacity
    private void resize(int capacity) {
        assert capacity > size;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 0; i < size; i ++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }



    @Override
    public Iterator<Key> iterator() {
        return null;
    }
}
