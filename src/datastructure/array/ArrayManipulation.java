package datastructure.array;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.
 * <p>
 * For example, the length of your array of zeros . Your list of queries is as follows:
 * <p>
 * a b k
 * 1 5 3
 * 4 8 7
 * 6 9 1
 * Add the values of  between the indices  and  inclusive:
 * <p>
 * index->	 1 2 3  4  5 6 7 8 9 10
 * [0,0,0, 0, 0,0,0,0,0, 0]
 * [3,3,3, 3, 3,0,0,0,0, 0]
 * [3,3,3,10,10,7,7,7,0, 0]
 * [3,3,3,10,10,8,8,8,1, 0]
 * The largest value is  after all operations are performed.
 * <p>
 * Function Description
 * <p>
 * Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.
 * <p>
 * arrayManipulation has the following parameters:
 * <p>
 * n - the number of elements in your array
 * queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
 * Input Format
 * <p>
 * The first line contains two space-separated integers  and , the size of the array and the number of operations.
 * Each of the next  lines contains three space-separated integers ,  and , the left index, right index and summand.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Return the integer maximum value in the finished array.
 * <p>
 * Sample Input
 * <p>
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 * Sample Output
 * <p>
 * 200
 * Explanation
 * <p>
 * After the first update list will be 100 100 0 0 0.
 * After the second update list will be 100 200 100 100 100.
 * After the third update list will be 100 200 200 200 100.
 * The required answer will be .
 */
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];


            arr[a] += k;
            if ((b + 1) <= n) arr[b + 1] -= k;
        }

        long max = 0, sum = 0;
        for (long l : arr) {
            sum += l;
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayManipulation(10, new int[][]{
                {1, 5, 3},
                {4, 8, 7},
                {6, 9, 1},
        }));

        System.out.println(arrayManipulation(10, new int[][]{
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        }));
        System.out.println(arrayManipulation(5, new int[][]{
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        }));
    }
}



