package p3_2.shellsoet;

import uitl.SortInterface;

/**
 * @Author yongz
 * @Date 2020/10/17、17:29
 */
public class ShellSort implements SortInterface {
    @Override
    public <E extends Comparable<E>> void sort(E[] arrays) {
        int h = arrays.length / 2;
        while (h >= 1) {
            for (int start = 0; start < h; start++) {
                // 对arr[start,start + h,start + 2h,start + 3h...]进行插入排序
                for (int i = start + h; i < arrays.length; i += h) {
                    E temp = arrays[i];    // 记录当前数
                    int j;   //记录合适的位置
                    for (j = i; j - h >= 0 && temp.compareTo(arrays[j - h]) < 0; j -= h)
                        arrays[j] = arrays[j - h];
                    arrays[j] = temp;
                }
            }
            h /= 2;
        }
    }


    private <E extends Comparable<E>> void insertingSort(E[] arrays, int start, int h) {
        for (int i = start + h; i < arrays.length; i += h) {
            E temp = arrays[i];    // 记录当前数
            int j;   //记录合适的位置
            for (j = i; j - h > 0 && temp.compareTo(arrays[j - h]) < 0; j -= h)
                arrays[j] = arrays[j - h];
            arrays[j] = temp;
        }
    }
}
