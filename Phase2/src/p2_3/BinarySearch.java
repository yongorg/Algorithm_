package p2_3;

import util.ArrayGenerator;

/**
 * @Author yongz
 * @Date 2020/9/17、17:00
 */
public class BinarySearch {

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] orderArr = ArrayGenerator.getOrderArr(n);

        System.out.println(search(orderArr, n));
    }

    public static <E extends Comparable<E>> int search(E[] arrays, E target) {
        return binarySearch(arrays, 0, arrays.length - 1, target);
    }


    private static <E extends Comparable<E>> int binarySearch(E[] arrays, int l, int r, E target) {
        if (l > r) return -1;

        int mid = l + (r - l) / 2;
        if (arrays[mid].compareTo(target) == 0)
            return mid;
        else if (arrays[mid].compareTo(target) > 0)
            return binarySearch(arrays, l, mid - 1, target);
        else
            return binarySearch(arrays, mid + 1, r, target);
    }



    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private  int binarySearch(int[] arrays, int l, int r, int target) {
        if (l > r) return -1;

        int mid = l + (r - l) / 2;
        if (arrays[mid]==target)
            return mid;
        else if (arrays[mid] >target)
            return binarySearch(arrays, l, mid - 1, target);
        else
            return binarySearch(arrays, mid + 1, r, target);
    }


    public static int upper(int[] arrays, int target) {
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
