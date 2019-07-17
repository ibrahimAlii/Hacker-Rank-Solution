package datastructure.tree;

/*
You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
Top view means when you look the tree from the top the nodes, what you will see will be called the top view of the tree. See the example below.
You only have to complete the function.
For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 1 -> 2 -> 5 -> 6

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

1 Nodes in the tree  500

Output Format

Print the values on a single line separated by space.

Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Sample Output

1 2 5 6

Explanation

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
From the top only nodes 1,2,5,6 will be visible.
 */
public class TopView {

    // ====== Solution ======

    /*

      public static void topView(Node root) {
        int MAX = 500;    // Otherwise, MAX=getNodeCount(root);
    int[] top = new int[MAX*2];
    Queue<Object[]> queue = new ArrayDeque<>();
    queue.add(new Object[]{root, MAX});
    while(!queue.isEmpty()) {
        Object[] array = queue.remove();
        Node node = (Node)array[0];
        Integer order = (Integer)array[1];
        if(node == null) continue;

        if(top[order] == 0) top[order] = node.data;
        queue.add(new Object[]{node.left, order-1});
        queue.add(new Object[]{node.right, order+1});
    }

    for(int data: top) if(data != 0) System.out.print(data + " ");

    }

     */
}
