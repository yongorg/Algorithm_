package p2_4;

/**
 * @Author yongz
 * @Date 2020/9/21、21:58
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E>  bst;

    public BSTSet(){
        bst = new BST<>();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
