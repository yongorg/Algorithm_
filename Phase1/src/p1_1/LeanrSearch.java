package p1_1;

/**
 * 线性查找法
 *
 * @Author yongz
 * @Date 2020/8/25、0:03
 */
public class LeanrSearch<E> {


    /**
     * 线性查找法
     *
     * @param arrays
     * @param target
     * @return
     */
    public static <E> int search (E[] arrays, E target) {
        for (int i = 0; i < arrays.length; i++)
            if (arrays[i].equals(target)) return i; // 注：类对比采用equals
        return -1;
    }
}
