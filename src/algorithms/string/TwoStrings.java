package algorithms.string;

/**
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 * <p>
 * For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.
 * <p>
 * Function Description
 * <p>
 * Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.
 * <p>
 * twoStrings has the following parameter(s):
 * <p>
 * s1, s2: two strings to analyze .
 * Input Format
 * <p>
 * The first line contains a single integer , the number of test cases.
 * <p>
 * The following  pairs of lines are as follows:
 * <p>
 * The first line contains string .
 * The second line contains string .
 * Constraints
 * <p>
 * and  consist of characters in the range ascii[a-z].
 * Output Format
 * <p>
 * For each pair of strings, return YES or NO.
 * <p>
 * Sample Input
 * <p>
 * 2
 * hello
 * world
 * hi
 * world
 * Sample Output
 * <p>
 * YES
 * NO
 * Explanation
 * <p>
 * We have  pairs to check:
 * <p>
 * , . The substrings  and  are common to both strings.
 * , .  and  share no common substrings.
 */
public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int[] firstArr = new int[26];
        int[] secondArr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            firstArr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            secondArr[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (firstArr[i] != 0 && secondArr[i] != 0)
                return "YES";
        }
        return "NO";
    }


    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }
}
