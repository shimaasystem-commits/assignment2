package src;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverseString(String input) {
        Stack<Character> stack = new Stack<>();

        // دفع جميع الأحرف إلى المكدس
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // سحب الأحرف من المكدس (عكس الترتيب)
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String text = "Hello World!";
        String reversed = reverseString(text);
        System.out.println("Original: " + text);
        System.out.println("Reversed: " + reversed);
    }
}