package p2_1;


import util.SortInterface;

/**
 * @Author yongz
 * @Date 2020/8/25、16:17
 */
public class InsertSort implements SortInterface {



    /**
     * 版本一
     * 选择排序法
     * 时间复杂度为：O(n²);空间复杂度为：O(1)
     * 循环不变量：[i,n）未排序，[0,i) 已排序
     */
    @Override
    public  <E extends Comparable> void sort(E[] list) {
        int len = list.length;

        for (int i = 1; i < len; i++)
            for (int j = i; j > 0 && list[j].compareTo(list[j - 1]) < 0; j--)
                swap(list, j, j - 1);   //如果当前的数比前一个小，就和上一个替换位置
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
