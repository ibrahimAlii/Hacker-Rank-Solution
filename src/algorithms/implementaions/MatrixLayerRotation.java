package algorithms.implementaions;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
You are given a 2D matrix of dimension  and a positive integer . You have to rotate the matrix  times and print the resultant matrix. Rotation should be in anti-clockwise direction.

Rotation of a  matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only.

matrix-rotation

It is guaranteed that the minimum of m and n will be even.

As an example rotate the Start matrix by 2:

Start         First           Second
 1 2 3 4        2  3  4  5      3  4  5  6
12 1 2 5  ->   1  2  3  6 ->   2  3  4  7
11 4 3 6      12  1  4  7       1  2  1  8
10 9 8 7      11 10  9  8     12 11 10  9
Function Description

Complete the matrixRotation function in the editor below. It should print the resultant 2D integer array and return nothing.

matrixRotation has the following parameter(s):

matrix: a 2D array of integers
r: an integer that represents the rotation factor
Input Format

The first line contains three space separated integers, , , and , the number of rows and columns in , and the required rotation.
The next  lines contain  space-separated integers representing the elements of a row of .

Constraints





Output Format

Print each row of the rotated matrix as space-separated integers on separate lines.

Sample Input

Sample Input #01

4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output #01

3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
Explanation #01

The matrix is rotated through two rotations.

 1  2  3  4      2  3  4  8      3  4  8 12
 5  6  7  8      1  7 11 12      2 11 10 16
 9 10 11 12  ->  5  6 10 16  ->  1  7  6 15
13 14 15 16      9 13 14 15      5  9 13 14
Sample Input #02

5 4 7
1 2 3 4
7 8 9 10
13 14 15 16
19 20 21 22
25 26 27 28
Sample Output #02

28 27 26 25
22 9 15 19
16 8 21 13
10 14 20 7
4 3 2 1
Explanation 02

The various states through 7 rotations:

1  2  3  4      2  3  4 10    3  4 10 16    4 10 16 22
7  8  9 10      1  9 15 16    2 15 21 22    3 21 20 28
13 14 15 16 ->  7  8 21 22 -> 1  9 20 28 -> 2 15 14 27 ->
19 20 21 22    13 14 20 28    7  8 14 27    1  9  8 26
25 26 27 28    19 25 26 27    13 19 25 26   7 13 19 25

10 16 22 28    16 22 28 27    22 28 27 26    28 27 26 25
 4 20 14 27    10 14  8 26    16  8  9 25    22  9 15 19
 3 21  8 26 ->  4 20  9 25 -> 10 14 15 19 -> 16  8 21 13
 2 15  9 25     3 21 15 19     4 20 21 13    10 14 20  7
 1  7 13 19     2  1  7 13     3  2  1  7     4  3  2  1
Sample Input #03

2 2 3
1 1
1 1
Sample Output #03

1 1
1 1
Explanation #03

All of the elements are the same, so any rotation will repeat the same matrix.

 */
public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static Point oldPoint = new Point(0, 0);
    static Point newPoint = new Point(0, 0);
    static List<List<Integer>> newList = new ArrayList<>();

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int rowLength = matrix.size();
        int columnLength = matrix.get(0).size();
        int loopCount;

        int totalCircle = (rowLength + columnLength - 2) * 2;
        if (r == totalCircle)
            loopCount = 0;
        else if (r > totalCircle) {
            loopCount = (r % totalCircle);
        } else {
            loopCount = r;
        }

        int minimum = 0;
        // set start index
        for (int i = 0; i < loopCount; i++) {
            oldPoint = getRowColumn(oldPoint.x, oldPoint.y, columnLength, rowLength, 0);
        }


        int rows = matrix.size();
        int columns = matrix.get(0).size();

        while (rows > 0){
            for (int j = 0; j < (rows * columns); j++) {
                newList.get(newPoint.x).set(newPoint.y, matrix.get(oldPoint.x).get(oldPoint.y));
                oldPoint = getRowColumn(oldPoint.x, oldPoint.y, columnLength, rowLength, minimum);
                newPoint = getRowColumn(newPoint.x, newPoint.y, columnLength, rowLength, minimum);
            }

            rowLength--;
            columnLength--;
            minimum++;
            oldPoint.setLocation(minimum, minimum);
            newPoint.setLocation(minimum, minimum);
            rows -= 2;
            columns -= 2;

            if (r > totalCircle) {
                totalCircle = (rows + columns - 2) * 2;
                if (totalCircle != 0)
                    loopCount = (r % totalCircle);
            }

            for (int j = 0; j < loopCount; j++) {
                oldPoint = getRowColumn(oldPoint.x, oldPoint.y, columnLength, rowLength, minimum);
            }
        }

//        for (List<Integer> integers : newList) {
//            for (Integer integer : integers) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point getRowColumn(int row, int column, int columnLength, int rowLength, int minimum) {
        if (row == minimum && column < columnLength - 1) {
            column++;
        } else if (column == columnLength - 1 && row < rowLength - 1) {
            row++;
        } else if (row == rowLength - 1 && column > minimum) {
            column--;
        } else if (column == minimum && row > minimum) {
            row--;
        }
        return new Point(row, column);
    }

    public static void main(String[] args) {
//        List<List<Integer>> list = new ArrayList<>();
////
////
//        list.add(new ArrayList<>(List.of(9718805, 60013003, 5103628, 85388216, 21884498, 38021292, 73470430, 31785927)));
//        list.add(new ArrayList<>(List.of(69999937, 71783860, 10329789, 96382322, 71055337, 30247265, 96087879, 93754371)));
//        list.add(new ArrayList<>(List.of(79943507, 75398396, 38446081, 34699742, 1408833, 51189, 17741775, 53195748)));
//        list.add(new ArrayList<>(List.of(79354991, 26629304, 86523163, 67042516, 54688734, 54630910, 6967117, 90198864)));
//        list.add(new ArrayList<>(List.of(84146680, 27762534, 6331115, 5932542, 29446517, 15654690, 92837327, 91644840)));
//        list.add(new ArrayList<>(List.of(58623600, 69622764, 2218936, 58592832, 49558405, 17112485, 38615864, 32720798)));
//        list.add(new ArrayList<>(List.of(49469904, 5270000, 32589026, 56425665, 23544383, 90502426, 63729346, 35319547)));
//        list.add(new ArrayList<>(List.of(20888810, 97945481, 85669747, 88915819, 96642353, 42430633, 47265349, 89653362)));
//        list.add(new ArrayList<>(List.of(55349226, 10844931, 25289229, 90786953, 22590518, 54702481, 71197978, 50410021)));
//        list.add(new ArrayList<>(List.of(9392211, 31297360, 27353496, 56239301, 7071172, 61983443, 86544343, 43779176)));
//
//
//        for (int i = 0; i < 4; i++) {
//
//            System.out.println(list.get(i));
//
//        }
//        System.out.println(40 % 24);
//        System.out.println(list.get(0).size() / 2);
//        matrixRotation(list, 40);

        BufferedReader br_case = null;
        BufferedReader br_result = null;
        try {
            br_case = new BufferedReader(new FileReader(new File("C:\\Users\\Ibrahim\\Desktop\\projects\\Hacker-Rank-Solution\\src\\algorithms\\test_case_for_matrix_rotation.txt")));
            br_result = new BufferedReader(new FileReader("C:\\Users\\Ibrahim\\Desktop\\projects\\Hacker-Rank-Solution\\src\\algorithms\\result_for_matrix_rotation.txt"));

            List<List<Integer>> matrix = new ArrayList<>();

            BufferedReader finalBr_case = br_case;
            String[] mnr = br_case.readLine().replaceAll("\\s+$", "").split(" ");

            int m = Integer.parseInt(mnr[0]);

            int n = Integer.parseInt(mnr[1]);

            int r = Integer.parseInt(mnr[2]);

            IntStream.range(0, m).forEach(i -> {
                try {
                    matrix.add(
                            Stream.of(finalBr_case.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                    newList.add(new ArrayList<>(matrix.get(i)));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            matrixRotation(matrix, r);

            matrix.clear();
            System.out.println("matrix: " + matrix);
            BufferedReader finalBr_result = br_result;
            IntStream.range(0, m).forEach(i -> {
                try {
                    matrix.add(
                            Stream.of(finalBr_result.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            for (int j = 0; j < matrix.size(); j++) {
                for (int k = 0; k < matrix.get(j).size(); k++) {
                    if (matrix.get(j).get(k).equals(newList.get(j).get(k)))
                        System.out.print("true" + " ");
                    else System.out.print(matrix.get(j).get(k) + " " + newList.get(j).get(k) + " ");
                }
                System.out.println();
            }


            br_case.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//         93754371 53195748 90198864 91644840 32720798 35319547 89653362 50410021
//        31785927 25289229 10844931 97945481 5270000 69622764 27762534 43779176
//        73470430 90786953 42430633 96642353 88915819 85669747 26629304 86544343
//        38021292 22590518 90502426 67042516 54688734 32589026 75398396 61983443
//        21884498 54702481 17112485 5932542 29446517 2218936 71783860 7071172
//        85388216 71197978 15654690 58592832 49558405 6331115 10329789 56239301
//        5103628 47265349 54630910 56425665 23544383 86523163 96382322 27353496
//        60013003 63729346 51189 1408833 34699742 38446081 71055337 31297360
//        9718805 38615864 92837327 6967117 17741775 96087879 30247265 9392211
//        69999937 79943507 79354991 84146680 58623600 49469904 20888810 55349226












