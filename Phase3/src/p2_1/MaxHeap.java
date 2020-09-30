package p2_1;

/**
 * @Author yongz
 * @Date 2020/9/22、18:39
 * <p>
 * 二叉堆性质：堆中节点的值总是不大于父节点的值
 * <p>
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(E[] arrays) {
        this.data = new Array<E>(arrays);
        for (int i = parent(arrays.length - 1); i >= 0; i--)
            siftDown(i);
    }


    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 does not have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void swap(int i, int j) {
        E e = data.get(i);
        data.set(i, data.get(j));
        data.set(j, e);
    }


    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(size() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (isEmpty())
            throw new IllegalArgumentException("heap is empty!");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax() {
        E max = findMax();
        data.swap(0, size() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize()
                    && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = j + 1; // j+1就是右孩子
            }

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);
            k = j;
        }
        //        while (data.get(leftChild(k)).compareTo(data.get(k)) > 0 || data.get(rightChild(k)).compareTo(data.get(k)) > 0) {
        //            if (data.get(leftChild(k)).compareTo(data.get(rightChild(k))) > 0) {
        //                data.swap(k, leftChild(k));
        //                k = leftChild(k);
        //            } else {
        //                data.swap(k, rightChild(k));
        //                k = rightChild(k);
        //            }
        //        }
    }


    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }


    // 取出最大元素后，放入新元素
    public E replace(E e) {
        E max = findMax();
        data.set(0, max);
        siftDown(0);
        return max;
    }

}
