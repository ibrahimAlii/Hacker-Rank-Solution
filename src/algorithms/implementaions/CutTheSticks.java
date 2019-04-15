package algorithms.implementaions;

import java.util.*;

/*
You are given a number of sticks of varying lengths. You will iteratively cut the sticks into smaller sticks, discarding the shortest pieces until there are none left. At each iteration you will determine the length of the shortest stick remaining, cut that length from each of the longer sticks and then discard all the pieces of that shortest length. When all the remaining sticks are the same length, they cannot be shortened so discard them.

Given the lengths of  sticks, print the number of sticks that are left before each iteration until there are none left.

For example, there are  sticks of lengths . The shortest stick length is , so we cut that length from the longer two and discard the pieces of length . Now our lengths are . Again, the shortest stick is of length , so we cut that amount from the longer stick and discard those pieces. There is only one stick left, , so we discard that stick. Our lengths are .

Function Description

Complete the cutTheSticks function in the editor below. It should return an array of integers representing the number of sticks before each cut operation is performed.

cutTheSticks has the following parameter(s):

arr: an array of integers representing the length of each stick
Input Format

The first line contains a single integer , the size of .
The next line contains  space-separated integers, each an  where each value represents the length of the  stick.

Output Format

For each operation, print the number of sticks that are present before the operation on separate lines.

Constraints

Sample Input 0

6
5 4 4 2 2 8
Sample Output 0

6
4
2
1
Explanation 0

sticks-length        length-of-cut   sticks-cut
5 4 4 2 2 8             2               6
3 2 2 _ _ 6             2               4
1 _ _ _ _ 4             1               2
_ _ _ _ _ 3             3               1
_ _ _ _ _ _           DONE            DONE
Sample Input 1

8
1 2 3 4 3 3 2 1
Sample Output 1

8
6
4
1
Explanation 1

sticks-length         length-of-cut   sticks-cut
1 2 3 4 3 3 2 1         1               8
_ 1 2 3 2 2 1 _         1               6
_ _ 1 2 1 1 _ _         1               4
_ _ _ 1 _ _ _ _         1               1
_ _ _ _ _ _ _ _       DONE            DONE

 */
public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> data = new ArrayList<>();
        Arrays.sort(arr);
        int minimum = arr[0];
        int i = 0, j = 0;
        int wholeLength = arr.length;
        data.add(arr.length);
        while (i < arr.length) {
            for (; j < arr.length; j++) {
                arr[j] -= minimum;
                if (arr[j] < 1) {
                    wholeLength--;
                    i++;

                }
            }
            j = i;
            if (wholeLength == 0)
                break;
            data.add(wholeLength);
        }

        int[] result = new int[data.size()];
        for (int k = 0; k < data.size(); k++) {
                result[k] = data.get(k);
        }
        return result;

//        Map<Integer, Integer> count = new HashMap<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            if (count.get(arr[i]) == null) {
//                count.put(arr[i], 1);
//            } else {
//                count.put(arr[i], count.get(arr[i]) + 1);
//            }
//        }
//        List<Integer> sortedKeysList = new ArrayList<>(count.keySet());
//        Collections.sort(sortedKeysList);
//        int[] result = new int[sortedKeysList.size()];
//        result[0] = arr.length;
//        int length = arr.length;
//        for (int i = 1; i < sortedKeysList.size(); i++) {
//            length -= count.get(sortedKeysList.get(i - 1));
//            result[i] = length;
//        }
//        return result;
    }


    public static void main(String[] args) {

        //System.out.println(Arrays.toString(cutTheSticks(new int[]{1, 2, 3, 4, 3, 3, 2, 1})));
        //System.out.println(Arrays.toString(cutTheSticks(new int[]{1, 2, 3})));
        //System.out.println(Arrays.toString(cutTheSticks(new int[]{ 8, 7, 6, 4, 3, 2})));
        //System.out.println(Arrays.toString(cutTheSticks(new int[]{8, 8, 14 ,10, 3, 5 ,14 ,12})));
        System.out.println(Arrays.toString(cutTheSticks(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 45})));
        //System.out.println(Arrays.toString(cutTheSticks(new int[]{5, 4, 4, 2, 2, 8})));
    }
}
