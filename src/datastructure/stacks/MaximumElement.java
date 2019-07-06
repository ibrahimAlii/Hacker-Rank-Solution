package datastructure.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/*
You have an empty sequence, and you will be given  queries. Each query is one of these three types:

1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
Input Format

The first line of input contains an integer, . The next  lines each contain an above mentioned query. (It is guaranteed that each query is valid.)

Constraints



Output Format

For each type  query, print the maximum element in the stack on a new line.

Sample Input

10
1 97
2
1 20
2
1 26
1 20
2
3
1 91
3
Sample Output

26
91
 */
public class MaximumElement {


    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(input.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] in = input.readLine().split(" ");
            int type = Integer.parseInt(in[0]);

            // push case
            if (type == 1) {
                int data = Integer.parseInt(in[1]);
                if (data > max)
                    max = data;
                stack.push(data);
            } else if (type == 2) {
                int pop = stack.pop();
                if (pop == max) {
                    if (!stack.isEmpty()) {
                        max = stack.peek();
                        for (Integer integer : stack) {
                            if (integer >= max)
                                max = integer;
                        }
                    } else {
                        max = 0;
                    }
                }
            } else if (type == 3) {
                System.out.println(max);
            }

        }
    }
}
