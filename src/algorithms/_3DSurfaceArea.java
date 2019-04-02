package algorithms;

/*
Madison, is a little girl who is fond of toys. Her friend Mason works in a toy manufacturing factory . Mason has a 2D board  of size  with  rows and  columns. The board is divided into cells of size  with each cell indicated by it's coordinate . The cell  has an integer  written on it. To create the toy Mason stacks  number of cubes of size  on the cell .

Given the description of the board showing the values of  and that the price of the toy is equal to the 3d surface area find the price of the toy.

image

Input Format

The first line contains two space-separated integers  and  the height and the width of the board respectively.

The next  lines contains  space separated integers. The  integer in  line denotes .

Constraints

Output Format

Print the required answer, i.e the price of the toy, in one line.

Sample Input 0

1 1
1
Sample Output 0

6
Explanation 0

image The surface area of  cube is 6.

Sample Input 1

3 3
1 3 4
2 2 3
1 2 4
Sample Output 1

60
Explanation 1

The sample input corresponds to the figure described in problem statement.

 */

public class _3DSurfaceArea {

    static int surfaceArea(int[][] A) {
        int tvolume = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                tvolume += (A[i][j] * 4) + 2;
                if (j >= 1)
                    tvolume -= Math.min(A[i][j - 1], A[i][j]) * 2;
                if (i >= 1)
                    tvolume -= Math.min(A[i - 1][j], A[i][j]) * 2;
            }
        }
        return tvolume;
    }


    public static void main(String[] args) {

        System.out.println(surfaceArea(new int[][]{
                {1, 3, 4},
                {2, 2, 3},
                {1, 2, 4}
        }));
    }

}

