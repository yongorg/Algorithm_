package p2_1;


/**
 * @Author yongz
 * @Date 2020/8/13、21:03
 * <p>
 * 自己二次封装的泛型数组类：动态数组,
 */
public class Array<E> {

    private E[] data;     // 存放数据
    private int size;    //


    // 传入capacity容量初始化数组
    public Array(int capacity) {
        //        data = new E[capacity];
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参构造数组，默认容量为10.
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return this.size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组末尾添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    // 向数组末尾添加一个元素
    public void addFrist(E e) {
        add(0, e);
    }


    // 向数组末尾添加一个元素
    public void add(int index, E e) {
        if (size == data.length) resize(data.length + data.length / 2);    //数组扩容
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Add failed， index is illegal");

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    //获取数组中索引为index的参数
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Get failed， index is illegal");

        return data[index];
    }

    public E getLast() {
        return data[size - 1];
    }


    public E getFirst() {
        return data[0];
    }

    //根据index修改数组中参数
    public void set(int index, E e) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Set failed， index is illegal");

        this.data[index] = e;
    }


    // 根据索引删除参数
    public E remove(int index) {
        E temp = data[index];
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Set failed， index is illegal");
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        // 防止复杂度的震荡
        if (size == data.length / 4 && data.length / 2 > 5)
            resize(data.length / 2);
        // data[size] = null;

        return temp;
    }

    public E removeFrist() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int i = find(e);
        if (i >= 0) {
            remove(i);
            return true;
        }
        return false;
    }

    public void removeAllElement(E e) {
        while (removeElement(e)) ;
    }


    // 判断是否包含参数e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e)) return true;
        return false;
    }

    // 查找元素的索引
    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e)) return i;
        return -1;
    }

    // 数组扩容,扩容1.5倍
    private void expandCapacity() {
        E[] temp = this.data;
        this.data = (E[]) new Object[data.length + data.length / 2];
        for (int i = 0; i < temp.length; i++)
            this.data[i] = temp[i];
    }

    //  数组的扩容缩容
    private void resize(int capacity) {
        E[] temp = this.data;
        this.data = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            this.data[i] = temp[i];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) sb.append(",");
        }

        return "Array=["
                + sb.toString() +
                ']';
    }


    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("index is illegal");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;

    }
}
