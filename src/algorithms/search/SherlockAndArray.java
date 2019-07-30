package algorithms.search;

import java.util.List;

/*
Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right. For instance, given the array ,  is between two subarrays that sum to . If your starting array is , that element satisfies the rule as left and right sum to .

You will be given arrays of integers and must determine whether there is an element that meets the criterion.

Function Description

Complete the balancedSums function in the editor below. It should return a string, either YES if there is an element meeting the criterion or NO otherwise.

balancedSums has the following parameter(s):

arr: an array of integers
Input Format

The first line contains , the number of test cases.

The next  pairs of lines each represent a test case.
- The first line contains , the number of elements in the array .
- The second line contains  space-separated integers  where .

Constraints





Output Format

For each test case print YES if there exists an element in the array, such that the sum of the elements on its left is equal to the sum of the elements on its right; otherwise print NO.

Sample Input 0

2
3
1 2 3
4
1 2 3 3
Sample Output 0

NO
YES
Explanation 0

For the first test case, no such index exists.
For the second test case, , therefore index  satisfies the given conditions.

Sample Input 1

3
5
1 1 4 1 1
4
2 0 0 0
4
0 0 2 0
Sample Output 1

YES
YES
YES
Explanation 1

In the first test case,  is between two subarrays summing to .
In the second case,  is between two subarrays summing to .
In the third case,  is between two subarrays summing to .
 */
public class SherlockAndArray {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        int[] sumFromRight = new int[arr.size()];
        int[] sumFromLeft = new int[arr.size()];

        if (arr.size() == 1)
            return "YES";

        int j = arr.size() - 1;
        for (int i = 0; j < arr.size() && j >= 0; i++, j--) {
            sumFromRight[j] = arr.get(j) + (j < arr.size() - 1 ? sumFromRight[j + 1] : 0);
            sumFromLeft[i] = arr.get(i) + (i > 0 ? sumFromLeft[i - 1] : 0);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                if (sumFromRight[i + 1] == 0)
                    return "YES";
            } else if (i == arr.size() - 1) {
                if (sumFromLeft[i - 1] == 0)
                    return "YES";
            } else if (sumFromLeft[i - 1] == sumFromRight[i + 1])
                return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(balancedSums(List.of(1, 2, 3)));
        System.out.println(balancedSums(List.of(1, 2, 3, 3)));
        System.out.println(balancedSums(List.of(1, 1, 4, 1, 1)));
        System.out.println(balancedSums(List.of(2, 0, 0, 0)));
        System.out.println(balancedSums(List.of(0, 0, 0, 2)));
        System.out.println(balancedSums(List.of(1, 0, 0, 2)));
        System.out.println(balancedSums(List.of(1)));
    }
}
