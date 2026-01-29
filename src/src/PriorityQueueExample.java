package src;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    // استخدام PriorityQueue المدمجة في Java
    public static void testPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // إضافة عناصر
        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(5);
        pq.add(15);

        System.out.println("Priority Queue elements (natural ordering - smallest first):");

        // إزالة العناصر (ستكون مرتبة من الأصغر إلى الأكبر)
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }

    // تنفيذ مخصص لطابور الأولوية
    static class CustomPriorityQueue {
        private int[] heap;
        private int size;
        private int capacity;

        public CustomPriorityQueue(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }

        public void enqueue(int value) {
            if (size == capacity) {
                System.out.println("Queue is full!");
                return;
            }

            heap[size] = value;
            int current = size;
            size++;

            // تعديل Heap لأسفل
            while (current > 0 && heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }

            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapify(0);

            return min;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void heapify(int index) {
            int smallest = index;
            int left = leftChild(index);
            int right = rightChild(index);

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                heapify(smallest);
            }
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int leftChild(int i) { return 2 * i + 1; }
        private int rightChild(int i) { return 2 * i + 2; }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Using Java's PriorityQueue ===");
        testPriorityQueue();

        System.out.println("\n\n=== Using Custom PriorityQueue ===");
        CustomPriorityQueue cpq = new CustomPriorityQueue(10);
        cpq.enqueue(30);
        cpq.enqueue(10);
        cpq.enqueue(20);
        cpq.enqueue(5);
        cpq.enqueue(15);

        System.out.println("Dequeueing elements (smallest first):");
        while (!cpq.isEmpty()) {
            System.out.print(cpq.dequeue() + " ");
        }
    }
}