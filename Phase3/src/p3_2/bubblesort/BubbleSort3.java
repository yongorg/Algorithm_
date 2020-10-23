package p3_2.bubblesort;

import uitl.SortInterface;

/**
 * @Author yongz
 * @Date 2020/10/17、15:08
 * 换一种方法实现冒泡排序算法：从后向前排
 */
public class BubbleSort3 implements SortInterface {
    @Override
    public <E extends Comparable<E>> void sort(E[] arrays) {
        for (int i = 0; i < arrays.length - 1; ) {
            int lastSwappedIndex = arrays.length - 1;
            for (int j = arrays.length - 1; j > i; j--) {
                if (arrays[j].compareTo(arrays[j - 1]) < 0) {
                    swap(arrays, j, j - 1);
                    lastSwappedIndex = j;
                }
            }
            i =  lastSwappedIndex;
        }
    }

    /**
     * 交换数组i和j的位置
     */
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
