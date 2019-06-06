package algorithms.string;

import java.util.Arrays;

/**
 * John has collected various rocks. Each rock has various minerals embeded in it. Each type of mineral is designated by a lowercase letter in the range . There may be multiple occurrences of a mineral in a rock. A mineral is called a gemstone if it occurs at least once in each of the rocks in John's collection.
 * <p>
 * Given a list of minerals embedded in each of John's rocks, display the number of types of gemstones he has in his collection.
 * <p>
 * For example, the array of mineral composition strings . The minerals  and  appear in each composite, so there are  gemstones.
 * <p>
 * Function Description
 * <p>
 * Complete the gemstones function in the editor below. It should return an integer representing the number of gemstones found in the list of rocks.
 * <p>
 * gemstones has the following parameter(s):
 * <p>
 * arr: an array of strings
 * Input Format
 * <p>
 * The first line consists of an integer , the size of .
 * Each of the next  lines contains a string  where each letter represents an occurence of a mineral in the current rock.
 * <p>
 * Constraints
 * <p>
 * <p>
 * | arr[i] |
 * Each composition  consists of only lower-case Latin letters ('a'-'z').
 * <p>
 * Output Format
 * <p>
 * Print the number of types of gemstones in John's collection. If there are none, print .
 * <p>
 * Sample Input
 * <p>
 * 3
 * abcdde
 * baccd
 * eeabg
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * Only  and  are gemstones because they are the only types that occur in every rock.
 */
public class Gemstones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int[] occur = new int[26];
        for (String s : arr) {
            for (int j = 0; j < 26; j++) {
                if (s.replaceAll("[^" + ((char) (j + (int) 'a')) + "]", "").length() > 0)
                    occur[j]++;
            }
        }
        int gemstones = 0;
        for (int value : occur) {
            if (value == arr.length)
                gemstones++;
        }
        return gemstones;
    }


    public static void main(String[] args) {

        System.out.println(gemstones(new String[]{"abcdde", "baccd", "eeabg"}));
    }
}
