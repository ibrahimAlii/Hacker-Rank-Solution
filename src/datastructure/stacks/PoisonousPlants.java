package datastructure.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
There are a number of plants in a garden. Each of these plants has been treated with some amount of pesticide. After each day, if any plant has more pesticide than the plant on its left, being weaker than the left one, it dies.

You are given the initial values of the pesticide in each of the plants. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.

For example, pesticide levels . Using a -indexed array, day  plants  and  die leaving . On day , plant  of the current array dies leaving . As there is no plant with a higher concentration of pesticide than the one to its left, plants stop dying after day .

Function Description
Complete the function poisonousPlants in the editor below. It must return an integer representing the number of days until plants no longer die from pesticide.

poisonousPlants has the following parameter(s):

p: an array of integers representing pesticide levels in each plant
Input Format

The first line contains an integer , the size of the array .
The next line contains  space-separated integers .

Constraints



Output Format

Output an integer equal to the number of days after which no plants die.

Sample Input

7
6 5 8 4 7 10 9
Sample Output

2
Explanation

Initially all plants are alive.

Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)}

Plants[k] = (i,j) => jth plant has pesticide amount = i.

After the 1st day, 4 plants remain as plants 3, 5, and 6 die.

Plants = {(6,1), (5,2), (4,4), (9,7)}

After the 2nd day, 3 plants survive as plant 7 dies.

Plants = {(6,1), (5,2), (4,4)}

After the 2nd day the plants stop dying.
 */
public class PoisonousPlants {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        int n = p.length;
        int[] r = new int[n];
        Stack<Integer> st = new Stack<>();
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            while (!st.empty() && p[i] < p[st.peek()]) {
                int it = st.pop();
                sum += (sum + 1 > r[it] ? 1 : r[it] - sum);
            }
            st.push(i);
            r[i] = sum;
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(poisonousPlants(new int[]{6, 5, 8, 4, 7, 10, 9}));
        System.out.println(poisonousPlants(new int[]{3, 6, 2, 7, 5}));
    }
}
