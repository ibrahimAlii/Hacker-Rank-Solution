package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.

Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds. Once a bomb detonates, it's destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell , any valid cells  and  are cleared. If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there's no chain reaction.

Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:

Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
After one second, Bomberman does nothing.
After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. No bombs detonate at this point.
After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
Bomberman then repeats steps 3 and 4 indefinitely.
Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.

Given the initial configuration of the grid with the locations of Bomberman's first batch of planted bombs, determine the state of the grid after  seconds.

For example, if the initial grid looks like:

...
.O.
...
it looks the same after the first second. After the second second, Bomberman has placed all his charges:

OOO
OOO
OOO
At the third second, the bomb in the middle blows up, emptying all surrounding cells:

...
...
...
Function Description

Complete the bomberMan function in the editory below. It should return an array of strings that represent the grid in its final state.

bomberMan has the following parameter(s):

n: an integer, the number of seconds to simulate
grid: an array of strings that represents the grid
Input Format

The first line contains three space-separated integers , , and , The number of rows, columns and seconds to simulate.
Each of the next  lines contains a row of the matrix as a single string of  characters. The . character denotes an empty cell, and the O character (ascii 79) denotes a bomb.

Constraints

Subtask

 for  of the maximum score.
Output Format

Print the grid's final state. This means  lines where each line contains  characters, and each character is either a . or an O (ascii 79). This grid must represent the state of the grid after  seconds.

Sample Input

6 7 3
.......
...O...
....O..
.......
OO.....
OO.....
Sample Output

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO
Explanation

The initial state of the grid is:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman spends the first second doing nothing, so this is the state after 1 second:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman plants bombs in all the empty cells during his second second, so this is the state after 2 seconds:

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
In his third second, Bomberman sits back and watches all the bombs he planted 3 seconds ago detonate. This is the final state after  seconds:

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO

 */
public class BomberMan {

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        int futureRightBomb = -1;
        HashMap<Integer, Integer> futureBottomBombs = new HashMap<>();
        if (n <= 1)
            return grid;

        if ((n - 1) % 4 == 0)
            n = 3;
        else if ((n - 1) % 2 == 0)
            n = 2;
        else
            n = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid[j].length(); k++) {
                    if (grid[j].charAt(k) == '.') {
                        if (futureRightBomb != -1 || futureBottomBombs.containsKey(j + k)) {
                            if (futureRightBomb == k) {
                                futureRightBomb = -1;
                            } else {
                                if (futureBottomBombs.containsKey(j + k))
                                    futureBottomBombs.remove(j + k);
                                else
                                    grid[j] = replaceChar(grid[j], 'O', k);
                            }
                        } else {
                            grid[j] = replaceChar(grid[j], 'O', k);
                        }

                    } else if (grid[j].charAt(k) == 'O') {
                        grid[j] = replaceChar(grid[j], 'x', k);
                    } else {
                        if (k + 1 < grid[j].length()) {
                            if (grid[j].charAt(k + 1) != 'x') {
                                grid[j] = replaceChar(grid[j], '.', k + 1);
                                futureRightBomb = k + 1;
                                futureBottomBombs.remove(j + futureRightBomb);
                            }
                        }
                        if (j + 1 < grid.length) {
                            if (grid[j + 1].charAt(k) != 'x') {
                                grid[j + 1] = replaceChar(grid[j + 1], '.', k);
                                futureBottomBombs.put(j + 1 + k, k);
                            }
                        }
                        if (j - 1 >= 0) {
                            grid[j - 1] = replaceChar(grid[j - 1], '.', k);
                        }
                        if (k - 1 >= 0) {
                            grid[j] = replaceChar(grid[j], '.', k - 1);
                        }
                        grid[j] = replaceChar(grid[j], '.', k);

                    }
                }
            }

        }

        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[j].length(); k++) {
                if (grid[j].charAt(k) != '.')
                    grid[j] = replaceChar(grid[j], 'O', k);
            }
        }
        return grid;
    }

    public static String replaceChar(String str, char ch, int index) {
        return str.substring(0, index) + ch + str.substring(index + 1);
    }


    public static void main(String[] args) {


        System.out.println(Arrays.toString(bomberMan(3, new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        })));


        System.out.println("\n");


        System.out.println(Arrays.toString(bomberMan(5, new String[]{
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O..."
        })));


    }
}

/*
OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO


 .......
...O.O.
...OO..
..OOOO.
OOOOOOO
OOOOOOO
 */









