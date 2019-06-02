package algorithms.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * A weighted string is a string of lowercase English letters where each letter has a weight. Character weights are  to  from  to  as shown below:
 * <p>
 * image
 * <p>
 * We define the following terms:
 * <p>
 * The weight of a string is the sum of the weights of all the string's characters. For example:
 * <p>
 * image
 * <p>
 * A uniform string consists of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not.
 * Given a string, , let  be the set of weights for all possible uniform contiguous substrings of string . You have to answer queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.
 * <p>
 * Note: The  symbol denotes that  is an element of set .
 * <p>
 * Function Description
 * <p>
 * Complete the weightedUniformStrings function in the editor below. It should return an array of strings, either Yes or No, one for each query.
 * <p>
 * weightedUniformStrings has the following parameter(s):
 * <p>
 * s: a string
 * queries: an array of integers
 * Input Format
 * <p>
 * The first line contains a string , the original string.
 * The second line contains an integer , the number of queries.
 * Each of the next  lines contains an integer , the weight of a uniform subtring of  that may or may not exist.
 * <p>
 * Constraints
 * <p>
 * will only contain lowercase English letters, ascii[a-z].
 * Output Format
 * <p>
 * Print  lines. For each query, print Yes on a new line if . Otherwise, print No.
 * <p>
 * Sample Input 0
 * <p>
 * abccddde
 * 6
 * 1
 * 3
 * 12
 * 5
 * 9
 * 10
 * Sample Output 0
 * <p>
 * Yes
 * Yes
 * Yes
 * Yes
 * No
 * No
 * Explanation 0
 * <p>
 * The weights of every possible uniform substring in the string abccddde are shown below:
 * <p>
 * image
 * <p>
 * We print Yes on the first four lines because the first four queries match weights of uniform substrings of . We print No for the last two queries because there are no uniform substrings in  that have those weights.
 * <p>
 * Note that while de is a substring of  that would have a weight of , it is not a uniform substring.
 * <p>
 * Note that we are only dealing with contiguous substrings. So ccc is not a substring of the string ccxxc.
 * <p>
 * Sample Input 1
 * <p>
 * aaabbbbcccddd
 * 5
 * 9
 * 7
 * 8
 * 12
 * 5
 * Sample Output 1
 * <p>
 * Yes
 * No
 * Yes
 * Yes
 * No
 */
public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        s = s + "\0";
        int[] char_num = new int[27];
        int local_len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                int index = s.charAt(i - 1) - 'a' + 1;
                int curr = char_num[index];
                char_num[index] = Math.max(curr, local_len);
                local_len = 1;
            } else local_len++;
        }

        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            boolean flag = false;
            int j = 1;
            while (j < char_num.length) {
                if (char_num[j] > 0 && queries[i] % j == 0 && queries[i] / j <= char_num[j]) {
                    ans[i] = "Yes";
                    flag = true;
                    break;
                }
                j++;
            }
            if (!flag) ans[i] = "No";
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(weightedUniformStrings("abccddde", new int[]{1, 3, 12, 5, 9, 10})));
        System.out.println(Arrays.toString(weightedUniformStrings("aaabbbbcccddd", new int[]{1, 7, 8, 12, 5})));
    }
}
