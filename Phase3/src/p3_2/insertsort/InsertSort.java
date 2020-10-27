package p3_2.insertsort;



import uitl.ArrayGenerator;
import uitl.SortInterface;

/**
 * @Author yongz
 * @Date 2020/8/25、16:17
 */
public class InsertSort implements SortInterface {

    @Override
    public <E extends Comparable<E>> void sort(E[] list) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            E temp = list[i];    // 记录当前数
            int j = i;   //记录合适的位置
            for ( j = i; j > 0 && temp.compareTo(list[j - 1]) < 0; j--)
                list[j] = list[j-1];
            list[j] = temp;
        }
    }
}
