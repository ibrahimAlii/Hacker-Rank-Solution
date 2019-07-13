package datastructure.queue;

/*
Suppose there is a circle. There are  petrol pumps on that circle. Petrol pumps are numbered  to  (both inclusive). You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.

Input Format

The first line will contain the value of .
The next  lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol pump and the next petrol pump.

Constraints:


Output Format

An integer which will be the smallest index of the petrol pump from which we can start the tour.

Sample Input

3
1 5
10 3
3 4
Sample Output

1
Explanation

We can start the tour from the second petrol pump.
 */
public class TruckTour {

    static int truckTour(int[][] petrolpumps) {
       int index = 0;
       int totalAmount = 0;

        for (int i = 0; i < petrolpumps.length; i++) {
            totalAmount += petrolpumps[i][0];
            if (totalAmount - petrolpumps[i][1] <= 0){
                i = index++;
                totalAmount = 0;
                continue;
            }
            totalAmount -= petrolpumps[i][1];
        }

        return index;
    }

    public static void main(String[] args){
        System.out.println(truckTour(new int[][]{{1, 5}, {10, 3}, {3, 4}}));
    }
}
