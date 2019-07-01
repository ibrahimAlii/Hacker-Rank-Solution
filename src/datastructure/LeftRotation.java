package datastructure;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .
 *
 * Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.
 *
 * Input Format
 *
 * The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform).
 * The second line contains  space-separated integers describing the respective elements of the array's initial state.
 *
 * Constraints
 *
 * Output Format
 *
 * Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.
 *
 * Sample Input
 *
 * 5 4
 * 1 2 3 4 5
 * Sample Output
 *
 * 5 1 2 3 4
 * Explanation
 *
 * When we perform  left rotations, the array undergoes the following sequence of changes:
 *
 * Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 */
public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        if (d > n)
            d = d % n;

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[d++] + " ");
            if (d >= n)
                d = 0;
        }

        scanner.close();
    }


}
