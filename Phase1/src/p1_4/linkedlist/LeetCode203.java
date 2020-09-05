package p1_4.linkedlist;

/**
 * @Author yongz
 * @Date 2020/8/30、20:32
 */
public class LeetCode203 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 4, 6, 6, 7};
        ListNode listNode1 = new ListNode(arr);


        ListNode listNode = new LeetCode203().removeElements(listNode1, 6,0);
        System.out.println(listNode);
    }


    // 递归解决
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("call : remove" + val + "in" + head);
        if (head == null){
            System.out.print(depthString);
            System.out.println("Return:" + head);
            return null;
        }
        head.next = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove" + val + ": " + head);
        return head.val == val ? head.next : head;

    }

    private String generateDepthString(int depth) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}