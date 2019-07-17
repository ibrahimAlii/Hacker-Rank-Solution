package datastructure.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
You are given a square grid with some cells open (.) and some blocked (x). Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and an end position, determine the number of moves it will take to get to the end position.

For example, you are given a grid with sides  described as follows:

...
.x.
...
Your starting position  so you start in the top left corner. The ending position is . The path is . It takes  moves to get to the goal.

Function Description
Complete the minimumMoves function in the editor. It must print an integer denoting the minimum moves required to get from the starting position to the goal.

minimumMoves has the following parameter(s):

grid: an array of strings representing the rows of the grid
startX: an integer
startY: an integer
goalX: an integer
goalY: an integer
Input Format

The first line contains an integer , the size of the array grid.
Each of the next  lines contains a string of length .
The last line contains four space-separated integers,

Constraints

Output Format

Print an integer denoting the minimum number of steps required to move the castle to the goal position.

Sample Input

3
.x.
.x.
...
0 0 0 2
Sample Output

3
Explanation

Here is a path that one could follow in order to reach the destination in  steps:

.
 */
public class CastleOnTheGrid {

    static class Point {
        int x;
        int y;
        boolean isBlock;

        Point(int x, int y, boolean isBlock) {
            this.x = x;
            this.y = y;
            this.isBlock = isBlock;
        }

        @Override
        public String toString() {
            return "(x = " + x + ", y = " + y + ", isBlock = " + isBlock + ")";
        }
    }

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        Queue<Point> limits = new ArrayDeque<>();
        int moves = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                Point point = new Point(i, j, s.charAt(j) == 'x');
                if (j == 0 || j == s.length() - 1 || i == 0 || i == grid.length - 1 || s.charAt(j) == 'x') {
                    limits.add(point);
                }
            }
        }
        while (!limits.isEmpty()) {

            if (startX < goalX) {

            } else if (startX > goalX) {

            } else if (startY > goalY) {

            } else if (startY < goalY) {

            }
        }
        System.out.println(limits);
        System.out.println(limits.size());
        return moves;
    }


    public static void main(String[] args) {
        System.out.println(minimumMoves(new String[]{".x.", ".x.", "..."}, 0, 0, 0, 2));
    }
}
