package p2_1;


import util.SortInterface;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * 至底向上的归并排序
 */
public class MergeSort6 implements SortInterface {

    @Override
    public <E extends Comparable> void sort(E[] data) {

        int n = data.length;
        E[] copyData = Arrays.copyOf(data, n);

        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz) {
            // 遍历合并的两个区间的起始位置 i
            // 合并[i,i+sz-1]和[i+sz,Math.min(i + sz + sz - 1, n - 1)]
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (data[i + sz - 1].compareTo(data[i + sz]) > 0)
                    merge(data, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), copyData);
            }
        }
    }


    private static <E extends Comparable> void merge(E[] data, int l, int mid, int r, E[] copyData) {

        System.arraycopy(data, l, copyData, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        for (int x = l; x < r + 1; x++) {
            if (i > mid)
                data[x] = copyData[j++];
            else if (j > r)
                data[x] = copyData[i++];
            else
                data[x] = copyData[i].compareTo(copyData[j]) <= 0 ? copyData[i++] : copyData[j++];

        }
    }


}
