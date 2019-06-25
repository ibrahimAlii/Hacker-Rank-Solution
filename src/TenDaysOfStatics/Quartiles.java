package TenDaysOfStatics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Objective
 * In this challenge, we practice calculating quartiles. Check out the Tutorial tab for learning materials and an instructional video!
 * <p>
 * Task
 * Given an array, , of  integers, calculate the respective first quartile (), second quartile (), and third quartile (). It is guaranteed that , , and  are integers.
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
 * The first line should be the value of .
 * The second line should be the value of .
 * The third line should be the value of .
 * Sample Input
 * <p>
 * 9
 * 3 7 8 5 12 14 21 13 18
 * Sample Output
 * <p>
 * 6
 * 12
 * 16
 * Explanation
 * <p>
 * . When we sort the elements in non-decreasing order, we get . It's easy to see that .
 * <p>
 * As there are an odd number of data points, we do not include the median (the central value in the ordered list) in either half:
 * <p>
 * Lower half (L): 3, 5, 7, 8
 * <p>
 * Upper half (U): 13, 14, 18, 21
 * <p>
 * Now, we find the quartiles:
 * <p>
 * is the . So, .
 * is the . So, .
 * is the . So, .
 */
public class Quartiles {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1, n2, n3;
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);

        if (n % 2 == 0)
            n2 = (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2;
        else n2 = arr[(arr.length / 2)];

        if (n % 2 == 0)
            n1 = (arr[(arr.length / 2) / 2] + arr[(arr.length / 2) / 2 + 1]) / 2;
        else
            n1 = (arr[(arr.length / 2) / 2 - 1] + arr[(arr.length / 2) / 2]) / 2;

        if (n % 2 == 0)
            n3 = (arr[((arr.length / 2) + (arr.length / 2) / 2)] + arr[((arr.length / 2) + (arr.length / 2)) / 2]) / 2 +1 ;
        else
            n3 = (arr[(arr.length / 2) + (arr.length / 2) / 2] + arr[(arr.length / 2) + (arr.length / 2) / 2 + 1]) / 2;

        System.out.printf("%d%s%d%s%d", n1, "\n", n2, "\n", n3);
    }
}
