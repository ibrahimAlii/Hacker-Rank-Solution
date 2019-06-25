package algorithms.string;

import java.util.Arrays;

/**
 * We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 *
 * Alice is taking a cryptography class and finding anagrams to be very useful. She decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?
 *
 * Given two strings,  and , that may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
 *
 * For example,  and . The only characters that match are the 's so we have to remove  from  and  from  for a total of  deletions.
 *
 * Function Description
 *
 * Complete the makingAnagrams function in the editor below. It should return an integer representing the minimum number of deletions needed to make the strings anagrams.
 *
 * makingAnagrams has the following parameter(s):
 *
 * s1: a string
 * s2: a string
 * Input Format
 *
 * The first line contains a single string, .
 * The second line contains a single string, .
 *
 * Constraints
 *
 * It is guaranteed that  and  consist of lowercase English letters, ascii[a-z].
 * Output Format
 *
 * Print a single integer denoting the minimum number of characters which must be deleted to make the two strings anagrams of each other.
 *
 * Sample Input
 *
 * cde
 * abc
 * Sample Output
 *
 * 4
 * Explanation
 *
 * We delete the following characters from our two strings to turn them into anagrams of each other:
 *
 * Remove d and e from cde to get c.
 * Remove a and b from abc to get c.
 * We had to delete  characters to make both strings anagrams.
 */
public class MakingAnagrams {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        int[] firstArr = new int[26];
        int[] secondArr = new int[26];


        for (int i = 0; i < s1.length(); i++) {
            firstArr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            secondArr[s2.charAt(i) - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(firstArr[i] - secondArr[i]);
        }

        return result;
    }

    public static void main(String[] args){

        System.out.println(makingAnagrams("cde", "abc"));
    }
}
