package p2_1;

import uitl.SortInterface;

/**
 * @Author yongz
 * @Date 2020/9/28、15:52
 */
public class HeapSort implements SortInterface {

    private HeapSort() {
    }


    @Override
    public <E extends Comparable<E>> void sort(E[] arrays) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : arrays)
            maxHeap.add(e);

        for (int i = arrays.length - 1; i >= 0; i--)
            arrays[i] = maxHeap.extractMax();

    }




}
