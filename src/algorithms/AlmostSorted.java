package algorithms;

import java.util.Arrays;

/*
Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.

Swap two elements.
Reverse one sub-segment.
Determine whether one, both or neither of the operations will complete the task. If both work, choose swap. For instance, given an array  either swap the  and , or reverse them to sort the array. Choose swap. The Output Format section below details requirements.

Function Description

Complete the almostSorted function in the editor below. It should print the results and return nothing.

almostSorted has the following parameter(s):

arr: an array of integers
Input Format

The first line contains a single integer , the size of .
The next line contains  space-separated integers  where .

Constraints



All  are distinct.

Output Format

If the array is already sorted, output yes on the first line. You do not need to output anything else.

If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:

a. If elements can be swapped,  and , output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the array is indexed from  to .

b. Otherwise, when reversing the segment , output reverse l r in the second line.  and  are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from  to .

 represents the sub-sequence of the array, beginning at index  and ending at index , both inclusive.

If an array can be sorted by either swapping or reversing, choose swap.

If you cannot sort the array either way, output no on the first line.
Sample Input 1

2
4 2
Sample Output 1

yes
swap 1 2
Explanation 1

You can either swap(1, 2) or reverse(1, 2). You prefer swap.

Sample Input 2

3
3 1 2
Sample Output 2

no
Explanation 2

It is impossible to sort by one single operation.

Sample Input 3

6
1 5 4 3 2 6
Sample Output 3

yes
reverse 2 5
Explanation 3

You can reverse the sub-array d[2...5] = "5 4 3 2", then the array becomes sorted.

 */
public class AlmostSorted {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        int swappedElements = 0;
        boolean ableToSwap = true;
        int firstIndex = 0;
        int lastIndex = 0;
        int element = 0;
        int[] swapArr = arr.clone();


        for (int i = 0; i < swapArr.length - 1; i++) {
            if (swapArr[i] > swapArr[i + 1]) {


                swappedElements++;
                if (swappedElements > 1) {
                    ableToSwap = false;
                    break;
                }

                // check for low value first
                if (i + 2 < swapArr.length) {
                    for (int j = i + 1; j < swapArr.length; j++) {
                        if (swapArr[i] < swapArr[j]) {
                            element = swapArr[i];
                            swapArr[i] = swapArr[j - 1];
                            swapArr[j - 1] = element;
                            firstIndex = i + 1;
                            lastIndex = j;
                            i = -1;
                            break;

                        }
                    }
                } else {
                    element = swapArr[i];
                    swapArr[i] = swapArr[i + 1];
                    swapArr[i + 1] = element;
                    firstIndex = i + 1;
                    lastIndex = i + 2;
                }


            }
        }

        boolean savedFirstIndex = false;
        if (ableToSwap) {
            if (firstIndex == 0 || lastIndex == 0) {
                System.out.println("no");
                return;
            }
            System.out.println("yes\nswap " + firstIndex + " " + lastIndex);
            return;
        } else {
            // try reverse
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    if (!savedFirstIndex) {
                        firstIndex = i;
                        savedFirstIndex = true;
                    }

                    if (arr[i] < arr[i + 1]) {
                        lastIndex = i + 1;
                        break;
                    } else {
                        lastIndex = i + 1;
                    }
                }
            }
        }

        int d = lastIndex;
        int eleme = 0;
        for (int i = firstIndex; i <= d; i++) {
            eleme = arr[i];
            arr[i] = arr[d];
            arr[d] = eleme;
            d--;
        }


        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("no");
                return;
            }

        }

        System.out.println("yes\nreverse " + (firstIndex + 1) + " " + (lastIndex + 1));

    }

    public static void main(String[] args) {
        almostSorted(new int[]{1, 2 ,6, 4 ,7, 3, 8, 9});
        System.out.println();
        almostSorted(new int[]{3, 1, 2});
        System.out.println();
        almostSorted(new int[]{1, 5, 4, 3, 2, 6});
        System.out.println();
        almostSorted(new int[]{43, 65, 1, 98, 99, 101});
        System.out.println();
        almostSorted(new int[]{1, 2, 4 ,3, 5, 6});
        System.out.println();
        almostSorted(new int[]{4104, 8529, 49984, 54956, 63034, 82534, 84473, 86411, 92941, 95929, 108831, 894947, 125082,
                137123, 137276, 142534, 149840, 154703, 174744, 180537, 207563, 221088, 223069, 231982, 249517, 252211, 255192,
                260283, 261543, 262406, 270616, 274600, 274709, 283838, 289532, 295589, 310856, 314991, 322201, 339198, 343271, 383392,
                385869, 389367, 403468, 441925, 444543, 454300, 455366, 469896, 478627, 479055, 484516, 499114, 512738, 543943, 552836, 560153,
                578730, 579688, 591631, 594436, 606033, 613146, 621500, 627475, 631582, 643754, 658309, 666435, 667186, 671190, 674741, 685292,
                702340, 705383, 722375, 722776, 726812, 748441, 790023, 795574, 797416, 813164, 813248, 827778, 839998, 843708, 851728,
                857147, 860454, 861956, 864994, 868755, 116375, 911042, 912634, 914500, 920825, 979477});
    }
}
