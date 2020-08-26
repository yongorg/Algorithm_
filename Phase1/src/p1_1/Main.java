package p1_1;

import com.sun.jmx.snmp.agent.SnmpMibOid;
import common.ArrayGenerator;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author yongz
 * @Date 2020/8/25、11:36
 */
public class Main {

    public static void main(String[] args) {
        int[] dataSize = {100000, 1000000};

        for (int n : dataSize) {
            Integer[] datas = ArrayGenerator.getOrderArr(n);

            long start = System.nanoTime();
            for (int i = 0; i < 100; i++) { //多次测量
                LeanrSearch.search(datas, n);//查找不到的最坏情况测试性能
            }
            long end = System.nanoTime();

            double time = (end - start) / 1000000000.0;
            // 当数组长度为n时，执行100次所需要的时间
            System.out.println("n = " + n + "\t 100次：time = " + time + "s");
        }

    }


}
