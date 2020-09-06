
package p2_1;


import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/6、0:51
 */
public class Test {

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr1 = ArrayGenerator.getRandomArr(n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortingHelper.sortTest(InsertSort.class, arr1);
        SortingHelper.sortTest(SelectSort.class, arr2);
        SortingHelper.sortTest(MergeSort2.class, arr3);

    }

}
