package p3_2;

import p3_2.bubblesort.BubbleSort;
import p3_2.bubblesort.BubbleSort1;
import p3_2.bubblesort.BubbleSort2;
import p3_2.bubblesort.BubbleSort3;
import p3_2.insertsort.InsertSort;
import p3_2.mergersort.MergeSort;
import p3_2.shellsoet.ShellSort;
import p3_2.shellsoet.ShellSort2;
import uitl.ArrayGenerator;
import uitl.SortingHelper;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/10/17、15:12
 */
public class Test {

    public static void main(String[] args) {
        int n  = 100000;
        System.out.println("Random Arr");
        Integer[] randomArr1 = ArrayGenerator.getRandomArr(n, n);
        Integer[] randomArr2 = Arrays.copyOf(randomArr1, randomArr1.length);
        Integer[] randomArr3 = Arrays.copyOf(randomArr1, randomArr1.length);
        Integer[] randomArr4 = Arrays.copyOf(randomArr1, randomArr1.length);
        SortingHelper.sortTest(ShellSort2.class, randomArr1);
        SortingHelper.sortTest(ShellSort.class, randomArr2);
        SortingHelper.sortTest(BubbleSort.class, randomArr3);
        SortingHelper.sortTest(MergeSort.class, randomArr4);

        System.out.println("is Sorted Arr");
        randomArr1 = ArrayGenerator.getOrderArr(n);
        randomArr2 = ArrayGenerator.getOrderArr(n);
        randomArr3 = ArrayGenerator.getOrderArr(n);
        randomArr4 = ArrayGenerator.getOrderArr(n);
        SortingHelper.sortTest(BubbleSort.class, randomArr1);
        SortingHelper.sortTest(BubbleSort1.class, randomArr2);
        SortingHelper.sortTest(BubbleSort2.class, randomArr3);
        SortingHelper.sortTest(BubbleSort3.class, randomArr4);

    }
}
