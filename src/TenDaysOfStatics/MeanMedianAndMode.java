package TenDaysOfStatics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Objective
 * In this challenge, we practice calculating the mean, median, and mode. Check out the Tutorial tab for learning materials and an instructional video!
 * <p>
 * Task
 * Given an array, , of  integers, calculate and print the respective mean, median, and mode on separate lines. If your array contains more than one modal value, choose the numerically smallest one.
 * <p>
 * Note: Other than the modal value (which will always be an integer), your answers should be in decimal form, rounded to a scale of  decimal place (i.e., ,  format).
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the number of elements in the array.
 * The second line contains  space-separated integers describing the array's elements.
 * <p>
 * Constraints
 * <p>
 * , where  is the  element of the array.
 * Output Format
 * <p>
 * Print  lines of output in the following order:
 * <p>
 * Print the mean on a new line, to a scale of  decimal place (i.e., , ).
 * Print the median on a new line, to a scale of  decimal place (i.e., , ).
 * Print the mode on a new line; if more than one such value exists, print the numerically smallest one.
 * Sample Input
 * <p>
 * 10
 * 64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
 * Sample Output
 * <p>
 * 43900.6
 * 44627.5
 * 4978
 * Explanation
 * <p>
 * Mean:
 * We sum all  elements in the array, divide the sum by , and print our result on a new line.
 * <p>
 * Median:
 * To calculate the median, we need the elements of the array to be sorted in either non-increasing or non-decreasing order. The sorted array . We then average the two middle elements:
 * <p>
 * and print our result on a new line.
 * Mode:
 * We can find the number of occurrences of all the elements in the array:
 * <p>
 * 4978 : 1
 * 11735 : 1
 * 14216 : 1
 * 14470 : 1
 * 38120 : 1
 * 51135 : 1
 * 64630 : 1
 * 67060 : 1
 * 73429 : 1
 * 99233 : 1
 * Every number occurs once, making  the maximum number of occurrences for any number in . Because we have multiple values to choose from, we want to select the smallest one, , and print it on a new line.
 */
public class MeanMedianAndMode {

    public static void main(String[] args) {
        double mean = 0, median = 0;
        int mode = 0;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextFloat();
        }
        Arrays.sort(arr);
        float lastOccur = arr[0];
        int maxOccur = 0;
        float modeIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            float value = arr[i];
            mean += value;
            if (value == lastOccur) {
                maxOccur++;
                if (maxOccur > mode) {
                    modeIndex = value;
                    mode = maxOccur;
                }
            } else {
                maxOccur = 1;
                lastOccur = value;
            }
        }

        if (arr.length % 2 == 0) {
            median = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else median = arr[arr.length / 2 + 1];

        System.out.printf("%.1f%s%.1f%s%.0f", (mean / arr.length), "\n", median, "\n", modeIndex);
    }
}
//49921.5
//        49253.5
//        2184