package algorithms;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntPredicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Given a set of distinct integers, print the size of a maximal subset of  where the sum of any  numbers in  is not evenly divisible by .

For example, the array  and . One of the arrays that can be created is . Another is . After testing all permutations, the maximum length solution array has elements.

Function Description

Complete the nonDivisibleSubset function in the editor below. It should return an integer representing the length of the longest subset of  meeting the criteria.

nonDivisibleSubset has the following parameter(s):

S: an array of integers
k: an integer
Input Format

The first line contains  space-separated integers,  and , the number of values in  and the non factor.
The second line contains  space-separated integers describing , the unique values of the set.

Constraints

All of the given numbers are distinct.
Output Format

Print the size of the largest possible subset ().

Sample Input

4 3
1 7 2 4
Sample Output

3
Explanation

The sums of all permutations of two elements from  are:

1 + 7 = 8
1 + 2 = 3
1 + 4 = 5
7 + 2 = 9
7 + 4 = 11
2 + 4 = 6
We see that only  will not ever sum to a multiple of .

 */
public class NonDivisibleSubset {

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
//        if (k == 0 || k == 1)
//            return 1;
//
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        Arrays.stream(S)
//                .map(x -> x % k)
//                .forEach(a -> map.put(a, map.get(a) == null ? 1 : map.get(a) + 1));
//
//
//        map.forEach((key, value) -> map.entrySet().forEach(item -> {
//            if (!key.equals(item.getKey()))
//                if (key + item.getKey() == k) {
//                    if (value >= item.getValue()) {
//                        item.setValue(0);
//                    }
//                }
//        }));
//
//        return map.entrySet().stream().filter(x -> x.getValue() > 0).mapToInt(Map.Entry::getValue).sum() + ((k % 2) == 0 ? 1 : 0);

        int[] arr = new int[k];
        for (int i = 0; i < S.length; i++) {
            arr[S[i] % k]++;
        }
        int result = 0;
        result += Math.min(arr[0], 1);//If no number wholly divisible dont add it to pair else add once
        for (int j = 1; j <= k / 2; j++) if (j != k - j) result += Math.max(arr[j], arr[k - j]);

        return result + ((k % 2 == 0) ? 1 : 0 /*it will not have any conjugate pair */);
    }


    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(13, new int[]{2375782, 21836421, 2139842193, 2138723, 23816, 21836219, 2948784, 43864923, 283648327, 23874673})); // 7
        System.out.println(nonDivisibleSubset(3, new int[]{1, 7, 2, 4})); // 3
        System.out.println(nonDivisibleSubset(4, new int[]{9, 10, 12, 10, 24, 25, 22})); //4
        System.out.println(nonDivisibleSubset(7, new int[]{278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436})); // 11
        // System.out.println(4 % 3);
    }
}
