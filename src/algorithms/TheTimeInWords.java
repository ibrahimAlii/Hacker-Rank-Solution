package algorithms;

/*
Given the time in numerals we may convert it into words, as shown below:

At , use o' clock. For , use past, and for  use to. Note the space between the apostrophe and clock in o' clock. Write a program which prints the time in words for the input given in the format described.

Function Description

Complete the timeInWords function in the editor below. It should return a time string as described.

timeInWords has the following parameter(s):

h: an integer representing hour of the day
m: an integer representing minutes after the hour
Input Format

The first line contains , the hours portion The second line contains , the minutes portion

Constraints

Output Format

Print the time in words as described.

Sample Input 0

5
47
Sample Output 0

thirteen minutes to six
Sample Input 1

3
00
Sample Output 1

three o' clock
Sample Input 2

7
15
Sample Output 2

quarter past seven

 */
public class TheTimeInWords {


    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        StringBuilder time = new StringBuilder();
        if (m > 30) {
            if (m == 45)
                time.append("quarter").append(" to ").append(numNames[h + 1]);
            else time.append(numNames[60 - m]).append(" minutes").append(" to ").append(numNames[h + 1]);
        } else if (m == 30) {
            time.append("half").append(" past ").append(numNames[h]);
        } else {
            if (m == 0)
                time.append(numNames[h]).append(" o' clock");
            else
                time.append(numNames[m]).append(m == 15 ? " past " : m == 1 ? " minute past " : " minutes past ").append(numNames[h]);
        }
        return time.toString();
    }

    private static final String[] numNames = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "quarter",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine",
    };


    public static void main(String[] args) {

        System.out.println(timeInWords(5, 47));
        System.out.println(timeInWords(3, 0));
        System.out.println(timeInWords(7, 15));
        System.out.println(timeInWords(1, 1));
    }
}
