package algorithms.dynamicProgramming;

import java.util.Arrays;

/*
Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues. She is biased towards her friends and plans to give them more than the others. One of the program managers hears of this and tells her to make sure everyone gets the same number.

To make things difficult, she must equalize the number of chocolates in a series of operations. For each operation, she can give  chocolates to all but one colleague. Everyone who gets chocolate in a round receives the same number of pieces.

For example, assume the starting distribution is . She can give  bars to the first two and the distribution will be . On the next round, she gives the same two  bars each, and everyone has the same number: .

Given a starting distribution, calculate the minimum number of operations needed so that every colleague has the same number of chocolates.

Function Description

Complete the equal function in the editor below. It should return an integer that reperesents the minimum number of operations required.

equal has the following parameter(s):

arr: an array of integers to equalize
Input Format

The first line contains an integer , the number of test cases.

Each test case has  lines.
- The first line contains an integer , the number of colleagues.
- The second line contains  space-separated integers denoting the number of chocolates each colleague has.

Constraints



Number of initial chocolates each colleague has <

Output Format

Print the minimum number of operations needed for each test case, one to a line.

Sample Input

1
4
2 2 3 7
Sample Output

2
Explanation

Start with
Add  to all but the 3rd element
Add  to all but the 4th element

Two operations were required.

Sample Input 1

1
3
10 7 12
Sample Output 1

3
Explanation 1

Start with
Add  to the first two elements
Add  to the last two elements
Add  to the last two elements

Three operations were required.
 */
public class Equal {

    // Complete the equal function below.
    static int equal(int[] arr) {
        Arrays.sort(arr);

        long sum = Long.MAX_VALUE;

        for (int base = 0; base < 3; base++) {
            int current_sum = 0;
            for (int value : arr) {
                int delta = value - arr[0] + base;
                current_sum += delta / 5 + delta % 5 / 2 + delta % 5 % 2;
            }
            sum = Math.min(current_sum, sum);
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(equal(new int[]{10, 7, 12}));
        System.out.println(equal(new int[]{1, 1, 5}));
        System.out.println(equal(new int[]{2, 2, 3, 7}));
    }
}
