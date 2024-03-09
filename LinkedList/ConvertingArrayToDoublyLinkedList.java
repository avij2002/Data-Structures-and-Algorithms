package LinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
};

public class ConvertingArrayToDoublyLinkedList {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        ConvertingArrayToDoublyLinkedList convertingArrayToDoublyLinkedList = new ConvertingArrayToDoublyLinkedList();

        // Convert array to Basic LinkedList
        Node head = convertingArrayToDoublyLinkedList.convertArrayToDoublyLinkedList(arr);

        // Print DoublyLinkedList
        convertingArrayToDoublyLinkedList.printDoublyLinkedList(head);
    }

    public Node convertArrayToDoublyLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node prevNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            n.prev = prevNode;
            prevNode.next = n;
            prevNode = n;
        }
        return head;
    }

    public void printDoublyLinkedList(Node head) {
        Node tail = null;
        Node temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.data + "->");
            } else {
                tail = temp;
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
        System.out.println("Doubly Linked List");
        while (tail != null) {
            if (tail.prev != null) {
                System.out.print(tail.data + "->");
            } else {
                System.out.println(tail.data);
            }
            tail = tail.prev;
        }
    }
}
