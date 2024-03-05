package LinkedList;

public class FindLinkedListLenght {
    public static void main(String[] args) {
        FindLinkedListLenght findLinkedListLenght = new FindLinkedListLenght();
        int arr[] = { 1, 5, 6, 9, 8 };
        // Convertint Array to LinkedList
        Node head = findLinkedListLenght.convertArrayToLinkedList(arr);
        // Finding Length of the LinkedList
        System.out.println(findLinkedListLenght.findLinkedListLenght(head));
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

    public int findLinkedListLenght(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}
