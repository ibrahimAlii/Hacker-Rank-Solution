package datastructure.stacks;

import java.util.Arrays;
import java.util.Stack;

/*
Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place. Your task is to find the largest solid area in which the mall can be constructed.

There are a number of buildings in a certain two-dimensional landscape. Each building has a height, given by . If you join  adjacent buildings, they will form a solid rectangle of area .

For example, the heights array . A rectangle of height  and length  can be constructed within the boundaries. The area formed is .

Function Description

Complete the function largestRectangle int the editor below. It should return an integer representing the largest rectangle that can be formed within the bounds of consecutive buildings.

largestRectangle has the following parameter(s):

h: an array of integers representing building heights
Input Format

The first line contains , the number of buildings.
The second line contains  space-separated integers, each representing the height of a building.

Constraints

Output Format

Print a long integer representing the maximum area of rectangle formed.

Sample Input

5
1 2 3 4 5
Sample Output

9
Explanation

An illustration of the test case follows.
image

 */
public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] arr) {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.isEmpty() || arr[s.peek()] <= arr[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = arr[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.isEmpty())
        {
            tp = s.peek();
            s.pop();
            area_with_top = arr[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangle(new int[]{1, 2, 3, 4, 5}));
        System.out.println(largestRectangle(new int[]{3, 2, 3}));
        System.out.println(largestRectangle(new int[]{1, 3, 5, 9, 11}));
        System.out.println(largestRectangle(new int[]{6320, 6020, 6098, 1332, 7263, 672, 9472, 2838, 3401, 9494}));

    }
}
