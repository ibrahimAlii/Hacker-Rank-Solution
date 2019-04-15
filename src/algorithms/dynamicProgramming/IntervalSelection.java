package algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a set of  intervals, find the size of its largest possible subset of intervals such that no three intervals in the subset share a common point.

Input Format

The first line contains an integer, , denoting the number of interval sets you must find answers for. The subsequent lines describe each of the  interval sets as follows:

The first line contains an integer, , denoting the number of intervals in the list.
Each line  of the  subsequent lines contains two space-separated integers describing the respective starting () and ending () boundaries of an interval.
Constraints

Output Format

For each of the  interval sets, print an integer denoting the size of the largest possible subset of intervals in the given set such that no three points in the subset overlap.

Sample Input

4
3
1 2
2 3
2 4
3
1 5
1 5
1 5
4
1 10
1 3
4 6
7 10
4
1 10
1 3
3 6
7 10
Sample Output

2
2
4
3
Explanation

For set , all three intervals fall on point  so we can only choose any  of the intervals. Thus, we print  on a new line.

For set , all three intervals span the range from  to  so we can only choose any  of them. Thus, we print  on a new line.

For set , we can choose all  intervals without having more than two of them overlap at any given point. Thus, we print  on a new line.

For set , the intervals , , and  all overlap at point , so we must only choose  of these intervals to combine with the last interval, , for a total of  qualifying intervals. Thus, we print  on a new line.

 */
public class IntervalSelection {


    static int intervalSelection(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]));
        int count = 0;
        int[][] busy = new int[2][2];

        for (int[] x : intervals) {
            if (x[0] > busy[1][1]) {
                ++count;
                busy[1] = x;
            } else if (x[0] > busy[0][1]) {
                ++count;
                busy[0] = x;
                if (x[1] > busy[1][1]) {
                    int[] temp = busy[0];
                    busy[0] = busy[1];
                    busy[1] = temp;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(intervalSelection(new int[][]{
                {1, 2},
                {2, 3},
                {2, 4}
        }));
    }
}
