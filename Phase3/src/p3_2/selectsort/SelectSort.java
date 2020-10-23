package p3_2.selectsort;

import uitl.SortInterface;

/**
 * @Author yongz
 * @Date 2020/8/25、15:15
 */
public class SelectSort implements SortInterface {


    @Override
    public <E extends Comparable<E>> void sort(E[] list) {
        int len = list.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;   //记录最小数的索引
            for (int j = i; j < len; j++)
                if ( list[j].compareTo(list[minIndex])<0 )    //compareTo方法比较，前者小于后者返回负数，前者大于后者返回正数，
                    minIndex = j;
            //  交换位置
            swap(list, i, minIndex);
        }
    }
    /**
     * 交换数组i和j的位置
     */
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

}
