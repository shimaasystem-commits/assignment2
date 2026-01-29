package src;

import java.util.Stack;

public class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tempStack = new Stack<>();

        while (!input.isEmpty()) {
            // سحب عنصر من المكدس الأصلي
            int current = input.pop();

            // نقل العناصر من المكدس المؤقت إذا كانت أكبر
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                input.push(tempStack.pop());
            }

            // إضافة العنصر الحالي إلى المكان الصحيح
            tempStack.push(current);
        }

        // نقل العناصر مرة أخرى إلى المكدس الأصلي (اختياري)
        while (!tempStack.isEmpty()) {
            input.push(tempStack.pop());
        }

        return input; // أو إرجاع tempStack إذا أردنا الترتيب الصاعد
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original stack: " + stack);
        Stack<Integer> sorted = sortStack(stack);
        System.out.println("Sorted stack: " + sorted);
    }
}