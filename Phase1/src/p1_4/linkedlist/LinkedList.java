package p1_4.linkedlist;

/**
 * @Author yongz
 * @Date 2020/8/30、15:14
 */
public class LinkedList<E> {
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
    private Node dummyHead; //虚拟头节点
    private int size;

    public LinkedList() {
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


        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next); // 1行解决
        size++;


    }


    // 在链表尾部添加
    public void addLast(E e) {
        add(size, e);
    }

    // 根据index获取链表的节点元素，在链表中不是一个常用操作，练习用
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
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
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public void setFrist(E e) {
        set(0, e);
    }

    public void setLast(E e) {


        set(size - 1, e);
    }

    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next =null;//gc
        size--;
        return temp.e;
    }

    public E removeFrist(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
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
        while (cur!= null){
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
        while (cur != null){
            sb.append(cur.e);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
