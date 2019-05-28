package algorithms.sorting;

import java.util.Arrays;

/**
 * The previous challenges covered Insertion Sort, which is a simple and intuitive sorting algorithm with a running time of . In these next few challenges, we're covering a divide-and-conquer algorithm called Quicksort (also known as Partition Sort). This challenge is a modified version of the algorithm that only addresses partitioning. It is implemented as follows:
 * <p>
 * Step 1: Divide
 * Choose some pivot element, , and partition your unsorted array, , into three smaller arrays: , , and , where each element in , each element in , and each element in .
 * <p>
 * For example: Assume
 * The pivot is at
 * is divided into , , and .
 * Putting them all together, you get . Another valid solution is .
 * <p>
 * Given  and , partition  into , , and  using the Divide instructions above. Then print each element in  followed by each element in , followed by each element in  on a single line. Your output should be space-separated and does not have to maintain ordering of the elements within the three categories.
 * <p>
 * Function Description
 * <p>
 * Complete the quickSort function in the editor below. It should return an array of integers as described above.
 * <p>
 * quickSort has the following parameter(s):
 * <p>
 * arr: an array of integers where  is the pivot element
 * Input Format
 * <p>
 * The first line contains , the size of the array .
 * The second line contains  space-separated integers describing  (the unsorted array). The first integer (corresponding to ) is your pivot element, .
 * <p>
 * Constraints
 * <p>
 * where
 * All elements will be unique.
 * Output Format
 * <p>
 * On a single line, print the partitioned numbers (i.e.: the elements in , then the elements in , and then the elements in ). Each integer should be separated by a single space.
 * <p>
 * Sample Input
 * <p>
 * 5
 * 4 5 3 7 2
 * Sample Output
 * <p>
 * 3 2 4 5 7
 * Explanation
 * <p>
 * Pivot: .
 * ; ;
 * <p>
 * , so it's added to .
 * ; ;
 * <p>
 * , so it's added to .
 * ; ;
 * <p>
 * , so it's added to .
 * ; ;
 * <p>
 * , so it's added to .
 * ; ;
 * <p>
 * We then print the elements of , followed by , followed by , we get: 3 2 4 5 7.
 * <p>
 * You don't need to maintain ordering, so another valid solution would be 2 3 4 5 7.
 */
public class QuickSort1Partition {
    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {
        int[] result = new int[arr.length];
        int pivot = arr[0];

        int[] left = new int[arr.length + 1];
        int[] equal = new int[arr.length + 1];
        int[] right = new int[arr.length + 1];

        int leftIndex = 0;
        int equalIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot) {
                left[leftIndex++] = arr[i];
            } else if (arr[i] == pivot) {
                equal[equalIndex++] = arr[i];
            } else right[rightIndex++] = arr[i];
        }

        for (int i = 0; i < leftIndex; i++) {
            result[resultIndex++] = left[i];
        }
        for (int i = 0; i < equalIndex; i++) {
            result[resultIndex++] = equal[i];
        }
        for (int i = 0; i < rightIndex; i++) {
            result[resultIndex++] = right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{4, 5, 3, 7, 2})));
    }
}
