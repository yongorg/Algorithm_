package p2_1;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/6、18:25
 */
public class reversePairs {

    public static void main(String[] args) {

    }

    // 解法一：暴力遍历法，遍历所有的数据对
    public int reversePairs1(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] > nums[j]) count++;

        return count;
    }

    // 解法二：归并排序法解决
    public int reversePairs2(int[] nums) {
        return mergeSort(nums  , 0, nums.length-1, Arrays.copyOf(nums, nums.length));
    }

    private int mergeSort(int[] data, int l, int r, int[] copyData) {
        if (l >= r) return 0;

        int mid = (l + r) / 2;   //l+r超出int的最大值就会出问题，
        // 对l到mid进行排序
        int count1 = mergeSort(data, l, mid, copyData);
        // 对mid+1 到 r进行排序
        int count2 = mergeSort(data, mid + 1, r, copyData);
        // 优化1！如果前半个数组[l,mid]的最后一个值[mid]已经比后半截数组[mid+1,r]的第一个值[mid+1]小于等于，说明每必要去合并操作。
        if (data[mid] > data[mid + 1])
            // 合并数组
            return count1 + count2 + merge(data, l, mid, r, copyData);
        return count1 + count2;
    }


    private int merge(int[] data, int l, int mid, int r, int[] copyData) {

        int count = 0;
        // 优化3：内存优化
        System.arraycopy(data, l, copyData, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        for (int x = l; x < r + 1; x++) {
            if (i > mid) {
                data[x] = copyData[j++];
            } else if (j > r) {
                data[x] = copyData[i++];
            } else if (copyData[i] <= copyData[j]) {
                data[x] = copyData[i++];
            } else {
                count += mid - i + 1;
                data[x] = copyData[j++];
            }
        }
        return count;
    }


}
