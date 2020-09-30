package p2_1;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/9/28、15:35
 */
public class Test {

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        System.out.println(maxHeap);
        int[] test = new int[n];
        for (int i = 0; i < n; i++){
            test[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++){
            if (test[i] > test[i-1])
                System.out.println("----");
        }
    }
}
