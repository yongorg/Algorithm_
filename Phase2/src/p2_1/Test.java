
package p2_1;


import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;


/**
 * @Author yongz
 * @Date 2020/9/6、0:51
 *
 */
public class Test {

    public static void main(String[] args) {
        int n = 1000000 ;

        Integer[] arr1 = ArrayGenerator.getRandomArr(n); //有序数组
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length); //有序数组

        // MergeSort2是插入排序算法未优化过的归并排序
        SortingHelper.sortTest(MergeSort.class, arr1);
        // MergeSort4是插入排序算法优化过的的归并排序
        SortingHelper.sortTest(MergeSort6.class, arr2);

    }

}
