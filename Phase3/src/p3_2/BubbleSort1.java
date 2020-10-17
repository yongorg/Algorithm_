package p3_2;

import uitl.SortInterface;

/**
 * @Author yongz
 * @Date 2020/10/17、15:08
 *  优化：如果有序数组时，使其变成O(n)算法。
 */
public class BubbleSort1 implements SortInterface {
    @Override
    /*
        优化：如果有序数组时，使其变成O(n)算法。
     */
    public <E extends Comparable<E>> void sort(E[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            boolean  isSwapped = false;
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j].compareTo(arrays[j+1]) > 0){
                    swap(arrays, j,j+1);
                    isSwapped = true;
                }
            }

            if (!isSwapped) break;
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
