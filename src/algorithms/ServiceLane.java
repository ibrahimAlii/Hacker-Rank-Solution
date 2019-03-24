package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Calvin is driving his favorite vehicle on the 101 freeway. He notices that the check engine light of his vehicle is on, and he wants to service it immediately to avoid any risks. Luckily, a service lane runs parallel to the highway. The service lane varies in width along its length.

Paradise Highway

You will be given an array of widths at points along the road (indices), then a list of the indices of entry and exit points. Considering each entry and exit point pair, calculate the maximum size vehicle that can travel that segment of the service lane safely.

For example, there are  measurements yielding . If our entry index,  and our exit, , there are two segment widths of  and  respectively. The widest vehicle that can fit through both is . If  and , our widths are  which limits vehicle width to .

Function Description

Complete the serviceLane function in the editor below. It should return an array of integers representing the maximum width vehicle that can pass through each segment of the highway described.

serviceLane has the following parameter(s):

n: an integer denoting the size of the  array
cases: a two dimensional array of integers where each element is an array of two integers representing starting and ending indices for a segment to consider .
Input Format

The first line of input contains two integers,  and , where  denotes the number of width measurements you will receive and  the number of test cases. The next line has  space-separated integers which represent the array .

The next  lines contain two integers,  and , where  is the start index and  is the end index of the segment being considered.

Constraints

Output Format

For each test case, print the number that represents the largest vehicle type that can pass through the entire segment of the service lane between indexes  and  inclusive.

Sample Input

8 5
2 3 1 2 3 2 3 3
0 3
4 6
6 7
3 5
0 7
Sample Output

1
2
3
2
1
Explanation

Below is the representation of the lane:

   |HIGHWAY|Lane|    ->    Width

0: |       |--|            2
1: |       |---|           3
2: |       |-|             1
3: |       |--|            2
4: |       |---|           3
5: |       |--|            2
6: |       |---|           3
7: |       |---|           3
: From index  through  we have widths  and . Nothing wider than  can pass all segments.
: From index  through  we have widht  and . Nothing wider than  can pass all segments.
:  .
:
: .

 */
public class ServiceLane {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            result[i] = Integer.MAX_VALUE;
            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }

            for (int k = cases[i][0]; k <= cases[i][1]; k++){
                if (width[k] < result[i])
                    result[i] = width[k];
            }

        }



        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
