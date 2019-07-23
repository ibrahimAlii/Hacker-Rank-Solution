package datastructure.heap;

import java.io.*;
import java.util.PriorityQueue;

/*
Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value . To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:

sweetness  Least sweet cookie   2nd least sweet cookie).

He repeats this procedure until all the cookies in his collection have a sweetness .
You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness . Print  if this isn't possible.

Input Format

The first line consists of integers , the number of cookies and , the minimum required sweetness, separated by a space.
The next line contains  integers describing the array  where  is the sweetness of the  cookie in Jesse's collection.

Constraints




Output Format

Output the number of operations that are needed to increase the cookie's sweetness .
Output  if this isn't possible.

Sample Input

6 7
1 2 3 9 10 12
Sample Output

2
Explanation

Combine the first two cookies to create a cookie with sweetness  =
After this operation, the cookies are .
Then, combine the cookies with sweetness  and sweetness , to create a cookie with resulting sweetness  =
Now, the cookies are .
All the cookies have a sweetness .

Thus,  operations are required to increase the sweetness.
 */
public class JesseAndCookies {

    private static final BufferedReader scanner =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.readLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        PriorityQueue<Integer> queue = new PriorityQueue();

        String[] AItems = scanner.readLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            queue.add(AItem);
        }

        int result = 0;
        while (queue.size() > 1 && queue.peek() < k) {
            int sweet1 = queue.poll();
            int sweet2 = queue.poll();

            queue.add((sweet1) + (2 * sweet2));
            result++;
        }

        if (queue.peek() < k) result = -1;
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}


