package p1_3.stack;

public interface Stack<E> {
    void push(E e);  //进栈

    E pop(); //出栈

    E peek();//看一眼栈顶

    int getSize();//栈的size

    boolean isEmpty();//是否为空
}
