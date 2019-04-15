package algorithms.implementaions;

/*
Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

It must be greater than the original word
It must be the smallest word that meets the first condition
For example, given the word , the next largest word is .

Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.

Function Description

Complete the biggerIsGreater function in the editor below. It should return the smallest lexicographically higher string possible from the given string or no answer.

biggerIsGreater has the following parameter(s):

w: a string
Input Format

The first line of input contains , the number of test cases.
Each of the next  lines contains .

Constraints

 will contain only letters in the range ascii[a..z].
Output Format

For each test case, output the string meeting the criteria. If no answer exists, print no answer.

Sample Input 0

5
ab
bb
hefg
dhck
dkhc
Sample Output 0

ba
no answer
hegf
dhkc
hcdk
Explanation 0

Test case 1:
ba is the only string which can be made by rearranging ab. It is greater.
Test case 2:
It is not possible to rearrange bb and get a greater string.
Test case 3:
hegf is the next string greater than hefg.
Test case 4:
dhkc is the next string greater than dhck.
Test case 5:
hcdk is the next string greater than dkhc.
Sample Input 1

6
lmno
dcba
dcbb
abdc
abcd
fedcbabcd
Sample Output 1

lmon
no answer
no answer
acbd
abdc
fedcbabdc
 */

import java.io.*;
import java.util.Arrays;

public class BiggerIsGreater {

    static String biggerIsGreater(String w) {
        char[] arr = w.toCharArray();
        int i = arr.length - 1; // finding p --> i

        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0) {
            return "no answer";
        }
        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }
        char temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            char tem = arr[i];
            arr[i] = arr[j];
            arr[j] = tem;
            j--;
            i++;
        }
        String ret = new String(arr);
        return ret;
    }

    // Complete the biggerIsGreater function below.
//    static String biggerIsGreater(String w) {
//        char[] arr = w.toCharArray();
//        boolean swappedSuccess = false;
//        int index = 0;
//        for (int i = w.length() - 1; i > 0; i--) {
//            for (int j = i; j >= 0; j--) {
//                if (w.charAt(i) > w.charAt(j)) {
//                    char d = w.charAt(j);
//                    arr[j] = arr[i];
//                    arr[i] = d;
//                    index = j;
//                    swappedSuccess = true;
//                    break;
//                }
//            }
//            if (swappedSuccess)
//                break;
//        }
//        if (!swappedSuccess)
//            return "no answer";
//        Arrays.sort(arr, index + 1, w.length());
//        return new String(arr);
//    }


    public static void main(String[] args) {

//        System.out.println(biggerIsGreater("bb"));
//        System.out.println(biggerIsGreater("dcba"));
//        System.out.println(biggerIsGreater("dcbb"));
//        System.out.println(biggerIsGreater("abdc"));
//        System.out.println(biggerIsGreater("abcd"));
//        System.out.println(biggerIsGreater("fedcbabcd"));
//        System.out.println(biggerIsGreater("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw"));
//        System.out.println(biggerIsGreater("zyyxwwtrrnmlggfeb"));
        //System.out.println(biggerIsGreater("yriecnu")); // yriecun    yricuen


        BufferedReader br_case = null;
        BufferedReader br_result = null;
        try {
            br_case = new BufferedReader(new FileReader(new File("C:\\Users\\Ibrahim\\Desktop\\projects\\Hacker-Rank-Solution\\src\\algorithms\\test_case_for_bigger_is_greater.txt")));
            br_result = new BufferedReader(new FileReader("C:\\Users\\Ibrahim\\Desktop\\projects\\Hacker-Rank-Solution\\src\\algorithms\\result_for_bigger_is_greater.txt"));

            String st, result;
            while ((st = br_case.readLine()) != null && (result = br_result.readLine()) != null)
                if (!biggerIsGreater(st).equals(result))
                    System.out.println(biggerIsGreater(st) + "  ||  " + st + "  ||  " + result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

