package algorithms;

/*
A jail has a number of prisoners and a number of treats to pass out to them. Their jailer decides the fairest way to divide the treats is to seat the prisoners around a circular table in sequentially numbered chairs. A chair number will be drawn from a hat. Beginning with the prisoner in that chair, one candy will be handed to each prisoner sequentially around the table until all have been distributed.

The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful. Determine the chair number occupied by the prisoner who will receive that candy.

For example, there are  prisoners and  pieces of candy. The prisoners arrange themselves in seats numbered  to . Let's suppose two is drawn from the hat. Prisoners receive candy at positions . The prisoner to be warned sits in chair number .

Function Description

Complete the saveThePrisoner function in the editor below. It should return an integer representing the chair number of the prisoner to warn.

saveThePrisoner has the following parameter(s):

n: an integer, the number of prisoners
m: an integer, the number of sweets
s: an integer, the chair number to begin passing out sweets from
Input Format

The first line contains an integer, , denoting the number of test cases.
The next  lines each contain  space-separated integers:
- : the number of prisoners
- : the number of sweets
- : the chair number to start passing out treats at

Constraints

Output Format

For each test case, print the chair number of the prisoner who receives the awful treat on a new line.

Sample Input 0

2
5 2 1
5 2 2
Sample Output 0

2
3
Explanation 0

In first query, there are  prisoners and  sweets. Distribution starts at seat number . Prisoners in seats numbered  and  get sweets. Warn prisoner .
In the second query, distribution starts at seat  so prisoners in seats  and  get sweets. Warn prisoner .

Sample Input 1

2
7 19 2
3 7 3
Sample Output 1

6
3
Explanation 1

In the first test case, there are  prisoners,  sweets and they are passed out starting at chair . The candies go all around twice and there are  more candies passed to each prisoner from seat  to seat .

In the second test case, there are  prisoners,  candies and they are passed out starting at seat . They go around twice, and there is one more to pass out to the prisoner at seat .
 */
public class SaveThePrisoner {


    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
//        int prisoner = s;
//
//        for (int i = 1; i < m; i++) {
//
//            if (prisoner == n)
//                prisoner = 1;
//            else prisoner++;
//        }
//
//        return prisoner;


        // prefer solution
        int prisoner = (s + m) - 1;

        if (prisoner > n) {
            if (prisoner % n == 0)
                return n;

            return prisoner % n;
        }


        return prisoner;
    }

    public static void main(String[] args) {

        System.out.println(saveThePrisoner(3, 7, 3));
    }
}
