package algorithms.implementaions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/*
We define a magic square to be an  matrix of distinct positive integers from  to  where the sum of any row, column, or diagonal of length  is always equal to the same number: the magic constant.

You will be given a  matrix  of integers in the inclusive range . We can convert any digit  to any other digit  in the range  at cost of . Given , convert it into a magic square at minimal cost. Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range .

For example, we start with the following matrix :

5 3 4
1 5 8
6 4 2
We can convert it to the following magic square:

8 3 4
1 5 9
6 7 2
This took three replacements at a cost of .

Function Description

Complete the formingMagicSquare function in the editor below. It should return an integer that represents the minimal total cost of converting the input square to a magic square.

formingMagicSquare has the following parameter(s):

s: a  array of integers
Input Format

Each of the lines contains three space-separated integers of row .

Constraints

Output Format

Print an integer denoting the minimum cost of turning matrix  into a magic square.

Sample Input 0

4 9 2
3 5 7
8 1 5
Sample Output 0

1
Explanation 0

If we change the bottom right value, , from  to  at a cost of ,  becomes a magic square at the minimum possible cost.

Sample Input 1

4 8 2
4 5 7
6 1 6
Sample Output 1

4
Explanation 1

Using 0-based indexing, if we make

-> at a cost of
-> at a cost of
-> at a cost of ,
then the total cost will be .
 */
public class FormingMagicSquare {


    // each letter appears exactly once in a given column or a row.


    /* either all the letters should appear exactly once in both the diagonals; or in case of odd ordered squares,
     one of the diagonals should consist entirely of the middle term, while the other diagonal should have all the letters exactly once.
      i.e. α + β + γ = 3 β */

    static int formingMagicSquare(int[][] s) {
        int minChanges = 10000;
        int[] scores = {0, 0, 0, 0, 0, 0, 0, 0};

        int[][][] SOLUTIONS = new int[][][]{
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}};


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {

                    if (SOLUTIONS[i][j][k] > s[j][k])
                        scores[i] += SOLUTIONS[i][j][k] - s[j][k];
                    else if (SOLUTIONS[i][j][k] < s[j][k])
                        scores[i] += s[j][k] - SOLUTIONS[i][j][k];
                }
            }
        }

        for (int score : scores) {
            if (score < minChanges)
                minChanges = score;
        }
        return minChanges;
    }


    public static void main(String[] args) {

        System.out.println(formingMagicSquare(new int[][]{{4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}}));
    }
}
