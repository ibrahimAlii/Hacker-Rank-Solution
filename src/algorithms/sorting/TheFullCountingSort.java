package algorithms.sorting;

import java.util.*;

/**
 * In this challenge you need to print the string that accompanies each integer in a list sorted by the integers. If two strings are associated with the same integer, they must be printed in their original order so your sorting algorithm should be stable. There is one other twist. The first half of the strings encountered in the inputs are to be replaced with the character "".
 * <p>
 * Insertion Sort and the simple version of Quicksort are stable, but the faster in-place version of Quicksort is not since it scrambles around elements while sorting.
 * <p>
 * In this challenge, you will use counting sort to sort a list while keeping the order of the strings preserved.
 * <p>
 * For example, if your inputs are  you could set up a helper array with three empty arrays as elements. The following shows the insertions:
 * <p>
 * i	string	converted	list
 * 0				[[],[],[]]
 * 1 	a 	-		[[-],[],[]]
 * 2	b	-		[[-],[-],[]]
 * 3	c			[[-,c],[-],[]]
 * 4	d			[[-,c],[-,d],[]]
 * The result is then printed:  .
 * <p>
 * Function Description
 * <p>
 * Complete the countSort function in the editor below. It should construct and print out the sorted strings.
 * <p>
 * countSort has the following parameter(s):
 * <p>
 * arr: a 2D array where each arr[i] is comprised of two strings: x and s.
 * Note: The first element of each , , must be cast as an integer to perform the sort.
 * <p>
 * Input Format
 * <p>
 * The first line contains , the number of integer/string pairs in the array .
 * Each of the next  contains  and , the integers (as strings) with their associated strings.
 * <p>
 * Constraints
 * <p>
 * <p>
 * is even
 * <p>
 * <p>
 * consists of characters in the range
 * <p>
 * Output Format
 * <p>
 * Print the strings in their correct order, space-separated on one line.
 * <p>
 * Sample Input
 * <p>
 * 20
 * 0 ab
 * 6 cd
 * 0 ef
 * 6 gh
 * 4 ij
 * 0 ab
 * 6 cd
 * 0 ef
 * 6 gh
 * 0 ij
 * 4 that
 * 3 be
 * 0 to
 * 1 be
 * 5 question
 * 1 or
 * 2 not
 * 4 is
 * 2 to
 * 4 the
 * Sample Output
 * <p>
 * - - - - - to be or not to be - that is the question - - - -
 * Explanation
 * <p>
 * Below is the list in the correct order. In the array at the bottom, strings from the first half of the original array were replaced with dashes.
 * <p>
 * 0 ab
 * 0 ef
 * 0 ab
 * 0 ef
 * 0 ij
 * 0 to
 * 1 be
 * 1 or
 * 2 not
 * 2 to
 * 3 be
 * 4 ij
 * 4 that
 * 4 is
 * 4 the
 * 5 question
 * 6 cd
 * 6 gh
 * 6 cd
 * 6 gh
 * sorted = [['-', '-', '-', '-', '-', 'to'], ['be', 'or'], ['not', 'to'], ['be'], ['-', 'that', 'is', 'the'], ['question'], ['-', '-', '-', '-'], [], [], [], []]
 */
public class TheFullCountingSort {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
        String[] result = new String[arr.size()];
        final int[] indexes = {arr.size() / 2};
        System.out.println(arr);
        arr.sort((o1, o2) -> {
            if (indexes[0] > 0) {
                result[arr.indexOf(o1)] = "- ";
                indexes[0]--;
            } else {
                result[arr.indexOf(o1)] = o1.get(1) + " ";
            }
            if (Integer.parseInt(o1.get(0)) > Integer.parseInt(o2.get(0)))
                return 1;
            else if (Integer.parseInt(o1.get(0)) == Integer.parseInt(o2.get(0)))
                return 0;
            else return -1;
        });
//        for (int i = 0; i < arr.size(); i++) {
//            List<String> elem = new ArrayList<>(arr.get(i));
//
//            for (int j = 0; j < arr.size() && i != j; j++) {
//                List<String> tem = arr.get(j);
//                if (Integer.parseInt(elem.get(0)) < Integer.parseInt(arr.get(j).get(0))) {
//                    if (indexes > 0) {
//                        result[j] = "- ";
//                        indexes--;
//                    } else {
//                        result[j] = arr.get(j).get(1) + " ";
//                    }
//
//                }
//
//            }
//
//        }

        System.out.println(Arrays.toString(result));

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        StringBuffer[] st = new StringBuffer[100];

        for (int i = 0; i < 100; i++) {
            st[i] = new StringBuffer();
        }

        for (int i = 0; i < size; i++) {
            String sts = scan.nextLine();
            String[] str = sts.split("[\\s]+");
            int k = Integer.parseInt(str[0]);
            String s;
            if (i < size / 2)
                s = "- ";
            else
                s = str[1] + " ";
            st[k] = st[k].append(s);
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(st[i]);
        }


        countSort(List.of(List.of("0", "ab"), List.of("6", "cd"), List.of("0", "ef"), List.of("6", "gh"), List.of("4", "ij"),
                List.of("0", "ab"), List.of("6", "cd"), List.of("0", "ef"), List.of("6", "gh"), List.of("0", "ij"),
                List.of("4", "that"), List.of("3", "be"), List.of("0", "to"), List.of("1", "be"), List.of("5", "question"),
                List.of("1", "or"), List.of("2", "not"), List.of("4", "is"), List.of("2", "to"), List.of("4", "the")));
    }
}
