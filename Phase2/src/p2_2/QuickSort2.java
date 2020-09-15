package p2_2;

import util.SortInterface;
import util.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/9/13、17:39
 */
public class QuickSort2 implements SortInterface {


    @Override
    public <E extends Comparable> void sort(E[] arrays) {
        quickSort(arrays, 0, arrays.length - 1, 1);
    }

    public static void main(String[] args) {
        Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SortingHelper.sortTest(QuickSort2.class, arr2);
    }

    private <E extends Comparable> void quickSort(E[] arrays, int l, int r, int depth) {
        if (l >= r) return;
        System.out.print(generateDepthString(depth));
        System.out.println("before  partition  [" + l + "," + r + "] \t" + Arrays.toString(arrays));
        int partition = partition(arrays, l, r);
        System.out.print(generateDepthString(depth));
        System.out.println("after partition  [" + l + "," + r + "] \t" + Arrays.toString(arrays));
        // 对[l,partition-1]排序
        quickSort(arrays, l, partition - 1, depth + 1);
        System.out.print(generateDepthString(depth));
        System.out.println("after sort [" + l + "," + (partition - 1) + "] \t" + Arrays.toString(arrays));
        // 对[partition+1，r]排序
        quickSort(arrays, partition + 1, r, depth + 1);
        System.out.print(generateDepthString(depth));
        System.out.println("after sort [" + (partition + 1) + "," + r + "] \t" + Arrays.toString(arrays));
    }


    private <E extends Comparable> int partition(E[] arrays, int l, int r) {
        int p = new Random().nextInt(r - l + 1) + l;
        swap(arrays, p, l);
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

    private static String generateDepthString(int depth) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }


}
