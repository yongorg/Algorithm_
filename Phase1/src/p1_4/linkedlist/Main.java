package p1_4.linkedlist;


import p1_3.stack.ArrayStack;
import p1_3.stack.Stack;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/8/30、15:53
 */
public class Main {

    // 测试ArrayStack与LinkedListStack，所需时间，单位：秒
    public static void test1(){
        int opCount= 10000000;
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedListStack = new LinkedListStack<>();

        double timeArray = testStack(arrayStack, opCount);
        System.out.println("arrayStack,time="+timeArray+"s");

        double timeLoop = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack,time="+timeLoop+"s");
    }
    // 测试ArrayStack与LinkedListStack，所需时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opConut) {
        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opConut; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opConut; i++) {
            stack.pop();
        }

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }


    public static void main(String[] args) {
        test1();
    }

}
