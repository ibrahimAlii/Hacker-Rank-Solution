package algorithms.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Madam Hannah Otto, the CEO of Reviver Corp., is fond of palindromes, or words that read the same forwards or backwards. She thinks palindromic brand names are appealing to millennials.
 * <p>
 * As part of the marketing campaign for the company's new juicer called the Rotator™, Hannah decided to push the marketing team's palindrome-searching skills to a new level with a new challenge.
 * <p>
 * In this challenge, Hannah provides a string  consisting of lowercase English letters. Every day, for  days, she would select two integers  and , take the substring  (the substring of  from index  to index ), and ask the following question:
 * <p>
 * Consider all the palindromes that can be constructed from some of the letters from . You can reorder the letters as you need. Some of these palindromes have the maximum length among all these palindromes. How many maximum-length palindromes are there?
 * <p>
 * For example, if ,  and , then we have,
 * <p>
 * image
 * <p>
 * Your job as the head of the marketing team is to answer all the queries. Since the answers can be very large, you are only required to find the answer modulo .
 * <p>
 * Complete the functions initialize and answerQuery and return the number of maximum-length palindromes modulo .
 * <p>
 * Input Format
 * <p>
 * The first line contains the string .
 * <p>
 * The second line contains a single integer .
 * <p>
 * The  of the next  lines contains two space-separated integers ,  denoting the  and  values Anna selected on the day.
 * <p>
 * Constraints
 * <p>
 * Here,  denotes the length of .
 * <p>
 * Subtasks
 * <p>
 * For 30% of the total score:
 * <p>
 * For 60% of the total score:
 * <p>
 * Output Format
 * <p>
 * For each query, print a single line containing a single integer denoting the answer.
 * <p>
 * Sample Input 0
 * <p>
 * week
 * 2
 * 1 4
 * 2 3
 * Sample Output 0
 * <p>
 * 2
 * 1
 * Explanation 0
 * <p>
 * On the first day,  and . The maximum-length palindromes are "ewe" and "eke".
 * <p>
 * On the second day,  and . The maximum-length palindrome is "ee".
 * <p>
 * image
 * <p>
 * Sample Input 1
 * <p>
 * abab
 * 1
 * 1 4
 * Sample Output 1
 * <p>
 * 2
 * Explanation 1
 * <p>
 * Here, the maximum-length palindromes are "abba" and "baab".
 */
public class MaximumPalindromes {

    static int answerQuery(int l, int r, int prefix[][])
    {

        // 0-based indexing
        l--;
        r--;

        // Marks if there is an
        // odd frequency character
        boolean flag = false;

        // Length of the longest palindrome
        // possible from characters in range
        int count = 0;

        // Traverse for all characters
        // and count their frequencies
        for (int i = 0; i < 26; i++)
        {

            // Find the frequency in range 1 - r
            int cnt = prefix[r][i];

            // Exclude the frequencies in range 1 - (l - 1)
            if (l > 0)
                cnt -= prefix[l - 1][i];

            // If frequency is odd, then add 1 less than
            // the original frequency to make it even
            if (cnt % 2 == 1)
            {
                flag = true;
                count += cnt - 1;
            }

            // Else completely add if even
            else
                count += cnt;
        }

        // If any odd frequency character
        // is present then add 1
        if (flag)
            count += 1;

        return count;
    }

    // Fucntion to pre-calculate the frequencies
// of the characters to reduce complexity
    static void initialize(String s, int prefix[][])
    {
        int n = s.length();

        // Iterate and increase the count
        for (int i = 0; i < n; i++)
        {
            prefix[i][s.charAt(i) - 'a']++;
        }

        // Create a prefix type array
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < 26; j++)
                prefix[i][j] += prefix[i - 1][j];
        }
    }


    public static void main(String[] args) {

        String s = "madamimadam";
        int[][] prefix = new int[s.length()][26];

        initialize(s, prefix);
    }
}
