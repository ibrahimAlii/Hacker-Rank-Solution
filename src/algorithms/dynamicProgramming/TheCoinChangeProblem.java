package algorithms.dynamicProgramming;

import java.util.*;

/*
You are working at the cash counter at a fun-fair, and you have different types of coins available to you in infinite quantities. The value of each coin is already given. Can you determine the number of ways of making change for a particular number of units using the given types of coins?

For example, if you have  types of coins, and the value of each type is given as  respectively, you can make change for  units in three ways: , , and .

Function Description

Complete the getWays function in the editor below. It must return an integer denoting the number of ways to make change.

getWays has the following parameter(s):

n: an integer, the amount to make change for
c: an array of integers representing available denominations
Input Format

The first line contains two space-separated integers describing the respective values of  and , where:
 is the number of units
 is the number of coin types
The second line contains  space-separated integers describing the respective values of each coin type :  (the list of distinct coins available in infinite amounts).

Constraints

Each  is guaranteed to be distinct.
Hints

Solve overlapping subproblems using Dynamic Programming (DP):
You can solve this problem recursively but will not pass all the test cases without optimizing to eliminate the overlapping subproblems. Think of a way to store and reference previously computed solutions to avoid solving the same subproblem multiple times. * Consider the degenerate cases:
- How many ways can you make change for  cents? - How many ways can you make change for  cents if you have no coins? * If you're having trouble defining your solutions store, then think about it in terms of the base case . - The answer may be larger than a -bit integer.

Output Format

Print a long integer denoting the number of ways we can get a sum of  from the given infinite supply of  types of coins.

Sample Input 0

4 3
1 2 3
Sample Output 0

4
Explanation 0

There are four ways to make change for  using coins with values given by :

Thus, we print  as our answer.

Sample Input 1

10 4
2 5 3 6
Sample Output 1

5
Explanation 1

There are five ways to make change for  units using coins with values given by :

Thus, we print  as our answer.

 */
public class TheCoinChangeProblem {


    // Complete the getWays function below.
    static long getWays(long n, long[] c) {
        long[] numways = new long[(int) n + 1];
        numways[0] = 1; // init base case n=0

        // go thru coins 1-by-1 to build up numways[] dynamically
        // just need to consider cases where sum j>=c[i]
        for (int i = 0; i < c.length; i++) {
            for (int j = (int) c[i]; j <= n; j++) {
                // find numways to get sum j given value c[i]
                // it consists of those found earlier plus
                // new ones.
                // E.g. if c[]=1,2,3... and c[i]=3,j=5,
                //      new ones will now include '3' with
                //      numways[2] = 2, that is:
                //      '3' with '2', '3' with '1'+'1'
                numways[j] += numways[(int) (j - c[i])];
            }
        }

        return numways[(int) n];
    }


    public static void main(String[] args) {


//        System.out.println(getWays(3, new long[]{8, 3, 1, 2}));
//        System.out.println(getWays(4, new long[]{8, 3, 1, 2}));
        System.out.println(getWays(4, new long[]{1, 2, 3}));
        System.out.println(getWays(10, new long[]{2, 3, 5, 6}));
    }
}
