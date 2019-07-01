package datastructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Create a list, , of  empty sequences, where each sequence is indexed from  to . The elements within each of the  sequences also use -indexing.
 * Create an integer, , and initialize it to .
 * The  types of queries that can be performed on your list of sequences () are described below:
 * Query: 1 x y
 * Find the sequence, , at index  in .
 * Append integer  to sequence .
 * Query: 2 x y
 * Find the sequence, , at index  in .
 * Find the value of element  in  (where  is the size of ) and assign it to .
 * Print the new value of  on a new line
 * Task
 * Given , , and  queries, execute each query.
 * <p>
 * Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers,  (the number of sequences) and  (the number of queries), respectively.
 * Each of the  subsequent lines contains a query in the format defined above.
 * <p>
 * Constraints
 * <p>
 * It is guaranteed that query type  will never query an empty sequence or index.
 * Output Format
 * <p>
 * For each type  query, print the updated value of  on a new line.
 * <p>
 * Sample Input
 * <p>
 * 2 5
 * 1 0 5
 * 1 1 7
 * 1 0 3
 * 2 1 0
 * 2 1 1
 * Sample Output
 * <p>
 * 7
 * 3
 * Explanation
 * <p>
 * Initial Values:
 * <p>
 * <p>
 * = [ ]
 * = [ ]
 * <p>
 * Query 0: Append  to sequence .
 * <p>
 * = [5]
 * = [ ]
 * <p>
 * Query 1: Append  to sequence .
 * = [5]
 * = [7]
 * <p>
 * Query 2: Append  to sequence .
 * <p>
 * = [5, 3]
 * = [7]
 * <p>
 * Query 3: Assign the value at index  of sequence  to , print .
 * <p>
 * = [5, 3]
 * = [7]
 * <p>
 * 7
 * Query 4: Assign the value at index  of sequence  to , print .
 * <p>
 * = [5, 3]
 * = [7]
 * <p>
 * 3
 */
public class DynamicArray {

    public static List<Integer> dynamicArray(int n, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int lastAnswer = 0;

        for (int i = 0; i < queries.size(); i++) {
            int q = queries.get(i).get(0);
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            ArrayList<Integer> seq = queries.get((x ^ lastAnswer) % n);

            if (q == 1) {
                seq.add(y);
            } else if (q == 2) {
                lastAnswer = seq.get(y % seq.size());
                result.add(lastAnswer);
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int lastAns = 0;
        List<List> seqList = new ArrayList();

        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            List<Integer> seq = seqList.get((x ^ lastAns) % n);
            if (t == 1) {
                seq.add(y);
            } else {
                lastAns = seq.get(y % seq.size());
                System.out.println(lastAns);
            }
        }

        scanner.close();
    }

}




