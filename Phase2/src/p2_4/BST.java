package p2_4;

/**
 * @Author yongz
 * @Date 2020/9/18、13:40
 * <p>
 * 二分搜索树:不包含重复的元素
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root; // 根节点
    private int size;


    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 二分搜索树添加元素
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if (node.e.equals(e)) {
            return;
        } else if (node.e.compareTo(e) > 0) {
            if (node.right == null) {
                node.right = new Node(e);
                size++;
                return;
            } else
                add(node.right, e);

        } else {
            if (node.left == null) {
                node.left = new Node(e);
                size++;
                return;
            } else
                add(node.left, e);

        }
    }

}
