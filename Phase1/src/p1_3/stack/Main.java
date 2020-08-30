package p1_3.stack;

import javax.lang.model.element.VariableElement;

/**
 * @Author yongz
 * @Date 2020/8/29、17:54
 */
public class Main {

    public static void main(String[] args) {

        ArrayStack<Object> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);

    }
}
