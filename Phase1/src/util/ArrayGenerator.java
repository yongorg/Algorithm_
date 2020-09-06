package util;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/8/11、9:14
 */
public class ArrayGenerator {

    /**
     * 随机生成n长的有序数组
     */
    public static Integer[] getOrderArr(int n){
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            integers[i] = i;
        }
        return integers;
    }

    /**
     * 随机生成n长的随机数组
     */
    public static Integer[] getRandomArr(int n){
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int i1 = random.nextInt(n);
            integers[i] = i1;
        }
        return integers;
    }

}
