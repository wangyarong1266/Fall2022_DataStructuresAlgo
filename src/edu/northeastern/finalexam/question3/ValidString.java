package edu.northeastern.finalexam.question3;

import javax.xml.stream.events.Characters;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidString {

    public static void main(String[] args) {
        ValidString sol = new ValidString();
        System.out.println(sol.removeParentheses("lee(t(c)o)de)"));
        System.out.println(sol.removeParentheses("a)b(c)d"));
        System.out.println(sol.removeParentheses("))(("));
    }

    /* The time complexity is O(N) where N is the length of the input string. */
    public String removeParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> toBeRemoved = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                continue;
            }

            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if (stack.isEmpty()) {
                toBeRemoved.add(i);
                continue;
            }

            stack.pop();
        }

        while (!stack.isEmpty()) {
            toBeRemoved.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (toBeRemoved.contains(i)) {
                continue;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
