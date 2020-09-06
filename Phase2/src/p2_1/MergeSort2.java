package p2_1;



import util.SortInterface;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/4、23:35
 */
public class MergeSort2 implements SortInterface {

    @Override
    public  <E extends Comparable> void sort(E[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private static <E extends Comparable> void mergeSort(E[] data, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;   //l+r超出int的最大值就会出问题，
        // 对l到mid进行排序
        mergeSort(data, l, mid);
        // 对mid+1 到 r进行排序
        mergeSort(data, mid + 1, r);
        // 合并数组
        merge(data, l, mid, r);
    }


    private static <E extends Comparable> void merge(E[] data, int l, int mid, int r) {

        E[] copyData = Arrays.copyOfRange(data, l, r + 1);

        int i = l;
        int j = mid + 1;
        for (int x = l; x < r + 1; x++) {
            if (i > mid)
                data[x] = copyData[j++ - l];
            else if (j > r)
                data[x] = copyData[i++ - l];
            else
                data[x] = copyData[i - l].compareTo(copyData[j - l]) <= 0 ? copyData[i++ - l] : copyData[j++ - l];

        }
    }


}
