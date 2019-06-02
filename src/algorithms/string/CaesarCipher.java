package algorithms.string;

/**
 * Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
 * <p>
 * Original alphabet:      abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
 * For example, the given cleartext  and the alphabet is rotated by . The encrypted string is .
 * <p>
 * Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
 * <p>
 * Function Description
 * <p>
 * Complete the caesarCipher function in the editor below. It should return the encrypted string.
 * <p>
 * caesarCipher has the following parameter(s):
 * <p>
 * s: a string in cleartext
 * k: an integer, the alphabet rotation factor
 * Input Format
 * <p>
 * The first line contains the integer, , the length of the unencrypted string.
 * The second line contains the unencrypted string, .
 * The third line contains , the number of letters to rotate the alphabet by.
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * is a valid ASCII string without any spaces.
 * <p>
 * Output Format
 * <p>
 * For each test case, print the encoded string.
 * <p>
 * Sample Input
 * <p>
 * 11
 * middle-Outz
 * 2
 * Sample Output
 * <p>
 * okffng-Qwvb
 * Explanation
 * <p>
 * Original alphabet:      abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab
 * <p>
 * m -> o
 * i -> k
 * d -> f
 * d -> f
 * l -> n
 * e -> g
 * -    -
 * O -> Q
 * u -> w
 * t -> v
 * z -> b
 */
public class CaesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        char[] original_alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String result = "";
        int moves = k % 26;
        int index;
        boolean isUpper;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isAlphabetic(current)) {
                if (Character.isUpperCase(current)) {
                    index = current - 'A';
                    isUpper = true;
                } else {
                    index = current - 'a';
                    isUpper = false;
                }
                index += moves;
                if (index > 25)
                    index -= 25 + 1;

                if (isUpper) result += Character.toUpperCase(original_alpha[index]);
                else result += original_alpha[index];
            } else result += s.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher("middle-Outz", 2));
    }
}
