package datastructure;

/**
 * Given a  2D Array, :
 * <p>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:
 * <p>
 * a b c
 * d
 * e f g
 * There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
 * <p>
 * For example, given the 2D array:
 * <p>
 * -9 -9 -9  1 1 1
 * 0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 * 0  0  8  6 6 0
 * 0  0  0 -2 0 0
 * 0  0  1  2 4 0
 * We calculate the following  hourglass values:
 * <p>
 * -63, -34, -9, 12,
 * -10, 0, 28, 23,
 * -27, -11, -2, 10,
 * 9, 17, 25, 18
 * Our highest hourglass value is  from the hourglass:
 * <p>
 * 0 4 3
 * 1
 * 8 6 6
 * Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.
 * <p>
 * Function Description
 * <p>
 * Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.
 * <p>
 * hourglassSum has the following parameter(s):
 * <p>
 * arr: an array of integers
 * Input Format
 * <p>
 * Each of the  lines of inputs  contains  space-separated integers .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the largest (maximum) hourglass sum found in .
 * <p>
 * Sample Input
 * <p>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 * <p>
 * 19
 * Explanation
 * <p>
 * contains the following hourglasses:
 * <p>
 * image
 * <p>
 * The hourglass with the maximum sum () is:
 * <p>
 * 2 4 4
 * 2
 * 1 2 4
 */
public class TWODArrayDS {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int result = 0;
        int max = -70;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j ++) {
                int sum = 0;
                sum += arr[i][j];
                sum += arr[i - 1][j];
                sum += arr[i + 1][j];
                sum += arr[i - 1][j - 1];
                sum += arr[i + 1][j - 1];
                sum += arr[i - 1][j + 1];
                sum += arr[i + 1][j + 1];
                if (sum > max)
                    max = sum;
            }

            result = max;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(hourglassSum(new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0},
        }));

        System.out.println(hourglassSum(new int[][]{
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5},
        }));
    }
}






