/**
 *  Priority queue implementation with an unsorted array.
 *
 *  The simplest priority queue implementation is based on our code for push-down stacks.
 *  The code for insert in the priority queue is the same as for push in the stack.
 *  To implement remove the maximum, we can add code like the inner loop of selection sort
 *  to exchange the maximum item with the item at the end and then delete that one,
 *  as we did with pop() for stacks.
 *
 *  <Key extends Comparable<Key>>
 *      This class is Type Parametrized, where the Key is an Interface
 *      that will extend java.util.Comparable Interface of type Key.
 */

package adt.arrayimpl;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;       // elements
    private int size;          // number of elements

    // set initial size of heap to hold size elements
    public UnorderedArrayMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(Key x) {
        pq[size ++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < size; i ++)
            if (less(max, i)) max = i;
        exchange(max, size - 1);

        return pq[-- size];         // size --; return pq[size];
    }

    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}
