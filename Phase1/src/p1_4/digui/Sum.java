package p1_4.digui;

/**
 * @Author yongz
 * @Date 2020/8/30、22:08
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

       // 计算arr[l...n]这个区间内所有数字的和
    public static int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

}
