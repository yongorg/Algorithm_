package p2_2;

import util.SortInterface;

import java.util.Random;


/***
 * 三路快排
 */
public class QuickSort3Ways implements SortInterface {

    private static final Random random = new Random();


    @Override
    public <E extends Comparable> void sort(E[] arrays) {
        quickSort3Ways(arrays, 0, arrays.length - 1);
    }

    private <E extends Comparable> void quickSort3Ways(E[] arrays, int l, int r) {
        if (l >= r) return;
        // 随机值
        int p = random.nextInt(r - l + 1) + l;
        swap(arrays, p, l);

        // arr[l+1...lt] < v;arr[lt+1...i-1] == v; arr[gt...r] >= v
        int lt = l; // 确保小于的空区间
        int gt = r + 1;// 确保大于的空区间
        for (int i = l + 1; i < gt; i++) {
            if (arrays[i].compareTo(arrays[l]) == 0) {
                // 相等时不需要任何操作
            } else if (arrays[i].compareTo(arrays[l]) < 0) {
                lt++;
                swap(arrays, lt, i);

            } else if (arrays[i].compareTo(arrays[l]) > 0) {
                gt--;
                swap(arrays, gt, i);
                i--;//确保刚才gt换过来的值继续被扫描
            }
        }
        swap(arrays, lt, l);

        //将小于v区间继续排序
        quickSort3Ways(arrays, l, lt - 1);
        //将大于v区间继续排序
        quickSort3Ways(arrays, gt, r);

    }

    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
