package algorithms.dynamicProgramming;


/*
Given a string consisting of the letters ,  and , we can perform the following operation:

Take any two adjacent distinct characters and replace them with the third character.
Find the shortest string obtainable through applying this operation repeatedly.

For example, given the string  we can reduce it to a  character string by replacing  with  and  with : .

Function Description

Complete the stringReduction function in the editor below. It must return an integer that denotes the length of the shortest string obtainable.

stringReduction has the following parameter:
- s: a string

Input Format

The first line contains the number of test cases .

Each of the next  lines contains a string  to process.

Constraints

Output Format

For each test case, print the length of the resultant minimal string on a new line.

Sample Input

3
cab
bcab
ccccc
Sample Output

2
1
5
Explanation

For the first case, there are two solutions:  or .
For the second case, one optimal solution is: .
For the third case, no operations can be performed so the answer is .

 */
public class StringReduction {


    // Complete the stringReduction function below.

    static int stringReduction(String s) {
//        Count the number of occurences of each letter in the input string [numA, numB, numC]
//
//        If two of these counts are 0, then return string.length
//
//        Else if (all counts are even) or (all counts are odd), then return 2
//
//        Else, then return 1

        // https://stackoverflow.com/questions/8033553/stumped-on-a-java-interview-need-some-hints/8715230#8715230

        int[] arr = new int[3];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                arr[0]++;
            else if (s.charAt(i) == 'b')
                arr[1]++;
            else arr[2]++;
        }
        if (arr[0] == s.length() || arr[1] == s.length() || arr[2] == s.length())
            return s.length();

        boolean even = false;
        boolean odd = false;
       if (arr[0] % 2 == 0 && arr[1] % 2 == 0 && arr[2] % 2 == 0)
           even = true;

       if (arr[0] % 2 != 0 && arr[1] % 2 != 0 && arr[2] % 2 != 0)
           odd = true;

        return (even || odd) ? 2 : 1;
    }


    public static void main(String[] args) {
        System.out.println(stringReduction("cab"));
        System.out.println(stringReduction("abcbcba"));
        System.out.println(stringReduction("bcab"));
        System.out.println(stringReduction("ccccc"));
    }
}
