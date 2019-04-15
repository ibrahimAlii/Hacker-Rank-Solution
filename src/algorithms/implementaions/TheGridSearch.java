package algorithms.implementaions;

/*
Given a 2D array of digits or grid, try to find the occurrence of a given 2D pattern of digits. For example, consider the following grid:

1234567890
0987654321
1111111111
1111111111
2222222222
Assume we need to look for the following 2D pattern array:

876543
111111
111111
The 2D pattern begins at the second row and the third column of the grid. The pattern is said to be present in the grid.

Function Description

Complete the gridSearch function in the editor below. It should return YES if the pattern exists in the grid, or NO otherwise.

gridSearch has the following parameter(s):

G: the grid to search, an array of strings
P: the pattern to search for, an array of strings
Input Format

The first line contains an integer , the number of test cases.

Each of the  test cases is represented as follows:
The first line contains two space-separated integers  and , indicating the number of rows and columns in the grid .
This is followed by  lines, each with a string of  digits representing the grid .
The following line contains two space-separated integers,  and , indicating the number of rows and columns in the pattern grid .
This is followed by  lines, each with a string of  digits representing the pattern .

Constraints





Output Format

Display YES or NO, depending on whether  is present in .

Sample Input

2
10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
15 15
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
2 2
99
99
Sample Output

YES
NO
Explanation

The first test in the input file is:

10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
As one may see, the given pattern is present in the larger grid, as marked in bold below.

7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
The second test in the input file is:

15 15
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
2 2
99
99
The search pattern is:

99
99
This cannot be found in the larger grid.

 */
public class TheGridSearch {

    // Complete the gridSearch function below.
//    static String gridSearch(String[] g, String[] p) {
//        int index = 0;
//        for (int i = 0; i < g.length; i++) {
//            if (g[i].contains(p[index]))
//                index++;
//            else {
//                if (index - 1 >= 0) {
//                    if (!g[i].contains(p[index - 1]))
//                        index = 0;
//                }else index = 0;
//            }
//
//
//            if (index == p.length)
//                return "YES";
//        }
//        return "NO";
//    }

    static String gridSearch(String[] G, String[] P) {
        int R = 0;
        int C = 0;
        int Rlength = G.length;
        int Plength = P.length;
        int r = 0;
        while (R < Rlength && Rlength - R >= P.length) {
            while (C < G[0].length()) {
                String substr = G[R].substring(C, C + P[r].length());
                if (substr.equals(P[r])) {
                    int count = 1;
                    r++;
                    while (r < Plength) {
                        String innersubstr = G[R + r].substring(C, C + P[r].length());
                        if (innersubstr.equals(P[r])) {
                            count++;
                        } else {
                            r = 0;
                            count = 0;
                            break;
                        }
                        r++;

                    }
                    if (count == P.length) {
                        return "YES";
                    }
                } else {
                    r = 0;
                }
                C++;
                if (C > G[0].length() - P[0].length()) {
                    R++;
                    C = 0;
                    break;
                }


            }

        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(gridSearch(new String[]{"7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374",
                "6473530293", "7053106601", "0834282956", "4607924137"}, new String[]{"9505", "3845", "3530"}));

        System.out.println(gridSearch(new String[]{"123412", "561212", "123634", "781288"}, new String[]{"12", "34"}));

        System.out.println(gridSearch(new String[]{"1234", "4321", "9999", "9999"}, new String[]{"12", "21"}));

        System.out.println(gridSearch(new String[]{"111111111111111", "111111111111111", "111111111111111", "111111111111111", "111111111111110"},
                new String[]{"11111", "11111", "11110"}));
    }


}
