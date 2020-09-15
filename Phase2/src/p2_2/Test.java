package p2_2;

import p2_1.MergeSort5;
import util.ArrayGenerator;
import util.SortingHelper;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/13、18:18
 */
public class Test {

    public static void main(String[] args) {
        int n = 10;

        Integer[] arr1 = ArrayGenerator.getRandomArr(n); //有序数组
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length); //有序数组

        SortingHelper.sortTest(MergeSort5.class, arr1);
        SortingHelper.sortTest(QuickSort2.class, arr2);
    }
}
