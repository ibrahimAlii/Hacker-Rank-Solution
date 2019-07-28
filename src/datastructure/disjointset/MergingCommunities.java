package datastructure.disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

People connect with each other in a social network. A connection between Person  and Person  is represented as . When two persons belonging to different communities connect, the net effect is the merger of both communities which  and  belongs to.

At the beginning, there are  people representing  communities. Suppose person  and  connected and later  and connected, then ,, and  will belong to the same community.

There are two type of queries:

 communities containing person  and  merged (if they belong to different communities).

 print the size of the community to which person  belongs.

Input Format

The first line of input will contain integers  and , i.e. the number of people and the number of queries.
The next  lines will contain the queries.

Constraints :



Output Format

The output of the queries.

Sample Input

3 6
Q 1
M 1 2
Q 2
M 2 3
Q 3
Q 2
Sample Output

1
2
3
3
Explanation

Initial size of each of the community is .
 */
public class MergingCommunities {

    static class DisjointSet {
        Edge[] edges;

        DisjointSet(int size) {
            edges = new Edge[size];
            for (int i = 0; i < size; i++) {
                edges[i] = new Edge();
            }
        }

        static class Edge {
            int parent = 0;
            boolean isParent = false;
            boolean hasParent = false;
            int size = 1;
        }

        void union(int x, int y) {
            x--;
            y--;

            if (!edges[x].hasParent && !edges[y].hasParent) {
                edges[x].isParent = true;
                edges[x].size++;
                edges[x].parent = x;
                edges[y].parent = x;
                edges[y].hasParent = true;
            } else if (edges[x].hasParent && edges[y].hasParent) {
                if (edges[x].parent != edges[y].parent) {
                    edges[edges[x].parent].size += edges[edges[y].parent].size;
                    edges[y].parent = edges[x].parent;
                }
            } else if (edges[x].hasParent || edges[y].hasParent) {
                if (edges[x].hasParent) {
                    edges[y].parent = edges[x].parent;
                    edges[y].hasParent = true;
                    edges[edges[x].parent].size++;
                } else {
                    edges[x].parent = edges[y].parent;
                    edges[x].hasParent = true;
                    edges[edges[y].parent].size++;
                }
            } else {
                if (edges[x].isParent) {
                    edges[y].parent = x;
                    edges[y].hasParent = true;
                    edges[x].size++;
                } else if (edges[y].isParent) {
                    edges[x].parent = y;
                    edges[x].hasParent = true;
                    edges[y].size++;
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] in = input.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int queries = Integer.parseInt(in[1]);

        DisjointSet set = new DisjointSet(n);

        for (int i = 0; i < queries; i++) {
            String[] data = input.readLine().split(" ");
            String query = data[0];
            if (query.equals("M")) {
                int x = Integer.parseInt(data[1]);
                int y = Integer.parseInt(data[2]);
                set.union(x, y);
            } else {
                int x = Integer.parseInt(data[1]) - 1;
                System.out.println(set.edges[set.edges[x].parent].size);
            }
        }
    }
}
