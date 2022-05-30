package adt.arrayimpl;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;       // elements
    private int size;       // number of elements

    // set initial size of heap to hold size elements
    public OrderedArrayMaxPQ(int capacity) {
        pq = (Key[]) (new Comparable[capacity]);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Key delMax() {
       return pq[-- size];      // size --; return pq[size];
    }

    public void insert(Key key) {
        int i = size - 1;
        while (i > 0 && less(key, pq[i])) {
            pq[i + 1] = pq[i];
            i --;
        }
        pq[i + 1] = key;
        size ++;
    }

    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }
}
