package p2_3;

import util.ArrayGenerator;

/**
 * @Author yongz
 * @Date 2020/9/17、17:00
 */
public class BinarySearch2 {

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] orderArr = ArrayGenerator.getOrderArr(n);

        System.out.println(search(orderArr, n));
    }

    // 非递归实现
    public static <E extends Comparable<E>> int search(E[] arrays, E target) {
        int l = 0;
        int r = arrays.length - 1;
        while (true) {
            if (l > r) return -1;
            int mid = l + (r - l) / 2;
            if (arrays[mid].compareTo(target) == 0) return mid;
            else if (arrays[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }

    public static int search(int[] arrays, int target) {
        int l = 0;
        int r = arrays.length - 1;
        while (true) {
            if (l > r) return -1;

            int mid = l + (r - l) / 2;
            if (arrays[mid] == target) return mid;
            else if (arrays[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }



}
