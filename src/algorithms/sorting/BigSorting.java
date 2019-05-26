package algorithms.sorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Consider an array of numeric strings where each string is a positive number with anywhere from  to  digits. Sort the array's elements in non-decreasing, or ascending order of their integer values and print each element of the sorted array on a new line.

Function Description

Complete the bigSorting function in the editor below. It should return the sorted string array.

bigSorting has the following parameter(s):

unsorted: an unsorted array of integers as strings
Input Format

The first line contains an integer, , denoting the number of strings in .
Each of the  subsequent lines contains an integer string .

Constraints

Each string is guaranteed to represent a positive integer without leading zeros.
The total number of digits across all strings in  is between  and  (inclusive).
Output Format

Print each element of the sorted array on a new line.

Sample Input 0

6
31415926535897932384626433832795
1
3
10
3
5
Sample Output 0

1
3
3
5
10
31415926535897932384626433832795
Explanation 0

The initial array of strings is . When we order each string by the real-world integer value it represents, we get:

We then print each value on a new line, from smallest to largest.

Sample Input 1

8
1
2
100
12303479849857341718340192371
3084193741082937
3084193741082938
111
200
Sample Output 1

1
2
100
111
200
3084193741082937
3084193741082938
12303479849857341718340192371
 */
public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        //  Note you need faster reader to pass time limit problems
        Arrays.sort(unsorted, 0, unsorted.length, (o1, o2) -> {
            if (o1.length() > o2.length())
                return 1;
            else if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else return -1;

        });
        return unsorted;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(bigSorting(new String[]{"3", "1", "2", "31415926535897932384626433832795", "0", "31415926535897122384626433832795"})));
    }
}
