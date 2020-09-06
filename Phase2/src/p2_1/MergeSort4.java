package p2_1;


import util.SortInterface;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/4、23:35
 * 插入排序算法优化归并排序法
 */
public class MergeSort4 implements SortInterface {

    @Override
    public   <E extends Comparable> void sort(E[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private static <E extends Comparable> void mergeSort(E[] data, int l, int r) {
        // if (l >= r) return;
        //在数组较短时， nlogn的性能比n²要大,下面到15这个区间，就不采用归并排序了，通过插入排序法来优化
        // 优化2：插入排序法优化归并排序法
        if (r - l <= 15) {
            InsertSort.insertSortRange(data, l, r);
            return;
        }
        int mid = (l + r) / 2;   //l+r超出int的最大值就会出问题，
        // 对l到mid进行排序
        mergeSort(data, l, mid);
        // 对mid+1 到 r进行排序
        mergeSort(data, mid + 1, r);

        // 优化1！如果前半个数组[l,mid]的最后一个值[mid]已经比后半截数组[mid+1,r]的第一个值[mid+1]小于等于，说明每必要去合并操作。
        if (data[mid].compareTo(data[mid + 1]) > 0)
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
