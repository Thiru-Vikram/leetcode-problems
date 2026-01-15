package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {

    public void minHeap() {

        // Create a min-heap (default behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements (O(log n) time complexity per insertion)
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(15);
        minHeap.add(1);

        // Peek: retrieve the minimum element without removing it (O(1) time)
        System.out.println("Minimum element (peek): " + minHeap.peek()); // Output: 1

        // Poll: retrieve and remove the minimum element (O(log n) time)
        System.out.println("Removed element (poll): " + minHeap.poll()); // Output: 1
        System.out.println("New minimum element (peek): " + minHeap.peek()); // Output: 5

        // Check if the heap is empty
        System.out.println("Is heap empty? " + minHeap.isEmpty());
    }

    public void maxHeap() {
        // Create a Max Heap using PriorityQueue and a reverse order comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert elements
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(5);
        maxHeap.add(50);

        // The peek() method returns the maximum element (the root)
        System.out.println("Maximum element (peek): " + maxHeap.peek()); // Output: 50

        // Extract elements (poll() removes the max element)
        System.out.print("Elements in descending order (poll): ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // Output: 50 30 20 10 5
        }
    }

    public static void main(String[] args) {

    }

}
