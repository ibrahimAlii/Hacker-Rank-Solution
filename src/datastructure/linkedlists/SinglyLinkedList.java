package datastructure.linkedlists;

public class SinglyLinkedList {
    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void insertNode(int data) {
        Node node = new Node(data);
        if (head == null) head = node;
        else {
            tail.next = node;
        }
        tail = node;
    }

    public void print() {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
