package algorithms;

/*
Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters. Lisa believes a problem to be special if its index (within a chapter) is the same as the page number where it's located. The format of Lisa's book is as follows:

There are  chapters in Lisa's workbook, numbered from  to .
The  chapter has  problems, numbered from  to .
Each page can hold up to  problems. Only a chapter's last page of exercises may contain fewer than  problems.
Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
The page number indexing starts at .
Given the details for Lisa's workbook, can you count its number of special problems?

For example, Lisa's workbook contains  problems for chapter , and  problems for chapter . Each page can hold  problems. The first page will hold  problems for chapter . Problem  is on page , so it is special. Page contains only Chapter , Problem , so no special problem is on page . Chapter  problems start on page  and there are problems. Since there is no problem  on page , there is no special problem on that page either. There is  special problem in her workbook.

Note: See the diagram in the Explanation section for more details.

Function Description

Complete the workbook function in the editor below. It should return an integer that represents the number of special problems in the workbook.

workbook has the following parameter(s):

n: an integer that denotes the number of chapters
k: an integer that denotes the maximum number of problems per page
arr: an array of integers that denote the number of problems in each chapter
Input Format

The first line contains two integers  and , the number of chapters and the maximum number of problems per page.
The second line contains  space-separated integers  where  denotes the number of problems in the  chapter.

Constraints

Output Format

Print the number of special problems in Lisa's workbook.

Sample Input

5 3
4 2 6 1 10
Sample Output

4
Explanation

The diagram below depicts Lisa's workbook with  chapters and a maximum of  problems per page. Special problems are outlined in red, and page numbers are in yellow squares.

bear_workbook.png

There are  special problems and thus we print the number  on a new line.

 */

public class LisasWorkbook {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int specialProblems = 0;
        int page = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                if (j == page)
                    specialProblems++;
                if (j % k == 0)
                    page++;
            }
           if (arr[i] % k != 0) page++;
        }
        return specialProblems;
    }

    public static void main(String[] args) {
        System.out.println(workbook(5, 3, new int[]{4, 2, 6, 1, 10}));
        System.out.println(workbook(100, 100, new int[]{1, 100, 100, 100, 35, 1, 100, 100, 1, 1, 1, 69, 1, 74, 100,
                100, 100, 100, 100, 100, 1, 100, 100, 72, 100, 100, 12, 56, 100, 1, 30, 1, 62, 1, 1, 100, 100, 1, 100, 100,
                63, 100, 100, 100, 100, 1, 100, 100, 70, 100, 100, 100, 66, 100, 100, 100, 1, 1, 100, 1, 100, 76, 4, 100, 100,
                100, 100, 100, 100, 100, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100, 33, 100, 100, 100, 100, 1, 100, 3,
                100, 100, 100, 100, 100, 100, 18, 12, 100, 100, 100, 100}));
    }
}
