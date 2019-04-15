package algorithms.implementaions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AbsolutePermutation {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int[] result = new int[n];
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                result[i] = i + 1;
            }
            return result;
        }

        if (k > 0 && n % (2 * k) != 0) {
            return new int[]{-1};
        }


        int num = 1;
        int i = 0;
        while (i < n - k) {
            // swap num with (num+k)
            for (int j = 0; j < k; j++) {
                result[i + j] = num + k + j;
                result[i + k + j] = num + j;
            }

            num += (2 * k);
            i += (2 * k);
        }

        return result;
    }


    public static void main(String[] args) {
        //System.out.println(Arrays.toString(absolutePermutation(2, 1)));
        //System.out.println(Arrays.toString(absolutePermutation(3, 0)));
        System.out.println(Arrays.toString(absolutePermutation(100, 2)));
        //System.out.println(Arrays.toString(absolutePermutation(3, 2)));
        //System.out.println(Arrays.toString(absolutePermutation(4, 2)));
        //System.out.println(Arrays.toString(absolutePermutation(7, 5)));
    }
}

//        3 4 1 2 7 8 5 6 11 12 9 10 15 16 13 14 19 20 17 18 23 24 21 22 27 28
//        25 26 31 32 29 30 35 36 33 34 39 40 37 38 43 44 41 42 47 48 45
//        46 51 52 49 50 55 56 53 54 59 60 57 58 63 64 61 62 67 68 65 66
//        71 72 69 70 75 76 73 74 79 80 77 78 83 84 81 82 87 88 85 86 91
//        92 89 90 95 96 93 94 99 100 97 98