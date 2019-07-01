package datastructure.linkedlists;

/**
 * This challenge is part of a MyCodeSchool tutorial track and is accompanied by a video lesson.
 * <p>
 * If you're new to linked lists, this is a great exercise for learning about them. Given a pointer to the head node of a linked list, print its elements in order, one element per line. If the head pointer is null (indicating the list is empty), don’t print anything.
 * <p>
 * Input Format
 * <p>
 * The first line of input contains , the number of elements in the linked list.
 * The next  lines contain one element each, which are the elements of the linked list.
 * <p>
 * Note: Do not read any input from stdin/console. Complete the printLinkedList function in the editor below.
 * <p>
 * Constraints
 * <p>
 * , where  is the  element of the linked list.
 * Output Format
 * <p>
 * Print the integer data for each element of the linked list to stdout/console (e.g.: using printf, cout, etc.). There should be one element per line.
 * <p>
 * Sample Input
 * <p>
 * 2
 * 16
 * 13
 * Sample Output
 * <p>
 * 16
 * 13
 * Explanation
 * <p>
 * There are two elements in the linked list. They are represented as 16 -> 13 -> NULL. So, the printLinkedList function should print 16 and 13 each in a new line.
 */
public class PrintElementOfLinkedLists {

    static void printLinkedList(SinglyLinkedList list) {
        SinglyLinkedList.Node node = list.head;
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{16, 13};
        SinglyLinkedList linkedListNode = new SinglyLinkedList();
        for (int i = 0; i < arr.length; i++) {
            linkedListNode.insertNode(arr[i]);
        }
        printLinkedList(linkedListNode);
    }
}
