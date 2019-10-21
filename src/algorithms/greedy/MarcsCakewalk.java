package algorithms.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/*
Marc loves cupcakes, but he also likes to stay fit. Each cupcake has a calorie count, and Marc can walk a distance to expend those calories. If Marc has eaten  cupcakes so far, after eating a cupcake with  calories he must walk at least  miles to maintain his weight.

For example, if he eats  cupcakes with calorie counts in the following order: , the miles he will need to walk are . This is not the minimum, though, so we need to test other orders of consumption. In this case, our minimum miles is calculated as .

Given the individual calorie counts for each of the cupcakes, determine the minimum number of miles Marc must walk to maintain his weight. Note that he can eat the cupcakes in any order.

Function Description

Complete the marcsCakewalk function in the editor below. It should return a long integer that represents the minimum miles necessary.

marcsCakewalk has the following parameter(s):

calorie: an integer array that represents calorie count for each cupcake
Input Format

The first line contains an integer , the number of cupcakes in .
The second line contains  space-separated integers .

Constraints

Output Format

Print a long integer denoting the minimum number of miles Marc must walk to maintain his weight.

Sample Input 0

3
1 3 2
Sample Output 0

11
Explanation 0

Let's say the number of miles Marc must walk to maintain his weight is . He can minimize  by eating the  cupcakes in the following order:

Eat the cupcake with  calories, so .
Eat the cupcake with  calories, so .
Eat the cupcake with  calories, so .
We then print the final value of , which is , as our answer.

Sample Input 1

4
7 4 9 6
Sample Output 1

79
Explanation 1



 */
public class MarcsCakewalk {

    static long marcsCakewalk(int[] calorie) {
        long result = 0;
        Arrays.sort(calorie);
        int pow = 0;
        for (int i = calorie.length - 1; i >= 0; i--) {
            result += (Math.pow(2, pow++) * calorie[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(marcsCakewalk(new int[]{7, 4, 9 ,6}));
        System.out.println(marcsCakewalk(new int[]{1, 3, 2}));
    }
}
