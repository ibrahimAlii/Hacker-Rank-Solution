package algorithms.string;

/**
 * Steve has a string of lowercase characters in range ascii[‘a’..’z’]. He wants to reduce the string to its shortest length by doing a series of operations. In each operation he selects a pair of adjacent lowercase letters that match, and he deletes them. For instance, the string aab could be shortened to b in one operation.
 * <p>
 * Steve’s task is to delete as many characters as possible using this method and print the resulting string. If the final string is empty, print Empty String
 * <p>
 * Function Description
 * <p>
 * Complete the superReducedString function in the editor below. It should return the super reduced string or Empty String if the final string is empty.
 * <p>
 * superReducedString has the following parameter(s):
 * <p>
 * s: a string to reduce
 * Input Format
 * <p>
 * A single string, .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * If the final string is empty, print Empty String; otherwise, print the final non-reducible string.
 * <p>
 * Sample Input 0
 * <p>
 * aaabccddd
 * Sample Output 0
 * <p>
 * abd
 * Explanation 0
 * <p>
 * Steve performs the following sequence of operations to get the final string:
 * <p>
 * aaabccddd → abccddd → abddd → abd
 * Sample Input 1
 * <p>
 * aa
 * Sample Output 1
 * <p>
 * Empty String
 * Explanation 1
 * <p>
 * aa → Empty String
 * Sample Input 2
 * <p>
 * baab
 * Sample Output 2
 * <p>
 * Empty String
 * Explanation 2
 * <p>
 * baab → bb → Empty String
 */
public class SuperReducedString {


    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        StringBuilder result = new StringBuilder(s);
        for (int i = 1; i < result.length(); i++) {
            if (result.charAt(i) == result.charAt(i - 1)) {
                result.delete(i - 1, i + 1);
                i = 0;
            }
        }

        return result.toString().isEmpty() ? "Empty String" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(superReducedString("aa"));
        System.out.println(superReducedString("baab"));
        System.out.println(superReducedString("aaabccaddd"));
    }
}
