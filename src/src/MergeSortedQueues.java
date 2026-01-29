package src;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedQueues {
    public static Queue<Integer> mergeQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.offer(q1.poll());
            } else {
                result.offer(q2.poll());
            }
        }

        // إضافة العناصر المتبقية من q1
        while (!q1.isEmpty()) {
            result.offer(q1.poll());
        }

        // إضافة العناصر المتبقية من q2
        while (!q2.isEmpty()) {
            result.offer(q2.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(1);
        queue1.offer(3);
        queue1.offer(5);
        queue1.offer(7);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.offer(2);
        queue2.offer(4);
        queue2.offer(6);
        queue2.offer(8);

        System.out.println("Queue 1: " + queue1);
        System.out.println("Queue 2: " + queue2);

        Queue<Integer> merged = mergeQueues(queue1, queue2);
        System.out.println("Merged queue: " + merged);
    }
}