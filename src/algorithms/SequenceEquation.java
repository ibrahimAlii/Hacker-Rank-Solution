package algorithms;

import java.util.Arrays;

/*
Given a sequence of  integers,  where each element is distinct and satisfies . For each where , find any integer  such that  and print the value of  on a new line.

For example, assume the sequence . Each value of  between  and , the length of the sequence, is analyzed as follows:

, so
, so
, so
, so
, so
The values for  are .

Function Description

Complete the permutationEquation function in the editor below. It should return an array of integers that represent the values of .

permutationEquation has the following parameter(s):

p: an array of integers
Input Format

The first line contains an integer , the number of elements in the sequence.
The second line contains  space-separated integers  where .

Constraints

, where .
Each element in the sequence is distinct.
Output Format

For each  from  to , print an integer denoting any valid  satisfying the equation  on a new line.

Sample Input 0

3
2 3 1
Sample Output 0

2
3
1
Explanation 0

Given the values of , , and , we calculate and print the following values for each  from  to :

, so we print the value of  on a new line.
, so we print the value of  on a new line.
, so we print the value of  on a new line.
Sample Input 1

5
4 3 5 1 2
Sample Output 1

1
3
5
4
2

 */
public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];


        //
        for (int i = 0; i < p.length; i++) {

           // result[i] = p[p[p[p[i] - 1] - 1] - 1];
            result[p[p[p[i]-1]-1]-1] = p[i];
        }

        return result;

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutationEquation(new int[]{3, 1, 5, 4, 2})));
    }
}
