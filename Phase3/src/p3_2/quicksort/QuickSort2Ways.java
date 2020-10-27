package p3_2.quicksort;


import uitl.SortInterface;

import java.util.Random;


/***
 * 双路快排
 */
public class QuickSort2Ways implements SortInterface {

    private static final Random random = new Random();


    @Override
    public <E extends Comparable<E>> void sort(E[] arrays) {
        quickSort2Ways(arrays, 0, arrays.length - 1);
    }

    private <E extends Comparable> void quickSort2Ways(E[] arrays, int l, int r) {
        if (l >= r) return;
        int partition = partition2Ways(arrays, l, r);
        // 对[l,partition-1]排序
        quickSort2Ways(arrays, l, partition - 1);
        // 对[partition+1，r]排序
        quickSort2Ways(arrays, partition + 1, r);
    }


    // 优化有序数组
    private <E extends Comparable> int partition2Ways(E[] arrays, int l, int r) {
        // 随机值
        int p = random.nextInt(r - l + 1) + l;
        swap(arrays, p, l);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        E temp = arrays[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arrays[i].compareTo(temp) < 0)
                i++;
            while (i <= j && arrays[j].compareTo(temp) > 0)
                j--;
            if (i >= j) break;
            swap(arrays, i, j);
            i++;
            j--;
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
