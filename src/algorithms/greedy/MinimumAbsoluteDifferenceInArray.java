package algorithms.greedy;

import java.util.TreeSet;

/*
Consider an array of integers, . We define the absolute difference between two elements,  and  (where ), to be the absolute value of .

Given an array of integers, find and print the minimum absolute difference between any two elements in the array. For example, given the array  we can create  pairs of numbers:  and . The absolute differences for these pairs are ,  and . The minimum absolute difference is .

Function Description

Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.

minimumAbsoluteDifference has the following parameter(s):

n: an integer that represents the length of arr
arr: an array of integers
Input Format

The first line contains a single integer , the size of .
The second line contains  space-separated integers .

Constraints

Output Format

Print the minimum absolute difference between any two elements in the array.

Sample Input 0

3
3 -7 0
Sample Output 0

3
Explanation 0

With  integers in our array, we have three possible pairs: , , and . The absolute values of the differences between these pairs are as follows:

Notice that if we were to switch the order of the numbers in these pairs, the resulting absolute values would still be the same. The smallest of these possible absolute differences is .

Sample Input 1

10
-59 -36 -13 1 -53 -92 -2 -96 -54 75
Sample Output 1

1
Explanation 1

The smallest absolute difference is .

Sample Input 2

5
1 -3 71 68 17
Sample Output 2

3ma
Explanation 2

The minimum absolute difference is .
 */
public class MinimumAbsoluteDifferenceInArray {


    // Complete the minimumAbsoluteDifference function below.
    private static int minimumAbsoluteDifference(int[] arr) {
        TreeSet<Integer> pSet = new TreeSet<>();
        TreeSet<Integer> nSet = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        for (int val : arr) {
            if (val > 0)
                pSet.add(val);
            else nSet.add(val);
            if (pSet.contains(val) || nSet.contains(val)) {
                min = 0;
                break;
            }
        }

        min = getMin(nSet, min);

        min = getMin(pSet, min);


        return min;
    }

    private static int getMin(TreeSet<Integer> set, int min) {
        Integer[] minSet = set.toArray(new Integer[0]);
        for (int i = 0; i < minSet.length - 1; i++) {
            int val = Math.abs(minSet[i] - minSet[i + 1]);
            if (val < min)
                min = val;
        }
        return min;
    }


    public static void main(String[] args) {

        System.out.println(minimumAbsoluteDifference(new int[]{1, -3, 71, 68, 17}));
        System.out.println(minimumAbsoluteDifference(new int[]{3, -7, 0}));
        System.out.println(minimumAbsoluteDifference(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}));
    }
}
