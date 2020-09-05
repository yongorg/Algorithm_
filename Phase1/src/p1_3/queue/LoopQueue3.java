package p1_3.queue;


/**
 * 维护三个变量，两个指针记录front、tail  ;size记录长度
 */
public class LoopQueue3<E> implements Queue<E> {
    private E[] data;
    private int front = 0, tail = 0;   //队首与队尾的索引
    private int size = 0;

    public LoopQueue3(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue3() {
        this(11);
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    private int getCapacity() {
        return data.length - 1;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue .");
        E temp = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (getSize() < data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return temp;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return front == tail;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Queue : size=%d , capacity = %d \n", size, data.length - 1));
        sb.append("front [");

        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
