package algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AbsolutePermutation {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int[] result = new int[n];
        int en = 2, od = 1;
        for (int i = 0; i < ((n % 2 == 0) ? n : n - 2); i++) {
            if (i % 2 == 0) {
                result[i] = en;
                en += 2;
            } else {
                result[i] = od;
                od += 2;
            }
        }

        if (n % 2 != 0) {
            result[n - 2] = n;
            result[n - 1] = n - 2;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(absolutePermutation(2, 1)));
        System.out.println(Arrays.toString(absolutePermutation(3, 0)));
        System.out.println(Arrays.toString(absolutePermutation(3, 2)));
    }
}
