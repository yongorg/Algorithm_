package p2_1;


import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/4、23:35
 */
public class MergeSort2 {
    public static void main(String[] args) {
        Integer[] data = {2, 1, 7, 8, 4, 3, 2, 5};
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static <E extends Comparable> void sort(E[] data) {

        mergeSort(data, 0, data.length - 1);
    }

    private static <E extends Comparable> void mergeSort(E[] data, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;

        // 对l到mid进行排序
        mergeSort(data, l, mid);
        // 对mid+1 到 r进行排序
        mergeSort(data, mid + 1, r);

        // 合并数组
        merge(data, l, mid, r);
    }


    private static <E extends Comparable> void merge(E[] data, int l, int mid, int r) {
        E[] copyData = (E[]) new Object[data.length];
        for (int i = l; i < r + 1; i++) {
            copyData[i] = data[i];
        }

        int i = l;
        int j = mid + 1;
        for (int x = l; x < r + 1; x++) {
            if (i == (mid + 1))
                data[x] = copyData[j++];
            else if (j == r + 1)
                data[x] = copyData[i++];
            else
                data[x] = copyData[i].compareTo(copyData[j]) <= 0 ? copyData[i++] : copyData[j++];

        }
    }


}
