package datastructure.stacks;

import java.util.Arrays;

/*
Alexa has two stacks of non-negative integers, stack  and stack  where index denotes the top of the stack. Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack  or stack .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
Given , , and  for  games, find the maximum possible score Nick can achieve (i.e., the maximum number of integers he can remove without being disqualified) during each game and print it on a new line.

Input Format

The first line contains an integer,  (the number of games). The  subsequent lines describe each game in the following format:

The first line contains three space-separated integers describing the respective values of  (the number of integers in stack ),  (the number of integers in stack ), and  (the number that the sum of the integers removed from the two stacks cannot exceed).
The second line contains  space-separated integers describing the respective values of .
The third line contains  space-separated integers describing the respective values of .
Constraints

Subtasks

 for  of the maximum score.
Output Format

For each of the  games, print an integer on a new line denoting the maximum possible score Nick can achieve without being disqualified.

Sample Input 0

1
5 4 10
4 2 4 6 1
2 1 8 5
Sample Output 0

4
Explanation 0

The two stacks initially look like this:

image

The image below depicts the integers Nick should choose to remove from the stacks. We print  as our answer, because that is the maximum number of integers that can be removed from the two stacks without the sum exceeding .

image

(There can be multiple ways to remove the integers from the stack, the image shows just one of them.)
 */
public class GameOfTwoStacks {

    static int twoStacks(int x, int[] a, int[] b) {
        // 1st way for traversing in first array, 2nd way for traversing in second array, 3rd way for traversing in both
        // sum is the same as ways
        int[] sum1 = new int[a.length];
        int[] sum2 = new int[b.length];

        int maxLength = Math.max(a.length, b.length);
        for (int i = 1; i <= maxLength; i++) {
            if (i < a.length)
                sum1[i] = a[i - 1] + sum1[i - 1];
            if (i < b.length)
                sum2[i] = b[i - 1] + sum2[i - 1];
        }

        int sum = 0, count = 0, i = 0, j = 0;

        while (i < a.length && sum + a[i] <= x) {    //considering only first stack and calculating count
            sum += a[i];
            i++;
        }
        count = i;

        while (j < b.length && i >= 0) {          //now adding one element of second stack at a time and subtracting the top element of first stack and calculating the count
            sum += b[j];
            j++;
            while (sum > x && i > 0) {
                i--;
                sum -= a[i];
            }
            if (sum <= x && i + j > count)
                count = i + j;
        }


        return count;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 2, 4, 6, 1};
        int[] arr2 = new int[]{2, 1, 8, 5};

        int[] arr3 = new int[]{1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0};
        int[] arr4 = new int[]{0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1};

        int[] arr5 = new int[]{0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0};
        int[] arr6 = new int[]{1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0};

        int[] arr7 = new int[]{1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1};
        int[] arr8 = new int[]{0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1};
        System.out.println(twoStacks(10, arr1, arr2));
        System.out.println(twoStacks(12, arr3, arr4));
        System.out.println(twoStacks(5, arr5, arr6));
        System.out.println(twoStacks(5, arr7, arr8));
    }
}



