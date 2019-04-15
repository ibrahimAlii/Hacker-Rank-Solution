package algorithms.implementaions;

/*
You are the benevolent ruler of Rankhacker Castle, and today you're distributing bread. Your subjects are in a line, and some of them already have some loaves. Times are hard and your castle's food stocks are dwindling, so you must distribute as few loaves as possible according to the following rules:

Every time you give a loaf of bread to some person , you must also give a loaf of bread to the person immediately in front of or behind them in the line (i.e., persons  or ).
After all the bread is distributed, each person must have an even number of loaves.
Given the number of loaves already held by each citizen, find and print the minimum number of loaves you must distribute to satisfy the two rules above. If this is not possible, print NO.

For example, the people in line have loaves . We can first give a loaf to  and  so . Next we give a loaf to  and  and have  which satisfies our conditions. We had to distribute  loaves.

Function Description

Complete the fairRations function in the editor below. It should return an integer that represents the minimum number of loaves required.

fairRations has the following parameter(s):

B: an array of integers that represent the number of loaves each persons starts with .
Input Format

The first line contains an integer , the number of subjects in the bread line.

The second line contains  space-separated integers .

Constraints

, where
Output Format

Print a single integer taht denotes the minimum number of loaves that must be distributed so that every person has an even number of loaves. If it's not possible to do this, print NO.

Sample Input 0

5
2 3 4 5 6
Sample Output 0

4
Explanation 0

The initial distribution is . The requirements can be met as follows:

Give  loaf of bread each to the second and third people so that the distribution becomes .
Give  loaf of bread each to the third and fourth people so that the distribution becomes .
Each of the  subjects has an even number of loaves after  loaves were distributed.

Sample Input 1

2
1 2
Sample Output 1

NO
Explanation 1

The initial distribution is . As there are only  people in the line, any time you give one person a loaf you must always give the other person a loaf. Because the first person has an odd number of loaves and the second person has an even number of loaves, no amount of distributed loaves will ever result in both subjects having an even number of loaves.

 */
public class FairRations {

    // Complete the fairRations function below.
    static String fairRations(int[] arr) {
        int miniMumChange = 0;

        int sum = 0;
        for (int i1 : arr) {
            sum += i1;
        }

        if (sum % 2 != 0)
            return "NO";

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 != 0){
                arr[j]++;
                arr[j + 1]++;
                miniMumChange +=2;
            }
        }


        return String.valueOf(miniMumChange);
    }

    public static void main(String[] args) {
        System.out.println(fairRations(new int[]{2, 3, 4, 5, 6}));
        System.out.println(fairRations(new int[]{1, 2}));
        System.out.println(fairRations(new int[]{2, 2}));
    }
}
