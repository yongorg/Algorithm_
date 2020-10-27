package p2_1;

import uitl.Queue;

/**
 * @Author yongz
 * @Date 2020/10/15、13:32
 */
public class PriorityQueue<E extends  Comparable<E>> implements Queue<E> {
    private MaxHeap<E > maxHeap;

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
