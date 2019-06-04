package TenDaysOfStatics;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedMean {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        float[] arr = new float[n];
        float[] divisors = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextFloat();
        }
        for (int i = 0; i < n; i++) {
            divisors[i] = input.nextFloat();
        }

        float meanSum = 0;
        float sum = 0;
        for (int i = 0; i < n; i++) {
            meanSum += arr[i] * divisors[i];
            sum += divisors[i];
        }

        System.out.printf("%.1f", (meanSum / sum));
    }
}


