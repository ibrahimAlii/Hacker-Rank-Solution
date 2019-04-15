package algorithms.implementaions;

public class UtopianTree {

    // Complete the utopianTree function below.
    static int utopianTree(int n) {

        return ~(~1 << (n >> 1)) << n % 2;
    }

    public static void main(String[] main) {

        System.out.println(utopianTree(4));
    }
}
