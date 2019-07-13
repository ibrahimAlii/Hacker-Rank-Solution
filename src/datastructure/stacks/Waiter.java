package datastructure.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/*
You are a waiter at a party. There are  stacked plates on pile . Each plate has a number written on it. Then there will be iterations. In -th iteration, you start picking up the plates in  from the top one by one and check whether the number written on the plate is divisible by the -th prime. If the number is divisible, you stack that plate on pile . Otherwise, you stack that plate on pile . After  iterations, plates can only be on pile , . Output numbers on these plates from top to bottom of each piles in order of , .

Input Format

The first line contains two space separated integers,  and .
The next line contains  space separated integers representing the initial pile of plates, i.e., . The leftmost value represents the bottom plate of the pile.

Constraints




Output Format

Output  lines. Each line contains a number written on the plate. Printing should be done in the order defined above.

Sample Input 0

5 1
3 4 7 6 5
Sample Output 0

4
6
3
7
5
Explanation 0

Initially:

 = [3, 4, 7, 6, 5]<-TOP

After 1 iteration:

 = []<-TOP

 = [6, 4]<-TOP

 = [5, 7, 3]<-TOP

We should output numbers in  first from top to bottom, and then output numbers in  from top to bottom.

Sample Input 1

5 2
3 3 4 4 9
Sample Output 1

4
4
9
3
3
Explanation 1

Initially:

 = [3, 3, 4, 4, 9]<-TOP

After  iteration:

 = []<-TOP

 = [4, 4]<-TOP

 = [3, 3, 9]<-TOP

After  iteration:

 = []<-TOP

 = [4, 4]<- TOP

 = [3, 3, 9]<-TOP

We should output numbers in  first from top to bottom, and then output numbers in  from top to bottom.

 */
public class Waiter {
    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        int[] primes = primeNumbersBruteForce(1200);
        ArrayList<Integer> A = new ArrayList<>();
        for (int x : number) A.add(x);
        ArrayList<Integer> B;
        int currPrime;
        int[] output = new int[number.length];
        int k = 0;
        for (int i = 0; i < q; i++) {
            currPrime = primes[i];
            B = new ArrayList<>();
            for (int j = A.size() - 1; j >= 0; j--) {
                if (A.get(j) % currPrime == 0) {
                    B.add(A.get(j));
                    A.remove(j);
                }
            }
            for (int j = B.size() - 1; j >= 0; j--) {
                output[k] = B.get(j);
                k++;
            }
            Collections.reverse(A);
        }

        for (int j = A.size() - 1; j >= 0; j--) {
            output[k] = A.get(j);
            k++;
        }
        return output;
    }

    public static int[] primeNumbersBruteForce(int n) {
        int[] primeNumbers = new int[n];
        int primes = 0;
        int i = 2;
        int index = 0;
        while (primes < n){
            if (isPrimeBruteForce(i)) {
                primeNumbers[index++] = i;
                primes++;
            }
            i++;
        }
        return primeNumbers;
    }

    public static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(waiter(new int[]{3, 3, 4, 4, 9}, 2))); // 4 4 9 3 3
        System.out.println(Arrays.toString(waiter(new int[]{3, 4, 7, 6, 5}, 1)));  // 4 6 3 7 5
    }
}
