package algorithms.string;

/**
 * A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:
 * <p>
 * for any  (i.e., each element in the sequence is  more than the previous element).
 * No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
 * The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
 * The diagram below depicts some beautiful strings:
 * <p>
 * image
 * <p>
 * You must perform  queries where each query consists of some integer string . For each query, print whether or not the string is beautiful on a new line. If it's beautiful, print YES x, where  is the first number of the increasing sequence. If there are multiple such values of , choose the smallest. Otherwise, print NO.
 * <p>
 * Function Description
 * <p>
 * Complete the separateNumbers function in the editor below. It should print a string as described above.
 * <p>
 * separateNumbers has the following parameter:
 * <p>
 * s: an integer value represented as a string
 * Input Format
 * <p>
 * The first line contains an integer , the number of strings to evaluate.
 * Each of the next  lines contains an integer string  to query.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * For each query, print its answer on a new line (i.e., either YES x where  is the smallest first number of the increasing sequence, or NO).
 * <p>
 * Sample Input 0
 * <p>
 * 7
 * 1234
 * 91011
 * 99100
 * 101103
 * 010203
 * 13
 * 1
 * Sample Output 0
 * <p>
 * YES 1
 * YES 9
 * YES 99
 * NO
 * NO
 * NO
 * NO
 * Explanation 0
 * <p>
 * The first three numbers are beautiful (see the diagram above). The remaining numbers are not beautiful:
 * <p>
 * For , all possible splits violate the first and/or second conditions.
 * For , it starts with a zero so all possible splits violate the second condition.
 * For , the only possible split is , which violates the first condition.
 * For , there are no possible splits because  only has one digit.
 * Sample Input 1
 * <p>
 * 4
 * 99910001001
 * 7891011
 * 9899100
 * 999100010001
 * Sample Output 1
 * <p>
 * YES 999
 * YES 7
 * YES 98
 * NO
 */
public class SeparateTheNumbers {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
//        int collectionSize = 1;
//        int size = s.length() / 2;
//        if (s.length() % 2 != 0)
//            size++;
//
//        while (collectionSize <= size) {
//            for (int i = s.length(); i > 1 && i - collectionSize > 0; i -= collectionSize) {
//                String firstS = s.substring(i - collectionSize, i);
//                int first = Integer.parseInt(firstS);
//                int index = (i - (collectionSize * 2)) < 0 ? 0 : (i - (collectionSize * 2));
//                String secondS = s.substring(index, i - collectionSize);
//                int second = Integer.parseInt(secondS);
//
//                if (second > first || containLeadingZero(firstS, secondS) || first - second > 1)
//                    break;
//
//                if (first - second == 1 && (i - (collectionSize) <= 1 || index == 0)) {
//                    System.out.println("Yes " + (second));
//                    return;
//                }
//
//            }
//            collectionSize++;
//        }
//
//        System.out.println("NO");

        long firstx = -1;
        boolean valid = false;
        for (int i = 1; i <= s.length() / 2; ++i) {
            long x = Long.parseLong(s.substring(0, i));
            firstx = x;
            // Build up sequence starting with this number
            String test = Long.toString(x);
            while (test.length() < s.length()) {
                test += Long.toString(++x);
            }
            // Compare to original
            if (test.equals(s)) {
                valid = true;
                break;
            }
        }
        System.out.println(valid ? "YES " + firstx : "NO");

    }

    private static boolean containLeadingZero(String s1, String s2) {
        return s1.startsWith("0") || s2.startsWith("0");
    }


    public static void main(String[] args) {
//        separateNumbers("1234");
//        separateNumbers("91011");
//        separateNumbers("99100");
//        separateNumbers("101103");
//        separateNumbers("010203");
//        separateNumbers("13");
//        separateNumbers("1");
//
//        System.out.println("-----------");
//        separateNumbers("99910001001");
        separateNumbers("7891011");
        separateNumbers("9899100");
        separateNumbers("999100010001");


    }
}
