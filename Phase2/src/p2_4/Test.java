package p2_4;


/**
 * @Author yongz
 * @Date 2020/9/18、14:34
 */
public class Test {

    public static void main(String[] args) {
        int[] test = {5, 3, 6, 8, 4, 2};

        BST2 ebst = new BST2();
        for (int i = 0; i < test.length; i++) {
            ebst.add(test[i]);
        }

        System.out.println(ebst.minimum() );
        ebst.inOrder();
        System.out.println();
        System.out.println(ebst.removeMinimum());
        ebst.inOrder();
    }
    public static void main2 (String[] args) {
        int[] test = {5, 3, 6, 8, 4, 2};

        BST ebst = new BST();
        for (int i = 0; i < test.length; i++) {
            ebst.add(test[i]);
            break;
        }

        System.out.println(ebst.maxmum());
        ebst.inOrder();
        System.out.println();
        System.out.println(ebst.removeMaxmum());
        ebst.inOrder();

    }

}
