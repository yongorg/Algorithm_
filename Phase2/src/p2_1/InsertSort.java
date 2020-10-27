package p2_1;


import util.SortInterface;

import java.util.Comparator;

/**
 * @Author yongz
 * @Date 2020/8/25、16:17
 */
public class InsertSort implements SortInterface {


    public <E extends Comparable> void sort(E[] list) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            E temp = list[i];    // 记录当前数
            int j = i;   //记录合适的位置
            for (j = i; j > 0 && temp.compareTo(list[j - 1]) < 0; j--)
                list[j] = list[j - 1];
            list[j] = temp;

        }
    }

    public <E> void sort(E[] list, Comparator comparator) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            E temp = list[i];    // 记录当前数
            int j = i;   //记录合适的位置
            for (j = i; j > 0 && comparator.compare(temp, list[j - 1]) < 0; j--)
                list[j] = list[j - 1];
            list[j] = temp;

        }
    }

    public static <E extends Comparable> void insertSortRange(E[] list, int l, int r) {
        int len = list.length;
        for (int i = l; i <= r; i++) {
            E temp = list[i];    // 记录当前数
            int j = i;   //记录合适的位置
            for (j = i; j - 1 >= l && temp.compareTo(list[j - 1]) < 0; j--)
                list[j] = list[j - 1];
            list[j] = temp;

        }
    }


}
