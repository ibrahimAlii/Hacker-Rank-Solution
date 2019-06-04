package algorithms.string;

/**
 * In this challenge, you will determine whether a string is funny or not. To determine whether a string is funny, create a copy of the string in reverse e.g. . Iterating through each string, compare the absolute difference in the ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the end. If the list of absolute differences is the same for both strings, they are funny.
 * <p>
 * Determine whether a give string is funny. If it is, return Funny, otherwise return Not Funny.
 * <p>
 * For example, given the string , the ordinal values of the charcters are . and the ordinals are . The absolute differences of the adjacent elements for both strings are , so the answer is Funny.
 * <p>
 * Function Description
 * <p>
 * Complete the funnyString function in the editor below. For each test case, it should return a string, either Funny or Not Funny.
 * <p>
 * funnyString has the following parameter(s):
 * <p>
 * s: a string to test
 * Input Format
 * <p>
 * The first line contains an integer , the number of queries.
 * The next  lines each contain a string, .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * For each string  print whether it is Funny or Not Funny on a new line.
 * <p>
 * Sample Input
 * <p>
 * 2
 * acxz
 * bcxz
 * Sample Output
 * <p>
 * Funny
 * Not Funny
 * Explanation
 * <p>
 * You can use  to store the reverse of .
 * <p>
 * Test Case 0:
 * <p>
 * ,
 * Corresponding ASCII values of characters of the strings:
 * and
 * For both the strings the adjacent difference list is [2, 21, 2] so we print Funny.
 * <p>
 * Test Case 1:
 * <p>
 * ,
 * Corresponding ASCII values of characters of the strings:
 * and
 * The adjacent difference list for string  is [1, 21, 2] and for string  it is [2, 21, 1]. Since they are not the same we print Not Funny.
 */
public class FunnyString {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        int[] order = new int[s.length()];
        int[] reversed = new int[s.length()];

        int index = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            order[i] = (int) s.charAt(i);
            reversed[index] = (int) s.charAt(i);
            index--;
        }

        for (int i = 0; i < order.length - 1; i++) {
            if (Math.abs(order[i] - order[i + 1]) != Math.abs(reversed[i] - reversed[i + 1]))
                return "Not Funny";
        }
        return "Funny";
    }


    public static void main(String[] args) {
        System.out.println(funnyString("ovyvzvptyvpvpxyztlrztsrztztqvrxtxuxq"));
        System.out.println(funnyString("holtm"));
        System.out.println(funnyString("uvzxrumuztyqyvpnji"));
        System.out.println(funnyString("tmruzxzuwoskqysxztuvosuyrswrnmtxvzsrqwytzrxpltrwusxupw"));
        System.out.println(funnyString("wxstwxuzuyuvyzrsxysxyuvyqxuxyskqwsyqumqrvopvowqumnvrxpwqpwsrnvrztxrxpvuxunvyzvupvupowvyzvzuzwvsrwv"));
        System.out.println(funnyString("yrzxrxskrtlpwpmtpxvowrxrpxq"));
        System.out.println(funnyString("pryumtuntmovpwvowslj"));
        System.out.println(funnyString("nosklrxrtyuxtmnurzsryuxtywqwqpxts"));
        System.out.println(funnyString("fmpszyvqwxrtvpuwqszvyvotmsxsxuvzyvpwzrpmuxqwtswvytytzsnuxuyrpvtysqoutzurqxury"));
        System.out.println(funnyString("jkmsxzwrxzy"));
    }
}

/*
Funny
Not Funny
Funny
Funny
Funny
Not Funny
Funny
Not Funny
Not Funny
Not Funny

 */