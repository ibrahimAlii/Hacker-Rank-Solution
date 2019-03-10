package algorithms;

/*
The population of HackerWorld is . Initially, none of the people are friends with each other. In order to start a friendship, two persons  and  have to shake hands, where . The friendship relation is transitive, that is if  and  shake hands with each other,  and friends of  become friends with  and friends of .

You will be given  queries. After each query, you need to report the size of the largest friend circle (the largest group of friends) formed after considering that query.

For example, your list of queries is:

1 2
3 4
2 3
First,  and  shake hands, forming a circle of . Next,  and  do the same. Now there are two groups of  friends. When  and  become friends in the next query, both groups of friends are added together to make a circle of  friends. We would print

2
2
4
Function Description

Complete the function maxCircle in the editor below. It must return an array of integers representing the size of the maximum circle of friends after each query.

maxCircle has the following parameter(s):

queries: an array of integer arrays, each with two elements indicating a new friendship
Input Format

The first line contains an integer, , the number of queries to process.
Each of the next  lines consists of two space-separated integers denoting the 2-D array .

Constraints

 for
Output Format

Return an integer array of size , whose value at index  is the size of largest group present after processing the  query.

Sample Input 0

2
1 2
1 3
Sample Output 0

2
3
Explanation 0

In the first query,  and  shake hands. So, the size of largest group of friends is  (as no other friendships exist).
After the second query, ,  and  all become friends, as  shakes hand with ,  also become friends with  as he was already a friend of .

Sample Input 1

4
1000000000 23
11 3778
7 47
11 1000000000
Sample Output 1

2
2
2
4
Explanation 1

After first query, person  and person  become friends. So, the largest group size is .
After the second query, person  and person  become friends. So, the largest group size is still .
After the third query, person  and person  become friends. Answer is still .
After the last query, person  and person  become friends, which means , ,  and  all become friends. Hence, the answer now increased to .

Sample Input 2

6
1 2
3 4
1 3
5 7
5 6
7 4
Sample Output 2

2
2
4
4
4
7
Explanation 2

Friend circles after each iteration:

1   [1,2]
2   [1,2],[3,4]
3   [1,2,3,4]
4   [1,2,3,4],[5,7]
5   [1,2,3,4],[5,7,6]
6   [1,2,3,4,5,6,7]
 */

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.IntStream;

public class FriendCircleQueries {

    // Complete the maxCircle function below.
    static int[] maxCircle(int[][] queries) {
        HashMap<Integer, LinkedHashSet<Integer>> map = new HashMap<>();
        int[] result = new int[queries.length];
        int lastMax = 0;
        for (int i = 0; i < queries.length; i++) {
            int currentKey1 = queries[i][0];
            int currentKey2 = queries[i][1];
            map.put(currentKey1, map.get(currentKey1) == null ? new LinkedHashSet<>() : map.get(currentKey1));
            map.put(currentKey2, map.get(currentKey2) == null ? new LinkedHashSet<>() : map.get(currentKey2));
            if (!map.get(currentKey1).contains(currentKey2))
                map.get(currentKey1).add(currentKey2);

            if (!map.get(currentKey2).contains(currentKey1))
                map.get(currentKey2).add(currentKey1);




            if (currentKey1 == currentKey2)
                continue;
            LinkedHashSet<Integer> mainList1 = map.get(currentKey1);
            checkForFriendFriends(map, mainList1, currentKey1);


            if (mainList1.size() + 1 > lastMax){
                lastMax = mainList1.size() + 1;
                result[i] = lastMax;
            }else {
                result[i] = lastMax;
            }

        }

        return result;
    }

    private static void checkForFriendFriends(HashMap<Integer, LinkedHashSet<Integer>> map, LinkedHashSet<Integer> mainList, int currentKey) {
        // TODO: 10/03/2019 Improve this
        for (Integer friend : mainList) {
            LinkedHashSet<Integer> list2 = map.get(friend) == null ? new LinkedHashSet<>() : map.get(friend);
            for (Integer subFriend : list2) {
                if (!mainList.contains(subFriend) && subFriend != currentKey)
                    mainList.add(subFriend);
            }
        }
    }



    public static void main(String[] args) {

        int[][] arr = new int[(int) Math.pow(10, 4)][(int) Math.pow(10, 4)];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = random.nextInt((int) Math.pow(5, 9) + 100);
            arr[i][1] = random.nextInt((int) Math.pow(5, 9) + 100);
        }

        System.out.println(Arrays.toString(maxCircle(new int[][]{
                {1, 2},
                {3, 4},
                {1, 3},
                {5, 7},
                {5, 6},
                {7, 4}
        })));

        System.out.println(Arrays.toString(maxCircle(arr)));
        System.out.println(Arrays.toString(maxCircle(new int[][]{{1, 2}, {1, 3}})));
        System.out.println(Arrays.toString(maxCircle(new int[][]{
                {1000000000, 23},
                {11, 3778},
                {7, 47},
                {11, 1000000000}
        })));


    }
}
