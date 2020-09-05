package p1_2;

import common.ArrayGenerator;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/8/25、15:15
 */
public class SelectSort {

    public static void main(String[] args) {
        Integer[] list = ArrayGenerator.getRandomArr(10);

        System.out.println(Arrays.toString(list));
        sort(list);
        System.out.println(Arrays.toString(list));
    }

    /**
     * 选择排序法
     * 时间复杂度为：O(n²);空间复杂度为：O(1)
     * 循环不变量：[i,n）未排序，[0,i) 已排序
     */
    public static<E extends Comparable> E[] sort(E[] list) {    //这里要求泛型E继承了Comparable接口，后面才能使用compareTo 方法
        int len = list.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;   //记录最小数的索引
            for (int j = i; j < len; j++)
                if ( list[j].compareTo(list[minIndex])<0 )    //compareTo方法比较，前者小于后者返回负数，前者大于后者返回正数，
                    minIndex = j;
               //  交换位置
            swap(list, i, minIndex);
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
