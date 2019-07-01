package datastructure.linkedlists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }


        Arrays.sort(arr);
        long marbles = 1;
        int modu = 1000000007;
        for (int i = 0; i < n; i++) {
            marbles *= (arr[i] - i);
            marbles %= modu;
        }

        System.out.println(marbles);
        input.close();
    }
}
