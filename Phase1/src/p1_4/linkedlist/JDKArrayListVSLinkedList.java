package p1_4.linkedlist;

import java.util.*;
import java.util.LinkedList;

/**
 * @Author yongz
 * @Date 2020/9/3、0:18
 */
public class JDKArrayListVSLinkedList {


    public static void main(String[] args) {

    }
    // 测试LinkedList的增删复杂度
    public static void test1(){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 10000; i ++) list.add(0);
        long start = System.nanoTime();
        while(!list.isEmpty()) list.remove(list.size() / 2);
        System.out.println((System.nanoTime() - start) / 1000000000.0 + " s");

        System.out.println();

        list = new LinkedList<>();
        for(int i = 0; i < 100000; i ++) list.add(0);
        start = System.nanoTime();
        while(!list.isEmpty()) list.remove(list.size() / 2);
        System.out.println((System.nanoTime() - start) / 1000000000.0 + " s");
    }


    // 测试LinkedList的动态增删
    public static void test2(){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 10000; i ++) list.add(0);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            iterator.remove();
        }

        List<Object> objects = new ArrayList<>();
    }
}
