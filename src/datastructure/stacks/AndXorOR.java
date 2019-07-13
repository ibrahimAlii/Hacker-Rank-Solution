package datastructure.stacks;

import java.util.Stack;

/*
Given an array  of  distinct elements. Let  and  be the smallest and the next smallest element in the interval where .

.

where , are the bitwise operators ,  and  respectively.
Your task is to find the maximum possible value of .

Input Format

First line contains integer .
Second line contains  integers, representing elements of the array .

Constraints


Output Format

Print the value of maximum possible value of .

Sample Input

5
9 6 3 5 2
Sample Output

15
Explanation

Consider the interval  the result will be maximum.


 */
public class AndXorOR {

    static int andXorOr(int[] a) {
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length - 1; i++) {
            while (!stack.isEmpty()) {
                int current = a[stack.peek()] ^ a[i];
                if (current > max)
                    max = current;
                if (a[stack.peek()] > a[i])
                    stack.pop();
                else break;
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(andXorOr(new int[]{9, 6, 3, 5, 2}));
    }
}
