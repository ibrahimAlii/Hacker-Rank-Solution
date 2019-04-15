package algorithms.implementaions;

/*
An integer  is a divisor of an integer  if the remainder of .

Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of divisors occurring within the integer.

Note: Each digit is considered to be unique, so each occurrence of the same digit should be counted (e.g. for ,  is a divisor of  each time it occurs so the answer is ).

Function Description

Complete the findDigits function in the editor below. It should return an integer representing the number of digits of  that are divisors of .

findDigits has the following parameter(s):

n: an integer to analyze
Input Format

The first line is an integer, , indicating the number of test cases.
The  subsequent lines each contain an integer, .

Constraints



Output Format

For every test case, count the number of digits in  that are divisors of . Print each answer on a new line.

Sample Input

2
12
1012
Sample Output

2
3
Explanation

The number  is broken into two digits,  and . When  is divided by either of those two digits, the remainder is  so they are both divisors.

The number  is broken into four digits, , , , and .  is evenly divisible by its digits , , and , but it is not divisible by as division by zero is undefined.
 */
public class FindDigits {

    static int findDigits(int n) {
        int totalDivisor = 0;
        int number = n;

        while (number > 0) {
            if (number % 10 != 0)
                totalDivisor += n % (number % 10) == 0 ? 1 : 0;

            number /= 10;
        }


        return totalDivisor;
    }

    public static void main(String[] args) {

        System.out.println(findDigits(1012));
    }
}
