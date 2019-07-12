package datastructure.stacks;

import java.io.*;
import java.util.Stack;


/*
In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform  operations of the following  types:

append - Append string  to the end of .
delete - Delete the last  characters of .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
Input Format

The first line contains an integer, , denoting the number of operations.
Each line  of the  subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer,  (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,  is followed by its space-separated argument. For example, if  and , line will be 1 abcd.

Constraints

The sum of the lengths of all  in the input .
The sum of  over all delete operations .
All input characters are lowercase English letters.
It is guaranteed that the sequence of operations given as input is possible to perform.
Output Format

Each operation of type  must print the  character on a new line.

Sample Input

8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1
Sample Output

c
y
a
Explanation

Initially,  is empty. The following sequence of  operations are described below:

. We append  to , so .
Print the  character on a new line. Currently, the  character is c.
Delete the last  characters in  (), so .
Append  to , so .
Print the  character on a new line. Currently, the  character is y.
Undo the last update to , making  empty again (i.e., ).
Undo the next to last update to  (the deletion of the last  characters), making .
Print the  character on a new line. Currently, the  character is a.
 */
public class SimpleTextEditor {


    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        stack.push("");
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            String[] in = input.readLine().split(" ");
            int query = Integer.parseInt(in[0]);
            if /* push */(query == 1) {
                stack.push(stack.peek().concat(in[1]));
            } else  /* delete*/ if (query == 2) {
                int k = Integer.parseInt(in[1]);
                stack.push(stack.peek().substring(0, stack.peek().length() - k));
            } else /* print */if (query == 3) {
                int k = Integer.parseInt(in[1]);
                System.out.println(stack.peek().charAt(k - 1));
            } else /* undo */ if (query == 4) {
                stack.pop();
            }

            //System.out.println("||  " + stack.peek() + "  ||");
        }

    }
}
