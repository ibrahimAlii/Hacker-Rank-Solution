package algorithms.string;

/**
 * Roy wanted to increase his typing speed for programming contests. His friend suggested that he type the sentence "The quick brown fox jumps over the lazy dog" repeatedly. This sentence is known as a pangram because it contains every letter of the alphabet.
 *
 * After typing the sentence several times, Roy became bored with it so he started to look for other pangrams.
 *
 * Given a sentence, determine whether it is a pangram. Ignore case.
 *
 * Function Description
 *
 * Complete the function pangrams in the editor below. It should return the string pangram if the input string is a pangram. Otherwise, it should return not pangram.
 *
 * pangrams has the following parameter(s):
 *
 * s: a string to test
 * Input Format
 *
 * Input consists of a string .
 *
 * Constraints
 *
 *
 * Each character of ,
 *
 * Output Format
 *
 * Output a line containing pangram if  is a pangram, otherwise output not pangram.
 *
 * Sample Input 0
 *
 * We promptly judged antique ivory buckles for the next prize
 *
 * Sample Output 0
 *
 * pangram
 *
 * Sample Explanation 0
 *
 * All of the letters of the alphabet are present in the string.
 *
 * Sample Input 1
 *
 * We promptly judged antique ivory buckles for the prize
 *
 * Sample Output 1
 *
 * not pangram
 *
 * Sample Explanation 0
 *
 * The string lacks an x.
 */
public class Pangrams {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        boolean[] pangramiz = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)))
                pangramiz [Character.toUpperCase(s.charAt(i)) - 'A'] = true;
        }

        for (int i = 0; i < pangramiz.length; i++) {
            if (!pangramiz[i])
                return "not pangram";
        }

        return "pangram";
    }

    public static void main(String[] args){
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
    }
}
