package p1_3.queue;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/8/29、22:03
 */
public class Main {

    // 测试使用q运用opCount个enqueue和dequeue操作所需时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opConut) {
        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opConut; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opConut; i++) {
            q.dequeue();
        }

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount= 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue3<Integer> loopQueue3 = new LoopQueue3<>();

        double timeArray = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue,time="+timeArray+"s");

        double timeLoop = testQueue(loopQueue3, opCount);
        System.out.println("LoopQueue,time="+timeLoop+"s");
    }
}
