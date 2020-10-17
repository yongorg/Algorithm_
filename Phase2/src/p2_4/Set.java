package p2_4;


import java.util.HashSet;

/**
 * // 集合
 *
 * 典型应用：客户统计，词汇量统计
 *
 */
public interface Set<E> {

    void add(E e); // 注：不能添加重复元素

    void remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();


}
