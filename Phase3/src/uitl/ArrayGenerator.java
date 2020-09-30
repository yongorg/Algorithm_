package uitl;

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

    public static Integer[] generateSpecialArray(int n){

        // 开空间
        Integer[] arr = new Integer[n];
        // 生成 arr[0…n-1] 的测试用例，其中最小值是 0
        generateSpecialArray(arr, 0, arr.length - 1, 0);
        return arr;

    }

    private static void generateSpecialArray(Integer[] arr, int l, int r, int value){
        // 递归到底的情况。如果 l > r，我们要处理的区间为空，直接返回
        if(l > r) return;
        // 1. 把最小值放到中间
        int mid = (l + r) / 2;
        arr[mid] = value;
        // 2. 模拟 partition 过程，把中间元素和最左边元素交换位置；
        swap(arr, l, mid);
        // 3. 处理除了最左边的元素之外，剩下的 n - 1 个元素；
        // 所以，处理的区间变成了 arr[l+1…r]，同时，最小值 + 1
        generateSpecialArray(arr, l + 1, r, value + 1);
        // 4. 都处理好以后，还要把中间的元素和最左边的元素交换回来。
        swap(arr, l, mid);

    }

    /**
     * 交换数组i和j的位置
     */
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }


    /**
     * 随机生成n长的随机数组
     */
    public static Integer[] getRandomArr(int n,int bound){
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int i1 = random.nextInt(bound);
            integers[i] = i1;
        }
        return integers;
    }

}
