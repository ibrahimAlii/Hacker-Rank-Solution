package datastructure.linkedlists;

/*
This challenge is part of a tutorial track by MyCodeSchool

You’re given the pointer to the head nodes of two sorted linked lists. The data in both lists will be sorted in ascending order. Change the next pointers to obtain a single, merged linked list which also has data in ascending order. Either head pointer given may be null meaning that the corresponding list is empty.

Input Format

You have to complete the SinglyLinkedListNode MergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) method which takes two arguments - the heads of the two sorted linked lists to merge. You should NOT read any input from stdin/console.

The input is handled by the code in the editor and the format is as follows:

The first line contains an integer , denoting the number of test cases.
The format for each test case is as follows:

The first line contains an integer , denoting the length of the first linked list.
The next  lines contain an integer each, denoting the elements of the linked list.
The next line contains an integer , denoting the length of the second linked list.
The next  lines contain an integer each, denoting the elements of the second linked list.

Constraints

, where  is the  element of the list.
Output Format

Change the next pointer of individual nodes so that nodes from both lists are merged into a single list. Then return the head of this merged list. Do NOT print anything to stdout/console.

The output is handled by the editor and the format is as follows:

For each test case, print in a new line, the linked list after merging them separated by spaces.

Sample Input

1
3
1
2
3
2
3
4
Sample Output

1 2 3 3 4
Explanation

The first linked list is: 1 -> 2 -> 3 -> NULL

The second linked list is: 3 -> 4 -> NULL

Hence, the merged linked list is: 1 -> 2 -> 3 -> 3 -> 4 -> NULL
 */
public class MergeTwoSorted {
    static SinglyLinkedList.Node mergeLists(SinglyLinkedList.Node head1, SinglyLinkedList.Node head2) {
        SinglyLinkedList.Node head;
        SinglyLinkedList.Node temp;

        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;

        if (head1.data < head2.data){
            temp = head1;
            head1 = head1.next;
        }else {
            temp = head2;
            head2 = head2.next;
        }

        head = temp;

        while (head1 != null && head2 != null){
            if (head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) temp.next = head1;

        if (head2 != null) temp.next = head2;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{3, 4};
        for (int value : arr1) {
            list1.insertNode(value);
        }

        for (int value : arr2) {
            list2.insertNode(value);
        }

        SinglyLinkedList.Node node = mergeLists(list1.head, list2.head);

        while (node != null){
            System.out.print(node.data);
            node = node.next;
        }

    }

}
