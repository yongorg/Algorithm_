package p1_4.linkedlist;

import p1_3.stack.Stack;

/**
 * @Author yongz
 * @Date 2020/8/30、17:25
 * 使用链表实现栈
 */
public class LinkedListStack<E> implements Stack <E> {
    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList =  new LinkedList<E>();
    }


    @Override
    public void push(E e) {
//        linkedList.addLast(e); //由于上面上述链表的实现，若把栈顶设置为last，这种性能低
        linkedList.addFrist(e);
    }

    @Override
    public E pop() {
//        return linkedList.removeLast(); //由于上面上述链表的实现，若把栈顶设置为last，这种性能低
        return linkedList.removeFrist();
    }

    @Override
    public E peek() {
        return linkedList.getFrist();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Stack : Top[");
        sb.append(linkedList);
        sb.append("]");
        return sb.toString();
    }
}
