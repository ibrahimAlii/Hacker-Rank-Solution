package algorithms.sorting;

import java.util.HashMap;

/**
 * Insertion Sort is a simple sorting technique which was covered in previous challenges. Sometimes, arrays may be too large for us to wait around for insertion sort to finish. Is there some other way we can calculate the number of shifts an Insertion Sort performs when sorting an array?
 * <p>
 * If  is the number of elements over which the  element of the array has to shift, then the total number of shifts will be  ... + . For example, consider the array .
 * <p>
 * Array		Shifts
 * [4,3,2,1]
 * [3,4,2,1]	1
 * [2,3,4,1]	2
 * [1,2,3,4]	3
 * <p>
 * Total shifts = 1 + 2 + 3 = 6
 * Function description
 * <p>
 * Complete the insertionSort function in the editor below. It should return an integer that represents the number of shifts required to sort the given array.
 * <p>
 * insertionSort has the following parameter(s):
 * <p>
 * arr: an array of integers
 * Input Format
 * <p>
 * The first line contains a single integer , the number of queries to perform.
 * <p>
 * The following  pairs of lines are as follows:
 * <p>
 * The first line contains an integer , the length of .
 * The second line contains  space-separated integers .
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print  lines containing the number of shifts for each query.
 * <p>
 * Sample Input
 * <p>
 * 2
 * 5
 * 1 1 1 2 2
 * 5
 * 2 1 3 1 2
 * Sample Output
 * <p>
 * 0
 * 4
 * Explanation
 * <p>
 * The first query is already sorted, therefore there's no need to shift any element. In the second case, it will proceed in the following way.
 * <p>
 * Array: 2 1 3 1 2 -> 1 2 3 1 2 -> 1 1 2 3 2 -> 1 1 2 2 3
 * Moves:   -        1       -    2         -  1            = 4
 */
public class InsertionSortAdvancedAnalysis {

    static long merge(int[] arr, int p, int mid, int q) {

        int n1 = mid - p + 1;
        int n2 = q - mid;
        long count = 0;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];

        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + i + 1];

        int i = 0, j = 0;

        for (int k = p; k < (p + n1 + n2); k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                if (L[i] != Integer.MAX_VALUE) {
                    count += n1 - i;
                }
                j++;

            }
        }

        return count;
    }

    static long mergeSort(int[] arr, int p, int q) {
        long ans = 0;
        if (p < q) {
            int mid = (p + q) / 2;
            ans += mergeSort(arr, p, mid);
            ans += mergeSort(arr, mid + 1, q);
            ans += merge(arr, p, mid, q);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(mergeSort(new int[]{2, 1, 3, 1, 2}, 0, 4));
        System.out.println(mergeSort(new int[]{1, 1, 1, 2, 2}, 0, 4));
    }
}
