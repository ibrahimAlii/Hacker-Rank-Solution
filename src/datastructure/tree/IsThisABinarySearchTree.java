package datastructure.tree;

/**
 * For the purposes of this challenge, we define a binary tree to be a binary search tree with the following ordering requirements:
 * <p>
 * The  value of every node in a node's left subtree is less than the data value of that node.
 * The  value of every node in a node's right subtree is greater than the data value of that node.
 * Given the root node of a binary tree, can you determine if it's also a binary search tree?
 * <p>
 * Complete the function in your editor below, which has  parameter: a pointer to the root of a binary tree. It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.
 * <p>
 * Input Format
 * <p>
 * You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * You are not responsible for printing any output to stdout. Your function must return true if the tree is a binary search tree; otherwise, it must return false. Hidden code stubs will print this result as a Yes or No answer on a new line.
 * <p>
 * Sample Input
 * <p>
 * tree
 * <p>
 * Sample Output
 * <p>
 * No
 */

class Node{
    int data;
    Node left;
    Node right;
}
public class IsThisABinarySearchTree {


    boolean isLeftLesser(int data, Node root) {
        if (root == null) return true;
        else if (data > root.data && isLeftLesser(data, root.left) && isLeftLesser(data, root.right))
            return true;
        else return false;
    }

    boolean isRightGreater(int data, Node root) {
        if (root == null) return true;
        else if (data < root.data && isRightGreater(data, root.right) && isRightGreater(data, root.left))
            return true;
        else return false;
    }

    boolean checkBST(Node root) {
        if (root == null) return true;
        else if (isLeftLesser(root.data, root.left)
                && isRightGreater(root.data, root.right)
                && checkBST(root.left)
                && checkBST(root.right))
            return true;
        else return false;

    }

}
