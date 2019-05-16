package algorithms.dynamicProgramming;

/**
 * Your goal is to find the number of ways to construct an array such that consecutive positions contain different values.
 * <p>
 * Specifically, we want to construct an array with  elements such that each element between  and , inclusive. We also want the first and last elements of the array to be  and .
 * <p>
 * Given ,  and , find the number of ways to construct such an array. Since the answer may be large, only find it modulo .
 * <p>
 * For example, for , , , there are  ways, as shown here:
 * <p>
 * image
 * <p>
 * Complete the function countArray which takes input ,  and . Return the number of ways to construct the array such that consecutive elements are distinct.
 * <p>
 * Constraints
 * <p>
 * Subtasks
 * <p>
 * For  of the maximum score,  and
 * Sample Input
 * <p>
 * , ,
 * <p>
 * Sample Output
 * <p>
 * <p>
 * Explanation
 * <p>
 * Refer to the diagram in the challenge statement.
 */
public class ConstructTheArray {

    // Complete the countArray function below.
    static long countArray(int n, int k, int x) {
        // Return the number of ways to fill in the array.
        long[][] dp = new long[n][2];
        int mod = 1000000007;
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = ((k - 1) * dp[i - 1][1]) % mod;

            dp[i][1] = ((dp[i - 1][0] + ((k - 1) * dp[i - 1][1])) - dp[i - 1][1]) % mod;

        }

        return x == 1 ? dp[n - 1][0] : dp[n - 1][1];
    }

    public static void main(String[] args) {

        System.out.println(countArray(4, 3, 2));
    }
}
