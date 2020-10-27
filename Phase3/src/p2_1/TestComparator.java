package p2_1;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/10/16、15:56
 */
public class TestComparator {

    public static void main(String[] args) {
        Integer[] test = {1,5,1,4,2,7,6,4,2,7,1,9,4,2,56,4,5};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
        int[] test2 = {1,5,1,4,2,7,6,4,2,7,1,9,4,2,56,4,5};
        Arrays.sort(test2);
        System.out.println(Arrays.toString(test));
    }
}
