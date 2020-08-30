package p1_3.array;


/**
 * @Author yongz
 * @Date 2020/8/13、21:03
 * <p>
 * 自己二次封装的数组类：动态数组
 */
public class Array3 {

    private int[] data;  // 存放数据
    private int size; //


    // 传入capacity容量初始化数组
    public Array3(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参构造数组，默认容量为10.
    public Array3() {
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
    public void addLast(int e) {
        add(size, e);
    }

    // 向数组末尾添加一个元素
    public void addFrist(int e) {
        add(0, e);
    }

    // 向数组末尾添加一个元素
    public void add(int index, int e) {
        if (size == data.length) expandCapacity(); //数组扩容
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Add failed， index is illegal");

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    //获取数组中索引为index的参数
    public int get(int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Get failed， index is illegal");

        return data[index];
    }


    //根据index修改数组中参数
    public void set(int index, int e) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Set failed， index is illegal");

        this.data[index] = e;
    }


    // 根据索引删除参数
    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Set failed， index is illegal");
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void removeFrist(int index) {
        remove(0);
    }

    public void removeLast(int index) {
        remove(size - 1);
    }

    public boolean removeElement(int e) {
        int i = find(e);
        if (i >= 0) {
            remove(i);
            return true;
        }
        return false;
    }

    public void removeAllElement(int e) {
        while (removeElement(e));
    }


    // 判断是否包含参数e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++)
            if (e == data[i]) return true;
        return false;
    }

    // 查找元素的索引
    public int find(int e) {
        for (int i = 0; i < size; i++)
            if (e == data[i]) return i;
        return -1;
    }

    // 数组扩容,扩容1.5倍
    private void expandCapacity() {
        int[] temp = this.data;
        this.data = new int[data.length+data.length/2 ];
        for (int i = 0; i < temp.length; i++)
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
}
