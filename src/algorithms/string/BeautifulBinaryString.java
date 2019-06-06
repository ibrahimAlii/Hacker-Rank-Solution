package algorithms.string;

/**
 * Alice has a binary string. She thinks a binary string is beautiful if and only if it doesn't contain the substring .
 * <p>
 * In one step, Alice can change a  to a  or vice versa. Count and print the minimum number of steps needed to make Alice see the string as beautiful.
 * <p>
 * For example, if Alice's string is  she can change any one element and have a beautiful string.
 * <p>
 * Function Description
 * <p>
 * Complete the beautifulBinaryString function in the editor below. It should return an integer representing the minimum moves required.
 * <p>
 * beautifulBinaryString has the following parameter(s):
 * <p>
 * b: a string of binary digits
 * Input Format
 * <p>
 * The first line contains an integer , the length of binary string.
 * The second line contains a single binary string .
 * <p>
 * Constraints
 * <p>
 * .
 * Output Format
 * <p>
 * Print the minimum number of steps needed to make the string beautiful.
 * <p>
 * Sample Input 0
 * <p>
 * 7
 * 0101010
 * Sample Output 0
 * <p>
 * 2
 * Explanation 0:
 * <p>
 * In this sample,
 * <p>
 * The figure below shows a way to get rid of each instance of :
 * <p>
 * binary.png
 * <p>
 * Because we were able to make the string beautiful by changing  characters ( and ), we print .
 * <p>
 * Sample Input 1
 * <p>
 * 5
 * 01100
 * Sample Output 1
 * <p>
 * 0
 * Sample Case 1:
 * <p>
 * In this sample
 * <p>
 * Explanation 1
 * <p>
 * The substring  does not occur in , so the string is already beautiful and we print .
 * <p>
 * Sample Input 2
 * <p>
 * 10
 * 0100101010
 * Sample Output 2
 * <p>
 * 3
 * Explanation 2
 * <p>
 * In this sample
 * <p>
 * One solution is to change the values of  to form a beautiful string.
 */
public class BeautifulBinaryString {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        String pattern = "010";
        int requiredReplacement = 0;
        for (int i = 0; i < b.length() && i + 2 < b.length(); ) {
            String ss = b.substring(i, i + 3);
            if (ss.equals(pattern)) {
                requiredReplacement++;
                i += 3;
            } else i++;
        }
        return requiredReplacement;
    }


    public static void main(String[] args) {
        System.out.println(beautifulBinaryString("0100101010"));
        System.out.println(beautifulBinaryString("01100"));
        System.out.println(beautifulBinaryString("0101010"));
    }

}
