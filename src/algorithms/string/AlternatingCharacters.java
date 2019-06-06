package algorithms.string;

/**
 * You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
 * <p>
 * Your task is to find the minimum number of required deletions.
 * <p>
 * For example, given the string , remove an  at positions  and  to make  in  deletions.
 * <p>
 * Function Description
 * <p>
 * Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.
 * <p>
 * alternatingCharacters has the following parameter(s):
 * <p>
 * s: a string
 * Input Format
 * <p>
 * The first line contains an integer , the number of queries.
 * The next  lines each contain a string .
 * <p>
 * Constraints
 * <p>
 * Each string  will consist only of characters  and
 * Output Format
 * <p>
 * For each query, print the minimum number of deletions required on a new line.
 * <p>
 * Sample Input
 * <p>
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 * Sample Output
 * <p>
 * 3
 * 4
 * 0
 * 0
 * 4
 * Explanation
 * <p>
 * The characters marked red are the ones that can be deleted so that the string doesn't have matching consecutive characters.
 * <p>
 * image
 */
public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int deletion = 0;
        for (int j = 0; j < s.length() - 1; j++) {
            if (s.charAt(j) == s.charAt(j + 1))
                deletion++;
        }

        return deletion;
    }


    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAAA"));
        System.out.println(alternatingCharacters("BBBBB"));
        System.out.println(alternatingCharacters("ABABABAB"));
    }

}
