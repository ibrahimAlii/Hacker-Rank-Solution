package algorithms.sorting;

import java.util.Arrays;

/**
 * Sorting is useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses as well. In this case, it will make it easier to determine which pair or pairs of elements have the smallest absolute difference between them.
 * <p>
 * For example, if you've got the list , sort it as  to see that several pairs have the minimum difference of : . The return array would be .
 * <p>
 * Given a list of unsorted integers, , find the pair of elements that have the smallest absolute difference between them. If there are multiple pairs, find them all.
 * <p>
 * Function Description
 * <p>
 * Complete the closestNumbers function in the editor below. It must return an array of integers as described.
 * <p>
 * closestNumbers has the following parameter(s):
 * <p>
 * arr: an array of integers
 * Input Format
 * <p>
 * The first line contains a single integer , the length of .
 * The second line contains  space-separated integers, .
 * <p>
 * Constraints
 * <p>
 * All  are unique in .
 * Output Format
 * <p>
 * Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending order, all on the same line with just a single space between each pair of numbers. A number may be part of two pairs when paired with its predecessor and its successor.
 * <p>
 * Sample Input 0
 * <p>
 * 10
 * -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854
 * Sample Output 0
 * <p>
 * -20 30
 * Explanation 0
 * (30) - (-20) = 50, which is the smallest difference.
 * <p>
 * Sample Input 1
 * <p>
 * 12
 * -20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470
 * Sample Output 1
 * <p>
 * -520 -470 -20 30
 * Explanation 1
 * (-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.
 * <p>
 * Sample Input 2
 * <p>
 * 4
 * 5 4 3 2
 * Sample Output 2
 * <p>
 * 2 3 3 4 4 5
 * Explanation 2
 * Here, the minimum difference will be 1. Valid pairs are (2, 3), (3, 4), and (4, 5). We print the elements of each pair, space-separated on a single line.
 */
public class ClosestNumbers {

    static String findMinDiff(int[] arr, int n) {

        Arrays.sort(arr);

        StringBuilder s = new StringBuilder("");
        int diff = Integer.MAX_VALUE;


        for (int i = 0; i < n - 1; i++) {

            if (arr[i + 1] - arr[i] == diff) {
                s.append(arr[i]).append(" ").append(arr[i + 1]).append(" ");
            }
            if (arr[i + 1] - arr[i] < diff) {
                diff = arr[i + 1] - arr[i];
                s.setLength(0);
                s.append(arr[i]).append(" ").append(arr[i + 1]).append(" ");
            }

        }

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(findMinDiff(new int[]{5, 4, 3, 2}, 4));
    }
}
