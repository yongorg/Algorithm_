package p1_3.stack;

import p1_3.array.Array;

/**
 * @Author yongz
 * @Date 2020/8/29、17:43
 * <p>
 * 使用上面我们实现的动态数组，实现栈
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    public int getCapacity() {
        return array.getCapacity();
    }

    // 进栈
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    // 出栈
    @Override
    public E pop() {
        return array.removeLast();
    }

    // 看一下栈顶的元素
    @Override
    public E peek() {
        return array.getLast();
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Stack :");
        sb.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1)
                sb.append(", ");
        }
        sb.append("] top");

        return sb.toString();
    }
}
