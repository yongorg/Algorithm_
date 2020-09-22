package p2_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * @Author yongz
 * @Date 2020/9/18、13:40
 * <p>
 * 二分搜索树:不包含重复的元素的非递归实现
 */
public class BST2<E extends Comparable<E>> {

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


    public BST2() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 二分搜索树添加元素的   非递归实现
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }
        Node prev = root;
        while (true) {
            if (prev.e.compareTo(e) < 0) {
                if (prev.right != null)
                    prev = prev.right;
                else {
                    prev.right = new Node(e);
                    size++;
                    return;
                }

            } else if (prev.e.compareTo(e) > 0) {
                if (prev.left != null)
                    prev = prev.left;
                else {
                    prev.left = new Node(e);
                    size++;
                    return;
                }
            } else
                return;


        }
    }

    // 二分搜索树中是否包含e   非递归实现
    public boolean contains(E e) {
        Node cul = root;
        while (cul != null) {
            if (cul.e.equals(e))
                return true;
            if (cul.e.compareTo(e) > 0)
                cul = cul.right;
            else// if (cul.e.compareTo(e)<0)
                cul = cul.left;
        }
        return false;
    }

    // 二叉树的前序遍历   通过栈的非递归实现
    public void preOrder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cul = stack.pop();
            System.out.print(cul.e + "\t");
            if (cul.right != null)
                stack.push(cul.right);
            if (cul.left != null)
                stack.push(cul.left);
        }
    }

    // 二叉树的中序遍历   通过栈的非递归实现
    public void inOrder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node left = root.left;
        while (left != null) {
            stack.push(left);
            left = left.left;
        }

        // 先把左边全部节点压入栈
        while (!stack.isEmpty()) {
            Node inCul = stack.pop();
            System.out.print(inCul.e + "\t");
            if (inCul.right != null) {
                stack.push(inCul.right);
                Node temp = inCul.right.left;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }

    }

    // 二叉树的后序遍历   通过栈的非递归实现
    public void postOrder() {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node left = root.left;
        // 先把左边全部节点压入栈
        while (left != null) {
            stack.push(left);
            left = left.left;
        }
        while (!stack.isEmpty()) {
            Node inCul = stack.pop();
            if (inCul.right != null) {
                stack.push(new Node(inCul.e));//和中序遍历不同的是，这里再把当前incul压入栈
                stack.push(inCul.right);
                Node temp = inCul.right.left;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            } else {
                System.out.print(inCul.e + "\t");
            }
        }

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

    // 查找二分搜索树最小值   非递归实现
    public E minimum() {
        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");
        Node cul = root;
        while (cul.left != null) {
            cul = cul.left;
        }
        return cul.e;
    }

    // 查找二分搜索树最大值   非递归实现
    public E maxmum() {
        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");
        Node cul = root;
        while (cul.right != null) {
            cul = cul.right;
        }
        return cul.e;
    }

    // 删除二分搜索树最小值
    public E removeMinimum() {

        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");

        if (root.left == null){
            E result = root.e;
            root = root.right;
            return result;
        }

        Node cur = root;
        Node preCur = null;

        while (cur.left != null) {
            preCur = cur;
            cur = cur.left;
        }
        Node right = cur.right;
        preCur.left = right;
        cur.right = null;
        return cur.e;
    }


    // 删除二分搜索树最大值
    public E removeMaxmum() {
        if (root == null)
            throw new IllegalArgumentException(" BST is empty!");

        if (root.right == null){
            E result = root.e;
            root = root.left;
            return result;
        }
        Node cur = root;
        Node preCur = null;

        while (cur.right != null) {
            preCur =cur;
            cur = preCur.right;
        }
        Node left = cur.left;
        preCur.right=left;
        cur.left=null;  //gc

        return cur.e;
    }

}
