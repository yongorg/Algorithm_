package p1_4.linkedlist;

/**
 * 递归实现链表的crud
 *
 * @param <E>
 */
public class LinkedListRecursion<E> {
       // 节点
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

       //    private Node head;
    private Node dummyHead;    //虚拟头节点
    private int size;

    public LinkedListRecursion() {
        dummyHead = new Node(null, null);
        size = 0;
    }

       // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

       // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

       // 在链表头添加新元素
    public void addFrist(E e) {
        add(0, e);
    }


       // 在链表头添加新元素，在链表中不是一个常用操作，练习用
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");


        Node LastIndexNode = getLastIndexNode(dummyHead, index, 0);
        Node del = LastIndexNode.next;
        LastIndexNode.next = new Node(e, del);
        size++;


    }

    private Node getLastIndexNode(Node dummyHead, int index, int i) {
        if (i == index)
            return dummyHead;
        return getLastIndexNode(dummyHead, index, i + 1).next;
    }


       // 在链表尾部添加
    public void addLast(E e) {
        add(size, e);
    }

       // 根据index获取链表的节点元素，在链表中不是一个常用操作，练习用
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        return getLastIndexNode(dummyHead, index, 0).next.e;
    }

       // 获取第一个元素
    public E getFrist() {

        return get(0);
    }

       // 获取最后一个元素
    public E getLast() {
        return get(size - 1);
    }

       // 修改链表的第index个位置的元素e。在链表中不是一个常用操作，练习用
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node indexNode = getLastIndexNode(dummyHead, index, 0).next;
        indexNode.e = e;
    }

    public void setFrist(E e) {
        set(0, e);
    }

    public void setLast(E e) {


        set(size - 1, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node lastIndex = getLastIndexNode(dummyHead, index , 0);
        Node thisIndex = lastIndex.next;
        lastIndex.next = lastIndex.next.next;
        thisIndex.next = null;
        size--;
        return thisIndex.e;
    }

    public E removeFrist() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

       // 查找链表中是否有元素e
    public boolean contains(E e) {
           // size 遍历法
   //        Node cur = dummyHead.next;
   //        for (int i = 0; i < size; i++) {
   //            if (e.equals(cur.e)) return true;
   //            cur = cur.next;
   //        }
   //        return false;
           //链表的特性遍历
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("LinkedList: ");

        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
