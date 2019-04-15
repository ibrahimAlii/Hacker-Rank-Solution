package algorithms.implementaions;

import java.util.*;
import java.util.concurrent.TimeUnit;

/*
Ema built a quantum computer! Help her test its capabilities by solving the problem below.

Given a grid of size , each cell in the grid is either  or .

A valid plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.

In the diagram below, the blue pluses are valid and the orange ones are not valid. pluseses.png

Find the two largest valid pluses that can be drawn on  cells in the grid, and return an integer denoting the maximum product of their areas. In the above diagrams, our largest pluses have areas of  and . The product of their areas is .

Note: The two pluses cannot overlap, and the product of their areas should be maximal.

Function Description

Complete the twoPluses function in the editor below. It should return an integer that represents the area of the two largest pluses.

twoPluses has the following parameter(s):

grid: an array of strings where each string represents a row and each character of the string represents a column of that row
Input Format

The first line contains two space-separated integers,  and .
Each of the next  lines contains a string of  characters where each character is either G () or B (). These strings represent the rows of the grid. If the  character in the  line is G, then  is a  cell. Otherwise it's a  cell.

Constraints



Output Format

Find  pluses that can be drawn on  cells of the grid, and return an integer denoting the maximum product of their areas.

Sample Input 0

5 6
GGGGGG
GBBBGB
GGGGGG
GGBBGB
GGGGGG
Sample Output 0

5
Sample Input 1

6 6
BGBBGB
GGGGGG
BGBBGB
GGGGGG
BGBBGB
BGBBGB
Sample Output 1

25
Explanation

Here are two possible solutions for Sample 0 (left) and Sample 1 (right): plusss.png

Explanation Key:

Green:  cell
Red:  cell
Blue: possible .
For the explanation below, we will refer to a plus of length  as .

Sample 0
There is enough good space to color one  plus and one  plus. , and . The product of their areas is .

Sample 1
There is enough good space to color two  pluses. . The product of the areas of our two  pluses is .
 */
public class EmasSupercomputer {


    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        List<Integer> pluses = new ArrayList<>();
        int result = 1;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length() - 1; j++) {
                if (grid[i].charAt(j) != 'B' && grid[i].charAt(j + 1) != 'B' && grid[i].charAt(j - 1) != 'B'
                        && grid[i + 1].charAt(j) != 'B' && grid[i - 1].charAt(j) != 'B') {
                    pluses.add(maxPossiblePluss(grid, i, j));
                }
            }
        }

        pluses.sort(Comparator.reverseOrder());
        System.out.println(pluses);
        for (int i = 0; i <= 1 && i < pluses.size(); i++) {
            result *= (pluses.get(i) * (4) + 1);
        }

        return result;
    }

    private static Integer maxPossiblePluss(String[] grid, int i, int j) {
        int result = 0;
        boolean good = true;
        int top = i - 1;
        int bottom = i + 1;
        int right = j + 1;
        int left = j - 1;
        while (good) {
            try {
                if (grid[top].charAt(j) != 'B' && grid[bottom].charAt(j) != 'B' && grid[i].charAt(right) != 'B'
                        && grid[i].charAt(left) != 'B') {
                    result++;
                    grid[top] = replaceChar(grid[top], 'X', j);
                    grid[bottom] = replaceChar(grid[bottom], 'X', j);
                    grid[i] = replaceChar(grid[i], 'X', right);
                    grid[i] = replaceChar(grid[i], 'X', left);
                    top--;
                    bottom++;
                    right++;
                    left--;
                } else good = false;
            } catch (Exception ex) {
                return result;
            }
        }


        return result;
    }


    public static String replaceChar(String str, char ch, int index) {
        return str.substring(0, index) + ch + str.substring(index + 1);
    }

    public static void main(String[] args) {
        System.out.println(twoPluses(new String[]{
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG"
        }));

        System.out.println(twoPluses(new String[]{
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "BGBBGB"
        }));

        System.out.println(twoPluses(new String[]{
                "BBBGBGBBB",
                "BBBGBGBBB",
                "BBBGBGBBB",
                "GGGGGGGGG",
                "BBBGBGBBB",
                "BBBGBGBBB",
                "GGGGGGGGG",
                "BBBGBGBBB",
                "BBBGBGBBB",
                "BBBGBGBBB"
        }));
    }


}


















