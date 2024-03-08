package LinkedList;

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
}

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        DeleteNodeInLinkedList deleteNodeInLinkedList = new DeleteNodeInLinkedList();

        // Converting given Array To LinkedList
        Node head = deleteNodeInLinkedList.convertArrayToLinkedList(arr);
        System.out.println("Initial Linked List");
        // Print LinkedList
        deleteNodeInLinkedList.printLinkedList(head);

        // Delete Node from the head position
        System.out.println("Delete Node from the head position");
        head = deleteNodeInLinkedList.deleteNodeFromHeadPosition(head);
        // Print LinkedList
        deleteNodeInLinkedList.printLinkedList(head);

        // Delete Node from the last position
        System.out.println("Delete Node from the last position");
        head = deleteNodeInLinkedList.deleteNodeFromLastPosition(head);
        // Print LinkedList
        deleteNodeInLinkedList.printLinkedList(head);

        // Delete Node from a given position
        System.out.println("Delete Node from a given position");
        head = deleteNodeInLinkedList.deleteNodeFromGivenPosition(head, 5);
        // Print LinkedList
        deleteNodeInLinkedList.printLinkedList(head);

        // Delete Node Before a given value
        System.out.println("Delete Node Before a given value");
        head = deleteNodeInLinkedList.deleteNodeBeforeGivenValue(head, 7);
        // Print LinkedList
        deleteNodeInLinkedList.printLinkedList(head);

        // Delete Node After a given value
        System.out.println("Delete Node After a given value");
        head = deleteNodeInLinkedList.deleteNodeAfterGivenValue(head, 2);
        // Print LinkedList
        deleteNodeInLinkedList.printLinkedList(head);

    }

    Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node nextNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            nextNode.next = temp;
            nextNode = temp;
        }
        return head;
    }

    void printLinkedList(Node head) {
        if (head == null)
            System.out.println("Nothing to print :: LinkedList is empty");
        Node temp = head;
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.data + " -> ");
            else
                System.out.println(temp.data);
            temp = temp.next;
        }
    }

    Node deleteNodeFromHeadPosition(Node head) {
        if (head == null) {
            return head;
        }
        return head.next;
    }

    Node deleteNodeFromLastPosition(Node head) {
        if (head == null)
            return null;
        if (head.next == null) {
            return deleteNodeFromHeadPosition(head);
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    Node deleteNodeFromGivenPosition(Node head, int position) {
        if (head == null)
            return null;
        if (position == 1) {
            return deleteNodeFromHeadPosition(head);
        }
        Node temp = head;
        int count = 1;
        while (temp != null) {
            if (count == position - 1) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }

    Node deleteNodeBeforeGivenValue(Node head, int value) {
        if (head.data == value)
            return head;
        if (head.next.data == value) {
            return deleteNodeFromHeadPosition(head);
        }
        Node temp = head;
        Node prev = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    Node deleteNodeAfterGivenValue(Node head, int value) {
        if (head.data == value) {
            head.next = head.next.next;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == value) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}