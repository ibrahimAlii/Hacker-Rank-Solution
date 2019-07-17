package algorithms.implementaions;


import java.util.Arrays;

/*
You are given a square map as a matrix of integer strings. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side, or edge.

Find all the cavities on the map and replace their depths with the uppercase character x.

For example, given a matrix:

989
191
111
You should return:

989
1X1
111
The center cell was deeper than those on its edges: [8,1,1,1]. The deep cells in the top two corners don't share an edge with the center cell.

Function Description

Complete the cavityMap function in the editor below. It should return an array of strings, each representing a line of the completed map.

cavityMap has the following parameter(s):

grid: an array of strings, each representing a row of the grid
Input Format

The first line contains an integer , the number of rows and columns in the map.

Each of the following  lines (rows) contains  positive digits without spaces (columns) representing depth at .

Constraints


Output Format

Output  lines, denoting the resulting map. Each cavity should be replaced with the character x.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
Explanation

The two cells with the depth of 9 are not on the border and are surrounded on all sides by shallower cells. Their values have been replaced by x.
 */
public class CavityMap {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        int n = grid[0].length();
        char[][] arr = new char[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = grid[i].charAt(j);
            }
        }


        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (arr[i][j] != 'X' && arr[i][j + 1] != 'X' && arr[i][j - 1] != 'X' && arr[i - 1][j] != 'X' && arr[i + 1][j] != 'X')
                    if (arr[i][j] > arr[i][j + 1] && arr[i][j] > arr[i][j - 1] && arr[i][j] > arr[i + 1][j] && arr[i][j] > arr[i - 1][j]) {
                        arr[i][j] = 'X';
                        grid[i] = replaceChar(grid[i], 'X', j);
                    }
            }
        }


        return grid;
    }

    public static String replaceChar(String str, char ch, int index) {
        return str.substring(0, index) + ch + str.substring(index+1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(cavityMap(new String[]{"1112",
                "1912",
                "1892",
                "1234"})));

        System.out.println(Arrays.toString(cavityMap(new String[]{"989",
                "191",
                "111"})));

        System.out.println(Arrays.toString(cavityMap(new String[]{"12", "12"})));
    }
}
