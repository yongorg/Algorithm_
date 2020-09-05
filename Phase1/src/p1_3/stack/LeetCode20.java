package p1_3.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author yongz
 * @Date 2020/8/29、18:02
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class LeetCode20 {


    public static void main(String[] args) {

        String s = "]";
        LeetCode20 lt20 = new LeetCode20();
        System.out.println(lt20.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        char[] chars = s.toCharArray();
   //        ArrayStack<Character> stack = new ArrayStack<>();
        Stack<Character> stack = new Stack<>();    // java 中已经不推荐使用了，原因该Stack<E> extends Vector<E>是继承关系

        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                switch (aChar) {
                    case ')':
                        if(pop!= '(')  return false;
                        break;
                    case ']':
                        if(pop!= '[')  return false;
                        break;
                    case '}':
                        if(pop!= '{')  return false;
                        break;
                }
            }
        }
   //        return true;     //错了，如果还有值呢
        return stack.isEmpty();
    }
}
