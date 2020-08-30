package p1_3.queue;

import p1_3.array.Array;

/**
 * @Author yongz
 * @Date 2020/8/29、21:57
 */
public class ArrayQueue<E> implements  Queue <E>{
    private Array<E> array;

    public ArrayQueue(int capacity){
        this.array= new Array<>(capacity);
    }

    public ArrayQueue(){
        this.array= new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
       return array.removeFrist();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Queue: ");
        sb.append("front [");

        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if ( i != array.getSize()-1)
                sb.append(", ");
        }

        sb.append("] tail");

        return sb.toString();
    }
}
