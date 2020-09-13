package p2_2;

import util.SortInterface;

/**
 * @Author yongz
 * @Date 2020/9/13、17:39
 */
public class QuickSort implements SortInterface {


    @Override
    public <E extends Comparable> void sort(E[] arrays) {
        quickSort(arrays, 0, arrays.length - 1);
    }

    private <E extends Comparable> void quickSort(E[] arrays, int l, int r) {
        if (l >= r) return;
        int partition = partition(arrays, l, r);
        quickSort(arrays, l, partition - 1);
        quickSort(arrays, partition + 1, r);
    }


    private <E extends Comparable> int partition(E[] arrays, int l, int r) {
        // arr[l+1...j] < v; arr[j+1...i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arrays[i].compareTo(arrays[l]) < 0) {
                j++;
                swap(arrays, i, j);
            }
        }
        swap(arrays, l, j);
        return j;
    }

    /**
     * 交换数组i和j的位置
     */
    public static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }


}
