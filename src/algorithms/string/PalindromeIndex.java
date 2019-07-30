package algorithms.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Given a string of lowercase letters in the range ascii[a-z], determine a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. For example, if your string is "bcbc", you can either remove 'b' at index  or 'c' at index . If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.
 * <p>
 * Function Description
 * <p>
 * Complete the palindromeIndex function in the editor below. It must return the index of the character to remove or .
 * <p>
 * palindromeIndex has the following parameter(s):
 * <p>
 * s: a string to analyze
 * Input Format
 * <p>
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a query string .
 * <p>
 * Constraints
 * <p>
 * All characters are in the range ascii[a-z].
 * Output Format
 * <p>
 * Print an integer denoting the zero-indexed position of the character to remove to make  a palindrome. If  is already a palindrome or no such character exists, print .
 * <p>
 * Sample Input
 * <p>
 * 3
 * aaab
 * baa
 * aaa
 * Sample Output
 * <p>
 * 3
 * 0
 * -1
 * Explanation
 * <p>
 * Query 1: "aaab"
 * Removing 'b' at index  results in a palindrome, so we print  on a new line.
 * <p>
 * Query 2: "baa"
 * Removing 'b' at index  results in a palindrome, so we print  on a new line.
 * <p>
 * Query 3: "aaa"
 * This string is already a palindrome, so we print . Removing any one of the characters would result in a palindrome, but this test comes first.
 * <p>
 * Note: The custom checker logic for this challenge is available here.
 */
public class PalindromeIndex {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i + 1) != s.charAt(j))
                    return j;
                else if (s.charAt(i) != s.charAt(j - 1))
                    return i;
                else {
                    if (s.charAt(i + 2) != s.charAt(j - 1))
                        return j;
                    if (s.charAt(i + 1) != s.charAt(j - 2))
                        return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {


        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
//        System.out.println(palindromeIndex("bcb"));
//        System.out.println(palindromeIndex("aaa"));
    }

}
