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

public class ConvertingArrayToLinkedList {
    public static void main(String[] args) {
        ConvertingArrayToLinkedList convertingArrayToLinkedList = new ConvertingArrayToLinkedList();
        int arr[] = { 1, 5, 6, 9, 8 };
        // Convertint Array to LinkedList
        Node head = convertingArrayToLinkedList.convertArrayToLinkedList(arr);
        // Printing the LinkedList
        convertingArrayToLinkedList.printLinkedList(head);
    }

    public Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node nextNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node tempNode = new Node(arr[i]);
            nextNode.next = tempNode;
            nextNode = tempNode;
        }
        return head;
    }

    public void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.data + " -> ");
            else
                System.out.print(temp.data);
            temp = temp.next;
        }
    }
}
