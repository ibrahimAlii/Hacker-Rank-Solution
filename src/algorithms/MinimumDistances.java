package algorithms;


/*
We define the distance between two array values as the number of indices between the two values. Given , find the minimum distance between any pair of equal elements in the array. If no such value exists, print .

For example, if , there are two matching pairs of values: . The indices of the 's are  and , so their distance is . The indices of the 's are  and , so their distance is .

Function Description

Complete the minimumDistances function in the editor below. It should return the minimum distance between any two matching elements.

minimumDistances has the following parameter(s):

a: an array of integers
Input Format

The first line contains an integer , the size of array .
The second line contains  space-separated integers .

Constraints

Output Format

Print a single integer denoting the minimum  in . If no such value exists, print .

Sample Input

6
7 1 3 4 1 7
Sample Output

3
Explanation
Here, we have two options:

 and  are both , so .
 and  are both , so .
The answer is .

 */
public class MinimumDistances {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j] && j - i < minimumDistance)
                    minimumDistance = j - i;
            }
        }

        return minimumDistance == Integer.MAX_VALUE ? - 1 : minimumDistance;
    }


    public static void main(String[] args){
        System.out.println(minimumDistances(new int[]{7, 1, 3, 4, 1, 7}));
    }
}
