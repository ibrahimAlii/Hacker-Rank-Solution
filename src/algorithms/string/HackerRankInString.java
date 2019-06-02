package algorithms.string;

/**
 * We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank. For example, if string  it does contain hackerrank, but  does not. In the second case, the second r is missing. If we reorder the first string as , it no longer contains the subsequence due to ordering.
 * <p>
 * More formally, let  be the respective indices of h, a, c, k, e, r, r, a, n, k in string . If  is true, then  contains hackerrank.
 * <p>
 * For each query, print YES on a new line if the string contains hackerrank, otherwise, print NO.
 * <p>
 * Function Description
 * <p>
 * Complete the hackerrankInString function in the editor below. It must return YES or NO.
 * <p>
 * hackerrankInString has the following parameter(s):
 * <p>
 * s: a string
 * Input Format
 * <p>
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a single query string .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * For each query, print YES on a new line if  contains hackerrank, otherwise, print NO.
 * <p>
 * Sample Input 0
 * <p>
 * 2
 * hereiamstackerrank
 * hackerworld
 * Sample Output 0
 * <p>
 * YES
 * NO
 * Explanation 0
 * <p>
 * We perform the following  queries:
 * <p>
 * <p>
 * The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we print YES on a new line.
 * does not contain the last three characters of hackerrank, so we print NO on a new line.
 * Sample Input 1
 * <p>
 * 2
 * hhaacckkekraraannk
 * rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt
 * Sample Output 1
 * <p>
 * YES
 * NO
 */
public class HackerRankInString {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        char[] original = "hackerrank".toCharArray();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index == original.length)
                return "YES";
            if (s.charAt(i) == original[index]){
                index++;
            }
        }
        return index == original.length ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(hackerrankInString("hhaacckkekraraannk"));
        System.out.println(hackerrankInString("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"));
    }
}
