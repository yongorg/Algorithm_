package p1_3.queue;



import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/8/29、22:29
 */
public class LoopQueue2<E> implements Queue<E> {

    private E[] data;

    private int front = 0, tail = 0;//队首与队尾的索引

    public LoopQueue2(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public LoopQueue2() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % (data.length - 1) == front) {
//            throw new IndexOutOfBoundsException("队列已满");
            // 扩容
            resize((int) ((data.length - 1) * 1.5));
            data[tail++] = e;
        } else if (tail == data.length - 1 && front > 1) {
            data[tail] = e;
            tail = 0;
        } else if (tail < data.length - 1)
            data[tail++] = e;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        int j = 0;
        if (front > tail) {
            for (int i = front; i < data.length; i++) {
                newData[j++] = data[i];
            }
            for (int i = 0; i < tail; i++) {
                newData[j++] = data[i];
            }
        } else if ((front < tail)) {
            for (int i = front; i < tail; i++) {
                newData[j++] = data[i];
            }
        }
        front = 0;
        tail = j;
        this.data = newData;
    }

    @Override
    public E dequeue() {
        if (front == tail)
            throw new IllegalArgumentException("cannot dequeue from an empty queue .");
        E temp = data[front];
        data[front++] = null;
        if (front == data.length)
            front = 0;

        // 缩容
        if (getSize()< data.length/4 && data.length/2>10)
            resize(data.length/2);
        return temp;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw  new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public int getSize() {
        if (tail > front) return tail - front;
        else if (tail < front) return tail + data.length - front ;
        else return 0;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
