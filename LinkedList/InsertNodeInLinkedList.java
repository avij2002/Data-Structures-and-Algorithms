package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertNodeInLinkedList {
    public static void main(String[] args) {
        int arr[] = { 2, 6, 5, 23, 69, 56, 45 };
        InsertNodeInLinkedList insertNodeInLinkedList = new InsertNodeInLinkedList();
        // Converting given Array To LinkedList
        Node head = insertNodeInLinkedList.convertArrayToLinkedList(arr);

        System.out.println("Initial Linked List");
        // Print LinkedList
        insertNodeInLinkedList.printLinkedList(head);

        // Insert at head
        head = insertNodeInLinkedList.insertNodeAtHeadPosition(head, 1);
        System.out.println("After Inserting at Head Position");
        // Print LinkedList
        insertNodeInLinkedList.printLinkedList(head);

        // Insert at a given position
        head = insertNodeInLinkedList.insertNodeAtGivenPosition(head, 99, 2);
        System.out.println("After Inserting at a given Position : 2");
        // Print LinkedList
        insertNodeInLinkedList.printLinkedList(head);

        // Insert at last position
        head = insertNodeInLinkedList.insertNodeAtLastPosition(head, 9999);
        System.out.println("After Inserting at a Last Position");
        // Print LinkedList
        insertNodeInLinkedList.printLinkedList(head);

        // Inserting Before a Given value
        head = insertNodeInLinkedList.insertBeforeGivenValue(head, 68, 69);
        System.out.println("Inserting Before a Given value");
        // Print LinkedList
        insertNodeInLinkedList.printLinkedList(head);

        // Inserting After a Given value
        head = insertNodeInLinkedList.insertNodeAfterGivenPosition(head, 70, 69);
        System.out.println("Inserting After a Given value");
        // Print LinkedList
        insertNodeInLinkedList.printLinkedList(head);
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

    public Node insertNodeAtHeadPosition(Node head, int value) {
        return new Node(value, head);
    }

    public Node insertNodeAtGivenPosition(Node head, int value, int position) {
        if (head == null) {
            if (position == 1) {
                return insertNodeAtHeadPosition(head, value);
            } else {
                return head;
            }
        } else {
            Node temp = head;
            int count = 1;
            while (temp != null) {
                if (count == position - 1) {
                    Node newNode = new Node(value, temp.next);
                    temp.next = newNode;
                    break;
                } else {
                    temp = temp.next;
                    count++;
                }
            }
        }
        return head;
    }

    public Node insertNodeAtLastPosition(Node head, int value) {
        if (head == null) {
            return insertNodeAtHeadPosition(head, value);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(value, null);
        temp.next = newNode;
        return head;
    }

    public Node insertBeforeGivenValue(Node head, int value, int givenValue) {
        if (head == null)
            return head;
        if (head.data == givenValue) {
            return insertNodeAtHeadPosition(head, value);
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data == givenValue) {
                    Node newNode = new Node(value, temp.next);
                    temp.next = newNode;
                    break;
                }
                temp = temp.next;
            }
        }
        return head;
    }

    public Node insertNodeAfterGivenPosition(Node head, int value, int givenValue) {
        if (head == null)
            return head;
        if (head.data == givenValue) {
            Node newNode = new Node(value, head.next);
            head.next = newNode;
            return head;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.data == givenValue) {
                    Node newNode = new Node(value, temp.next);
                    temp.next = newNode;
                    break;
                }
                temp = temp.next;
            }
        }
        return head;
    }
}
