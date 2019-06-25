package algorithms.string;

import java.util.*;

/**
 * DNA is a nucleic acid present in the bodies of living things. Each piece of DNA contains a number of genes, some of which are beneficial and increase the DNA's total health. Each gene has a health value, and the total health of a DNA is the sum of the health values of all the beneficial genes that occur as a substring in the DNA. We represent genes and DNA as non-empty strings of lowercase English alphabetic letters, and the same gene may appear multiple times as a susbtring of a DNA.
 * <p>
 * Given the following:
 * <p>
 * An array of beneficial gene strings, . Note that these gene sequences are not guaranteed to be distinct.
 * An array of gene health values, , where each  is the health value for gene .
 * A set of  DNA strands where the definition of each strand has three components, , , and , where string  is a DNA for which genes  are healthy.
 * Find and print the respective total healths of the unhealthiest (minimum total health) and healthiest (maximum total health) strands of DNA as two space-separated values on a single line.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the total number of genes.
 * The second line contains  space-separated strings describing the respective values of  (i.e., the elements of ).
 * The third line contains  space-separated integers describing the respective values of  (i.e., the elements of ).
 * The fourth line contains an integer, , denoting the number of strands of DNA to process.
 * Each of the  subsequent lines describes a DNA strand in the form start end d, denoting that the healthy genes for DNA strand  are  and their respective correlated health values are .
 * <p>
 * Constraints
 * <p>
 * the sum of the lengths of all genes and DNA strands
 * It is guaranteed that each  consists of lowercase English alphabetic letters only (i.e., a to z).
 * Output Format
 * <p>
 * Print two space-separated integers describing the respective total health of the unhealthiest and the healthiest strands of DNA.
 * <p>
 * Sample Input 0
 * <p>
 * 6
 * a b c aa d b
 * 1 2 3 4 5 6
 * 3
 * 1 5 caaab
 * 0 4 xyz
 * 2 4 bcdybc
 * Sample Output 0
 * <p>
 * 0 19
 * Explanation 0
 * <p>
 * In the diagrams below, the ranges of beneficial genes for a specific DNA on the left are highlighed in green and individual instances of beneficial genes on the right are bolded. The total healths of the  strands are:
 * <p>
 * image
 * The total health of caaab is .
 * image
 * The total health of xyz is , because it contains no beneficial genes.
 * image
 * The total health of bcdybc is .
 * The unhealthiest DNA strand is xyz with a total health of , and the healthiest DNA strand is caaab with a total health of . Thus, we print 0 19 as our answer.
 */
public class DeterminingDNAHealth {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n]; /* Which equal patterns */

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;

            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }


        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sums = new int[s];
        int sum = 0;
        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];


        }


        scanner.close();
    }

    public static class Aho {

        static final int ALPHABET_SIZE = 26;
        Node[] nodes;
        int nodeCount;

        public static class Node {
            int parent;
            char charFromParent;
            int suffLink = -1;
            int[] children = new int[ALPHABET_SIZE];
            int[] transitions = new int[ALPHABET_SIZE];
            boolean leaf;

            {
                Arrays.fill(children, -1);
                Arrays.fill(transitions, -1);
            }
        }

        public Aho(int maxNodes) {
            nodes = new Node[maxNodes];
            // create root
            nodes[0] = new Node();
            nodes[0].suffLink = 0;
            nodes[0].parent = -1;
            nodeCount = 1;
        }

        public void addString(String s) {
            int cur = 0;
            for (char ch : s.toCharArray()) {
                int c = ch - 'a';
                if (nodes[cur].children[c] == -1) {
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].parent = cur;
                    nodes[nodeCount].charFromParent = ch;
                    nodes[cur].children[c] = nodeCount++;
                }
                cur = nodes[cur].children[c];
            }
            nodes[cur].leaf = true;
        }

        public int suffLink(int nodeIndex) {
            Node node = nodes[nodeIndex];
            if (node.suffLink == -1)
                node.suffLink = node.parent == 0 ? 0 : transition(
                        suffLink(node.parent), node.charFromParent);
            return node.suffLink;
        }

        public int transition(int nodeIndex, char ch) {
            int c = ch - 'a';
            Node node = nodes[nodeIndex];
            if (node.transitions[c] == -1)
                node.transitions[c] = node.children[c] != -1 ? node.children[c]
                        : (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
            return node.transitions[c];
        }
    }

}
