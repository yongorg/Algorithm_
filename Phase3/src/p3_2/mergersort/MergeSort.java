package p3_2.mergersort;




import uitl.SortInterface;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/4、23:35
 * 有序数组的优化
 */
public class MergeSort implements SortInterface {

    @Override
    public  <E extends Comparable<E>> void sort(E[] data) {
        E[] copyData = Arrays.copyOf(data, data.length);
        mergeSort(data, 0, data.length - 1,copyData);
    }

    private static <E extends Comparable> void mergeSort(E[] data, int l, int r,E[] copyData) {
        if (l >= r) return;

        int mid = (l + r) / 2;   //l+r超出int的最大值就会出问题，
        // 对l到mid进行排序
        mergeSort(data, l, mid,copyData);
        // 对mid+1 到 r进行排序
        mergeSort(data, mid + 1, r,copyData);
        // 优化1！如果前半个数组[l,mid]的最后一个值[mid]已经比后半截数组[mid+1,r]的第一个值[mid+1]小于等于，说明每必要去合并操作。
        if (data[mid].compareTo(data[mid + 1]) > 0)
            // 合并数组
            merge(data, l, mid, r,copyData);
    }


    private static <E extends Comparable> void merge(E[] data, int l, int mid, int r,E[] copyData) {

        // 优化3：内存优化
        for (int i = l; i <= r; i++)
            copyData[i] = data[i];


        int i = l;
        int j = mid + 1;
        for (int x = l; x < r + 1; x++) {
            if (i > mid)
                data[x] = copyData[j++ ];
            else if (j > r)
                data[x] = copyData[i++ ];
            else
                data[x] = copyData[i].compareTo(copyData[j]) <= 0 ? copyData[i++] : copyData[j++];

        }
    }


}
