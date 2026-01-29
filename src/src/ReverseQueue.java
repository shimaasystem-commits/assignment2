package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // نقل جميع العناصر من الطابور إلى المكدس
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // نقل جميع العناصر من المكدس إلى الطابور (بالترتيب المعكوس)
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println("Original queue: " + queue);
        Queue<Integer> reversed = reverseQueue(queue);
        System.out.println("Reversed queue: " + reversed);
    }
}