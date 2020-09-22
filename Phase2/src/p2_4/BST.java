package p2_4;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yongz
 * @Date 2020/9/18、13:40
 * <p>
 * 二分搜索树:不包含重复的元素的递归实现
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
        root = add(root, e);
    }


    // 添加元素优化
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) < 0)
            node.right = add(node.right, e);
        else if (node.e.compareTo(e) > 0)
            node.left = add(node.left, e);

        return node;
    }

    // 二分搜索树中是否包含e   递归实现
    public boolean contains(E e) {
        return contains(e, root);
    }

    // 二分搜索树中是否包含e   递归实现
    private boolean contains(E e, Node node) {
        if (node == null) return false;

        if (node.e.equals(e))
            return true;
        else if (node.e.compareTo(e) > 0)
            return contains(e, node.right);
        else
            return contains(e, node.left);
    }

    // 二叉树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.e + "\t");

        preOrder(node.left);
        preOrder(node.right);
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.e + "\t");
        inOrder(node.right);
    }


    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + "\t");
    }

    // 层序遍历----广度优先遍历  <非递归实现、通过队列实现>
    public void levelOrder() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node level = queue.remove();
            System.out.print(level.e + "\t");
            if (level.left != null)
                queue.add(level.left);
            if (level.right != null)
                queue.add(level.right);
        }
    }

    // 查找二分搜索树最小值   递归实现
    public E minimum() {
        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 查找二分搜索树最大值   递归实现
    public E maxmum() {
        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");
        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        if (node.right == null)
            return node;
        return maxmum(node.right);
    }

    // 删除二分搜索树最小值
    public E removeMinimum() {
        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");
        E minmum = minimum();
        root = removeMinimum(root);
        return minmum;
    }

    // 删除二分搜索树最小值
    private Node removeMinimum(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;//gc 回收node
            size--;
            return right;
        }
        node.left = removeMinimum(node.left);
        return node;
    }

    // 删除二分搜索树最大值
    public E removeMaxmum() {
        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");
        E minmum = minimum();
        root = removeMaxmum(root);
        return minmum;
    }

    // 删除二分搜索树最大值
    private Node removeMaxmum(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;//gc 回收node
            size--;
            return left;
        }
        node.right = removeMaxmum(node.right);
        return node;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuffer sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }

        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private static String generateDepthString(int depth) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

}
