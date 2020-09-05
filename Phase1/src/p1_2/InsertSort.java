package p1_2;

import common.ArrayGenerator;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/8/25、16:17
 */
public class InsertSort {

    public static void main(String[] args) {
        Integer[] list = ArrayGenerator.getRandomArr(10);

        System.out.println(Arrays.toString(list));
        sort1(list);
        System.out.println(Arrays.toString(list));
    }

    /**
     * 版本一
     * 选择排序法
     * 时间复杂度为：O(n²);空间复杂度为：O(1)
     * 循环不变量：[i,n）未排序，[0,i) 已排序
     */
    public static <E extends Comparable> E[] sort(E[] list) {
        int len = list.length;
   //        for (int i = 1; i < len; i++) {
   //            for (int j = i; j > 0; j--)
   //                if (list[j].compareTo(list[j-1]) < 0)   //如果当前的数比前一个小，就和上一个替换位置
   //                    swap(list, j, j-1);
   //                else break;    // 如果不小了，就说明找到合适位置了，退出找下一个
   //        }

        for (int i = 1; i < len; i++)
            for (int j = i; j > 0 && list[j].compareTo(list[j - 1]) < 0; j--)
                swap(list, j, j - 1);   //如果当前的数比前一个小，就和上一个替换位置
        return list;
    }

    /**
     * 版本二
     * 选择排序法
     * 时间复杂度为：O(n²);空间复杂度为：O(1)
     * 循环不变量：[i,n）未排序，[0,i) 已排序
     */
    public static <E extends Comparable> E[] sort1(E[] list) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            E temp = list[i];    // 记录当前数
            int j = i;   //记录合适的位置
            for ( j = i; j > 0; j--)
                if (temp.compareTo(list[j - 1]) < 0)
                       // 如果temp比前一小，就把前面的值往后移动一位
                    list[j] = list[j-1];
                else break;    // 如果不小了，就说明找到合适位置了，退出找下一个
            list[j] = temp;    // 把当前值插入到合适的位置
        }
        return list;
    }

    public static <E extends Comparable> E[] sort1_(E[] list) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            E temp = list[i];    // 记录当前数
            int j = i;   //记录合适的位置
            for ( j = i; j > 0 && temp.compareTo(list[j - 1]) < 0; j--)
                    list[j] = list[j-1];
            list[j] = temp;

        }
        return list;
    }


    /**
     * 交换数组i和j的位置
     */
    public static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
