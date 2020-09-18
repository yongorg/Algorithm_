package p2_3;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/9/17、17:31
 * <p>
 * 查找第k小的值的非递归实现
 */
public class SelectK {
    private static Random rnd = new Random();

    public static void main(String[] args) {

    }

    // 非递归实现
    public int selectK(int[] arr, int k) {

        int l = 0;
        int r = arr.length - 1;
        while (true) {
            if (l > r) throw new RuntimeException("No Solution");
            int p = partition(arr, l, r);
            if (k == p) {
                return arr[p];
            } else if (k < p) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
    }

    private int partition(int[] arr, int l, int r) {

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i] < arr[l])
                i++;

            while (j >= i && arr[j] > arr[l])
                j--;

            if (i >= j) break;

            swap(arr, i, j);

            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
