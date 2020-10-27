package p3_2.quicksort;


import uitl.ArrayGenerator;
import uitl.SortInterface;
import uitl.SortingHelper;

import java.util.Random;


/**
 * @Author yongz
 * @Date 2020/9/13、17:39
 * 测试第一版的QuickSort，对于有序数组是一个O(n²)的算法，递归深度是O(n),数据量过大会导致StackOverflowError 堆溢出；
 * <p>
 * 原因是由于partition，每次都是取第一个，就会导致每次只划分了一个区间
 * <p>
 * 该类为快速排序添加随机化
 */
public class QuickSort implements SortInterface {

    private Random random = new Random();


    @Override
    public <E extends Comparable<E>> void sort(E[] arrays) {
        quickSort(arrays, 0, arrays.length - 1);
    }

    private <E extends Comparable> void quickSort(E[] arrays, int l, int r) {
        if (l >= r) return;
        int partition = partition(arrays, l, r);
        // 对[l,partition-1]排序
        quickSort(arrays, l, partition - 1);
        // 对[partition+1，r]排序
        quickSort(arrays, partition + 1, r);
    }


    // 优化有序数组
    private <E extends Comparable> int partition(E[] arrays, int l, int r) {
        // 去[r,l]中间的值
        swap(arrays, l, (r + l) / 2);

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
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }


}
