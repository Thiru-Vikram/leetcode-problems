package LinkedList;

import java.util.HashSet;

class Node {

    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

// 141. Linked List Cycle
public class Leetcode141 {

    // brute - force
    // tc is o(n) and sc is o(n).
    public boolean hasCycle(Node head) {
        HashSet<Node> visited = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true; // Found a cycle
            }
            visited.add(current);
            current = current.next;
        }
        return false; // No cycle
    }

    // optimal
    // tc is o(n) and o(1).
    public boolean hasCycle2(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
