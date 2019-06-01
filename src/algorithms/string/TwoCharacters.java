package algorithms.string;

/**
 * In this challenge, you will be given a string. You must remove characters until the string is made up of any two alternating characters.
 * When you choose a character to remove, all instances of that character must be removed. Your goal is to create the longest string possible that contains just two alternating letters.
 * <p>
 * As an example, consider the string abaacdabd. If you delete the character a, you will be left with the string bcdbd.
 * Now, removing the character c leaves you with a valid string bdbd having a length of 4. Removing either b or d at any point would not result in a valid string.
 * <p>
 * Given a string , convert it to the longest possible string  made up only of alternating characters. Print the length of string  on a new line.
 * If no string  can be formed, print  instead.
 * <p>
 * Function Description
 * <p>
 * Complete the alternate function in the editor below. It should return an integer that denotes the longest string that can be formed, or  if it cannot be done.
 * <p>
 * alternate has the following parameter(s):
 * <p>
 * s: a string
 * Input Format
 * <p>
 * The first line contains a single integer denoting the length of .
 * The second line contains string .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single integer denoting the maximum length of  for the given ; if it is not possible to form string , print  instead.
 * <p>
 * Sample Input
 * <p>
 * 10
 * beabeefeab
 * Sample Output
 * <p>
 * 5
 * Explanation
 * <p>
 * The characters present in  are a, b, e, and f. This means that  must consist of two of those characters and we must delete two others. Our choices for characters to leave are [a,b], [a,e], [a, f], [b, e], [b, f] and [e, f].
 * <p>
 * If we delete e and f, the resulting string is babab. This is a valid  as there are only two distinct characters (a and b), and they are alternating within the string.
 * <p>
 * If we delete a and f, the resulting string is bebeeeb. This is not a valid string  because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string .
 * <p>
 * Other cases are solved similarly.
 * <p>
 * babab is the longest string we can create.
 */
public class TwoCharacters {

    // Complete the alternate function below.
    static int alternate(String s) {
        int max = 0;
        char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char value : arr) {
            for (char c : arr) {
                if (value != c) {
                    String ss = s.replaceAll("[^" + value + c + "]", "");
                    if (isTwo(ss) && ss.length() > max)
                        max = ss.length();
                }
            }

        }
        return max;
    }

    private static boolean isTwo(String ss) {
        if (ss.length() < 2)
            return false;
        char c1 = ss.charAt(0);
        char c2 = ss.charAt(1);
        for (int i = 0; i < ss.length() - 1; i++) {
            if (ss.charAt(i) == ss.charAt(i + 1) || (ss.charAt(i) != c1 && ss.charAt(i) != c2))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(alternate("beabeefeab"));
        System.out.println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
        System.out.println(alternate("czoczkotespkfjnkbgpfnmtgqhorrzdppcebyybhlcsplqcqogqaszjgorlsrppinhgpaweydclepyftywafupqsjrbkqakpygolyyfksvqetrfzrcmatlicxtcxulwgvlnslazpfpoqrgssfcrfvwbtxaagjfahcgxbjlltfpprpcjyivxu"));
    }
}
