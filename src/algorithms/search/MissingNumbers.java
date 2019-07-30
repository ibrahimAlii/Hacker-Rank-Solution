package algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Numeros the Artist had two lists that were permutations of one another. He was very proud. Unfortunately, while transporting them from one exhibition to another, some numbers were lost out of the first list. Can you find the missing numbers?

As an example, the array with some numbers missing, . The original array of numbers . The numbers missing are .

Notes

If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in the second list is less than or equal to .
Function Description

Complete the missingNumbers function in the editor below. It should return a sorted array of missing numbers.

missingNumbers has the following parameter(s):

arr: the array with missing numbers
brr: the original array of numbers
Input Format

There will be four lines of input:

 - the size of the first list,
The next line contains  space-separated integers
 - the size of the second list,
The next line contains  space-separated integers

Constraints

Output Format

Output the missing numbers in ascending order.

Sample Input

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output

204 205 206
Explanation

 is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and  occur twice in , but three times in . The rest of the numbers have the same frequencies in both lists.
 */
public class MissingNumbers {

    static int[] missingNumbers(int[] arr, int[] brr) {
        int[] result = new int[brr.length - arr.length];
        HashMap<Integer, Integer> arrMap = new HashMap<>();
        HashMap<Integer, Integer> brrMap = new HashMap<>();

        for (int i = 0; i < brr.length; i++) {
            brrMap.merge(brr[i], 1, Integer::sum);
            if (i < arr.length)
                arrMap.merge(arr[i], 1, Integer::sum);
        }

        final int[] index = {0};
        brrMap.keySet().forEach((key) -> {
            if (arrMap.get(key) != null){
                if (brrMap.get(key) > arrMap.get(key)){
                    for (int i = 0; i < brrMap.get(key) - arrMap.get(key); i++) {
                        result[index[0]++] = key;
                    }
                }
            }else {
                for (int i = 0; i < brrMap.get(key); i++) {
                    result[index[0]++] = key;
                }
            }
        });
        return Arrays.stream(result).distinct().toArray();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(input.readLine());
        int[] arr = new int[size];
        String[] arrr = input.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(arrr[i]);
        }
        int size1 = Integer.parseInt(input.readLine());
        int[] arr2 = new int[size1];
        String[] arrr2 = input.readLine().split(" ");
        for (int i = 0; i < size1; i++) {
            arr2[i] = Integer.parseInt(arrr2[i]);
        }

        System.out.println(Arrays.toString(missingNumbers(arr, arr2)));
    }
}
