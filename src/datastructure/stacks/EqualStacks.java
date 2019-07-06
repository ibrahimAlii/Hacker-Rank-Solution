package datastructure.stacks;

import java.awt.*;
import java.util.Stack;

/*
You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

Note: An empty stack is still a stack.

Input Format

The first line contains three space-separated integers, , , and , describing the respective number of cylinders in stacks , , and . The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

The second line contains  space-separated integers describing the cylinder heights in stack . The first element is the top of the stack.
The third line contains  space-separated integers describing the cylinder heights in stack . The first element is the top of the stack.
The fourth line contains  space-separated integers describing the cylinder heights in stack . The first element is the top of the stack.
Constraints

Output Format

Print a single integer denoting the maximum height at which all stacks will be of equal height.

Sample Input

5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
Sample Output

5
Explanation

Initially, the stacks look like this:

initial stacks

Observe that the three stacks are not all the same height. To make all stacks of equal height, we remove the first cylinder from stacks  and , and then remove the top two cylinders from stack  (shown below).

modified stacks

As a result, the stacks undergo the following change in height:

All three stacks now have . Thus, we print  as our answer.
 */
public class EqualStacks {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int maxLength = Math.max(Math.max(h1.length, h2.length), h3.length);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        for (int i = maxLength - 1; i >= 0; i--) {
            if (i < h1.length)
                stack1.push(h1[i] + (!stack1.isEmpty() ? stack1.peek() : 0));
            if (i < h2.length)
                stack2.push(h2[i] + (!stack2.isEmpty() ? stack2.peek() : 0));
            if (i < h3.length)
                stack3.push(h3[i] + (!stack3.isEmpty() ? stack3.peek() : 0));
        }

        Stack<Integer> min;
        if (stack1.size() < stack2.size() && stack1.size() < stack3.size())
            min = stack1;
        else if (stack2.size() < stack1.size() && stack2.size() < stack3.size())
            min = stack2;
        else min = stack3;

        while (!min.isEmpty()) {
            int val = min.pop();

            int val1 = 0, val2 = 0, val3 = 0;
            if (min == stack1) {
                val2 = stack2.search(val);
                val3 = stack3.search(val);
            }else if (min == stack2){
                val1 = stack1.search(val);
                val3 = stack3.search(val);
            }else {
                val1 = stack1.search(val);
                val2 = stack2.search(val);
            }

            if (val2 != -1 && val3 != -1 && val1 != -1)
                return val;

        }

        return 0;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 2, 1, 1, 1};
        int[] arr2 = new int[]{4, 3, 2};
        int[] arr3 = new int[]{1, 1, 4, 1};

        int[] arr4 = new int[]{1, 1, 1, 1, 1};
        int[] arr5 = new int[]{3, 2,};
        int[] arr6 = new int[]{1, 3, 1};

        System.out.println(equalStacks(arr1, arr2, arr3));
        System.out.println(equalStacks(arr4, arr5, arr6));
    }
}


