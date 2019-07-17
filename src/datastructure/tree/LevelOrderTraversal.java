package datastructure.tree;

/*
You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree. In level order traversal, we visit the nodes level by level from left to right. You only have to complete the function. For example:

     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4
For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.

Input Format

You are given a function,

void levelOrder(Node * root) {

}
Constraints

1 Nodes in the tree  500

Output Format

Print the values in a single line separated by a space.

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

1 2 5 3 6 4

Explanation

We need to print the nodes level by level. We process each level from left to right.
Level Order Traversal: 1 -> 2 -> 5 -> 3 -> 6 -> 4.
 */
public class LevelOrderTraversal {


    // Solution

    /*
      public static void levelOrder(Node root) {
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);
      while(!queue.isEmpty()){
          Node current = queue.poll();
          System.out.print(current.data+ " ");
          if (current.left != null) queue.add(current.left);
          if (current.right != null) queue.add(current.right);
      }
    }

     */
}
