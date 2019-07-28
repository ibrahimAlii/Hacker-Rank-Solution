package datastructure.disjointset;

/*
 There are  values to represent nodes in a graph. They are divided into two sets  and . Each set has exactly  values. Set  is represent by .  can contain any value between  to (inclusive). Set  is represented by .  can contain any value between  to (inclusive). Same value can be chosen any number of times.

Here  represents the edges of the graph.

Your task is to print the number of vertices in the smallest and the largest connected components of the graph.

Note Single nodes should not be considered in the answer.

For more clarity look at the following figure.

Alt text

For the above graph smallest connected component is 7 and largest connected component is 17.

Input Format

First line contains an integer .
Each of the next  lines contain two space-separated integers,  line contains  and .

Constraints

Output Format

Print two space separated integers, the number of vertices in the smallest and the largest components.

Sample Input

5
1 6
2 7
3 8
4 9
2 6
Sample Output

2 4
Explanation

The number of vertices in the smallest connected component in the graph is  i.e. either  or .
The number of vertices in the largest connected component in the graph is  i.e. .
 */
public class ComponentsInGraph {

    static class Disjoint {
        Node[] nodes;

        public Disjoint(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node();
            }
        }

        class Node {
            int v, e;
        }

        void union(int x, int y) {

        }
    }
}
