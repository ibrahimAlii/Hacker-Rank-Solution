package datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:

If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set ,  is the median.
If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set ,  is the median.
Given an input stream of  integers, you must perform the following task for each  integer:

Add the  integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the  element).
Print the list's updated median on a new line. The printed value must be a double-precision number scaled to  decimal place (i.e.,  format).
Input Format

The first line contains a single integer, , denoting the number of integers in the data stream.
Each line  of the  subsequent lines contains an integer, , to be added to your list.

Constraints

Output Format

After each new integer is added to the list, print the list's updated median on a new line as a single double-precision number scaled to  decimal place (i.e.,  format).

Sample Input

6
12
4
5
3
8
7
Sample Output

12.0
8.0
5.0
4.5
5.0
6.0
Explanation

There are  integers, so we must print the new median on a new line as each integer is added to the list:



 */
public class FindTheRunningMedian {


    static double[] runningMedian(int[] a) {
        Heap queue = new Heap();

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            queue.insertSequential(a[i]);

            if (queue.size() % 2 == 0) {
                result[i] = (double) (queue.getElementAt(queue.size() / 2 -1) + queue.getElementAt(queue.size() / 2)) / 2;
            } else {
                result[i] = queue.getElementAt(queue.size() / 2);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningMedian(new int[]{12, 4, 5, 3, 8, 7})));
    }

}
