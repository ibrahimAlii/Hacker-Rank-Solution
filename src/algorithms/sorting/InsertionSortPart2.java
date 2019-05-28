package algorithms.sorting;


/**
 * In Insertion Sort Part 1, you inserted one element into an array at its correct sorted position. Using the same approach repeatedly, can you sort an entire array?
 * <p>
 * Guideline: You already can place an element into a sorted array. How can you use that code to build up a sorted array, one element at a time? Note that in the first step, when you consider an array with just the first element, it is already sorted since there's nothing to compare it to.
 * <p>
 * In this challenge, print the array after each iteration of the insertion sort, i.e., whenever the next element has been inserted at its correct position. Since the array composed of just the first element is already sorted, begin printing after placing the second element.
 * <p>
 * For example, there are  elements in . Working from left to right, we get the following output:
 * <p>
 * 3 4 7 5 6 2 1
 * 3 4 7 5 6 2 1
 * 3 4 5 7 6 2 1
 * 3 4 5 6 7 2 1
 * 2 3 4 5 6 7 1
 * 1 2 3 4 5 6 7
 * Function Description
 * <p>
 * Complete the insertionSort2 function in the editor below. At each iteration, it should print the array as space-separated integers on a separate line.
 * <p>
 * insertionSort2 has the following parameter(s):
 * <p>
 * n: an integer representing the length of the array
 * arr: an array of integers
 * Input Format
 * <p>
 * The first line contains an integer, , the size of .
 * The next line contains  space-separated integers .
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * On each line, output the entire array at every iteration.
 * <p>
 * Sample Input
 * <p>
 * 6
 * 1 4 3 5 6 2
 * Sample Output
 * <p>
 * 1 4 3 5 6 2
 * 1 3 4 5 6 2
 * 1 3 4 5 6 2
 * 1 3 4 5 6 2
 * 1 2 3 4 5 6
 * Explanation
 * <p>
 * Skip testing  against itself at position . It is sorted.
 * Test position  against position : , no more to check, no change.
 * Print
 * Test position  against positions  and :
 * <p>
 * , new position may be . Keep checking.
 * , so insert  at position  and move others to the right.
 * Print
 * Test position  against positions  (as necessary): no change.
 * Print
 * Test position  against positions : no change.
 * Print
 * Test position  against positions , insert  at position  and move others to the right.
 * Print
 */
public class InsertionSortPart2 {

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int elem = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (elem < arr[j]){
                    arr[j + 1] = arr[j];
                    arr[j] = elem;
                }
            }

            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        insertionSort2(1, new int[]{1, 4, 3, 5, 6, 2});
        insertionSort2(1, new int[]{3, 4, 7, 5, 6, 2, 1});
    }
}
