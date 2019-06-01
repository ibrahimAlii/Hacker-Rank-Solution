package algorithms.string;

import javax.xml.stream.events.Characters;

/*
Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:

Its length is at least .
It contains at least one digit.
It contains at least one lowercase English character.
It contains at least one uppercase English character.
It contains at least one special character. The special characters are: !@#$%^&*()-+
She typed a random string of length  in the password field but wasn't sure if it was strong. Given the string she typed, can you find the minimum number of characters she must add to make her password strong?

Note: Here's the set of types of characters in a form you can paste in your solution:

numbers = "0123456789"
lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = "!@#$%^&*()-+"
Input Format

The first line contains an integer  denoting the length of the string.

The second line contains a string consisting of  characters, the password typed by Louise. Each character is either a lowercase/uppercase English alphabet, a digit, or a special character.

Constraints

Output Format

Print a single line containing a single integer denoting the answer to the problem.

Sample Input 0

3
Ab1
Sample Output 0

3
Explanation 0

She can make the password strong by adding  characters, for example, $hk, turning the password into Ab1$hk which is strong.

 characters aren't enough since the length must be at least .

Sample Input 1

11
#HackerRank
Sample Output 1

1
Explanation 1

The password isn't strong, but she can make it strong by adding a single digit.
 */
public class StrongPassword {
    // Complete the minimumNumber function below.

    static int minimumNumber(int n, String password) {
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        int required = 0;
        // Return the minimum number of characters to make the password strong

        if (!contains(numbers, password))
            required++;
        if (!contains(lower_case, password))
            required++;
        if (!contains(upper_case, password))
            required++;
        if (!contains(special_characters, password))
            required++;

        if (password.length() >= 6)
            return required;
        else if (required > (6 - password.length()))
            return required;
        else return 6 - password.length();
    }

    static boolean contains(String s,String s1){
        for (int i = 0; i < s.length(); i++) {
            if (s1.contains(Character.toString(s.charAt(i))))
                return true;
        }
        return false;
    }
    public static void main(String[] args){

        System.out.println(minimumNumber(0, "#HackerRank"));
        System.out.println(minimumNumber(0, "Ab1"));
        System.out.println(minimumNumber(0, "4700"));
    }
}
