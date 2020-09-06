package p2_1;


import com.sun.scenario.effect.Merge;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/4、23:35
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {2, 1, 7, 8, 4, 3, 2, 5};
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void sort(int[] data) {

        mergeSort(data, 0, data.length - 1);
    }

    private static void mergeSort(int[] data, int l, int r) {
        if (l >= r) return;

         int mid = (l + r) / 2;   //l+r超出int的最大值就会出问题，
        // 对l到mid进行排序
        mergeSort(data, l, mid);
        // 对mid+1 到 r进行排序
        mergeSort(data, mid + 1, r);

        // 合并数组
        merge(data, l, mid, r);
    }


    private static void merge(int[] data, int l, int mid, int r) {
        int[] temp = new int[data.length];
        for (int i = l; i < r + 1; i++) {
            temp[i] = data[i];
        }

        int i = l;
        int j = mid + 1;
        for (int x = l; x < r + 1; x++) {
            if (i == (mid + 1))
                data[x] = temp[j++];
            else if (j == r + 1)
                data[x] = temp[i++];
            else
                data[x] = temp[i] <= temp[j] ? temp[i++] : temp[j++];

        }
    }


}
