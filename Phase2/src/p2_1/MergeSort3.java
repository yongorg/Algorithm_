package p2_1;


import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/4、23:35
 * 调试断点
 */
public class MergeSort3 {
    public static void main(String[] args) {
        Integer[] data = {2, 1, 7, 8, 4, 3, 2, 5};
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static <E extends Comparable> void sort(E[] data) {
        mergeSort(data, 0, data.length - 1,0);
    }

    private static <E extends Comparable> void mergeSort(E[] data, int l, int r, int depth) {
        // 生成深度字符串
        String depthString = generateDepthString(depth);

        // 打印当前 sort 处理的数组区间信息
        System.out.print(depthString);
        System.out.println(String.format("mergesort arr[%d, %d]", l, r));
        if (l >= r) return;

        int mid = (l + r) / 2;   //l+r超出int的最大值就会出问题，

        // 打印这次 merge 要处理的区间范围
        System.out.print(depthString);
        System.out.println(String.format("merge arr[%d, %d] and arr[%d, %d]", l, mid, mid + 1, r));

        // 对l到mid进行排序
        mergeSort(data, l, mid,  depth+1);
        // 打印 merge 后的数组
        System.out.print(depthString);
        System.out.println(String.format("after mergesort arr[%d, %d] :", l, r));
        // 对mid+1 到 r进行排序
        mergeSort(data, mid + 1, r,  depth+1);
        // 打印 merge 后的数组
        System.out.print(depthString);
        System.out.println(String.format("after mergesort arr[%d, %d] :", l, r));

        // 合并数组
        merge(data, l, mid, r);
        // 打印 merge 后的数组
        System.out.print(depthString);
        System.out.println(String.format("after mergesort arr[%d, %d] :", l, r));

    }


    private static <E extends Comparable> void merge(E[] data, int l, int mid, int r) {

        E[] copyData = Arrays.copyOfRange(data, l, r + 1);

        int i = l;
        int j = mid + 1;
        for (int x = l; x < r + 1; x++) {
            if (i > mid)
                data[x] = copyData[j++ - l];
            else if (j > r)
                data[x] = copyData[i++ - l];
            else
                data[x] = copyData[i - l].compareTo(copyData[j - l]) <= 0 ? copyData[i++ - l] : copyData[j++ - l];

        }
    }

    private static String generateDepthString(int depth) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

}
