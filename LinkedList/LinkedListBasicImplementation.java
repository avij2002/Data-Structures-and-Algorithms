package LinkedList;

/**
 * LinkedListBasicImplementation
 */
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
};

public class LinkedListBasicImplementation {
    public static void main(String[] args) {
        int val = 3;
        Node linkNode = new Node(val);
        // linkNode.data contains the value of the element
        // linkNode.next will contains the address of the location of the next element
        // linkNode will contain the addess of the current element
        System.out.println("This is the value of the element: " + linkNode.data);
        System.out.println("This is the address of the next element: " + linkNode.next);
        System.out.println("This is the address of the current element: " + linkNode);
    }
}