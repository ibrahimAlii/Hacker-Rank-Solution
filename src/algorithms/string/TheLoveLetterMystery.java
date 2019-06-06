package algorithms.string;

/**
 * James found a love letter that his friend Harry has written to his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.
 * <p>
 * To do this, he follows two rules:
 * <p>
 * He can only reduce the value of a letter by , i.e. he can change d to c, but he cannot change c to d or d to b.
 * The letter a may not be reduced any further.
 * Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.
 * <p>
 * For example, given the string , the following two operations are performed: cde → cdd → cdc.
 * <p>
 * Function Description
 * <p>
 * Complete the theLoveLetterMystery function in the editor below. It should return the integer representing the minimum number of operations needed to make the string a palindrome.
 * <p>
 * theLoveLetterMystery has the following parameter(s):
 * <p>
 * s: a string
 * Input Format
 * <p>
 * The first line contains an integer , the number of queries.
 * The next  lines will each contain a string .
 * <p>
 * Constraints
 * <p>
 * <p>
 * | s |
 * All strings are composed of lower case English letters, *ascii[a-z], with no spaces.
 * <p>
 * Output Format
 * <p>
 * A single line containing the minimum number of operations corresponding to each test case.
 * <p>
 * Sample Input
 * <p>
 * 4
 * abc
 * abcba
 * abcd
 * cba
 * Sample Output
 * <p>
 * 2
 * 0
 * 4
 * 2
 * Explanation
 * <p>
 * For the first test case, abc → abb → aba.
 * For the second test case, abcba is already a palindromic string.
 * For the third test case, abcd → abcc → abcb → abca → abba.
 * For the fourth test case, cba → bba → aba.
 */
public class TheLoveLetterMystery {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int replacement = 0;
        int size = s.length() / 2;
        if (s.length() % 2 != 0)
            size++;
        int index = 0;
        for (int i = s.length() - 1; i >= size; i--) {
            int v1 = ((int) s.charAt(index) - 'a');
            int v2 = ((int) s.charAt(i) - 'a');
            replacement += Math.abs(v1 - v2);
            index++;
        }
        return replacement;
    }

    public static void main(String[] args) {
        System.out.println(theLoveLetterMystery("abc"));
        System.out.println(theLoveLetterMystery("abcba"));
        System.out.println(theLoveLetterMystery("abcd"));
        System.out.println(theLoveLetterMystery("cba"));
        System.out.println(theLoveLetterMystery("adslkfjas"));
        System.out.println(theLoveLetterMystery("bafhaef"));
    }

}
