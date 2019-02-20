package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Input Format

The first line contains an integer , the number of socks represented in .
The second line contains  space-separated integers describing the colors  of the socks in the pile.

Constraints

 where
Output Format

Return the total number of matching pairs of socks that John can sell.

Sample Input

9
10 20 20 10 10 30 50 10 20
Sample Output

3
Explanation

sock.png

John can match three pairs of socks.
 */
public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> pairs = new HashMap<>();
        int sumOfPairs = 0;
        int initVal = 0;

        for (int i = 0; i < ar.length; i++) {
//            if (pairs.get(ar[i]) == null || pairs.get(i) < 1)
//                pairs.add(ar[i], 0);
            if (pairs.get(ar[i]) == null)
                initVal = 0;
            else initVal = pairs.get(ar[i]);
            pairs.put(ar[i], initVal + 1);
            //pairs.add(ar[i], (pairs.get(i) + 1));
        }

        for (int i = 0; i < ar.length; i++) {
            if (pairs.get(ar[i]) >= 2) {
                sumOfPairs += pairs.get(ar[i]) / 2;

                if (!isEven(pairs.get(ar[i])))
                    sumOfPairs--;
            }

        }

        return sumOfPairs;
    }

    static boolean isEven(int n ){
        return n % 2 == 0;
    }

    public static void main(String[] args) {

        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }
}
