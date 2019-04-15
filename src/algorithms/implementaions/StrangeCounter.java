package algorithms.implementaions;

/*
Bob has a strange counter. At the first second, it displays the number . Each second, the number displayed by the counter decrements by  until it reaches .

The counter counts down in cycles. In next second, the timer resets to  and continues counting down. The diagram below shows the counter values for each time  in the first three cycles:

strange(1).png

Find and print the value displayed by the counter at time .

Function Description

Complete the strangeCounter function in the editor below. It should return the integer value displayed by the counter at time .

strangeCounter has the following parameter(s):

t: an integer
Input Format

A single integer denoting the value of .

Constraints

Subtask

 for  of the maximum score.
Output Format

Print the value displayed by the strange counter at the given time .

Sample Input

4
Sample Output

6
Explanation

Time  marks the beginning of the second cycle. It is double the number displayed at the beginning of the first cycle:. This is also shown in the diagram in the Problem Statement above.

 */
public class StrangeCounter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        // https://en.wikipedia.org/wiki/Geometric_progression
        long cycle = Double.valueOf(Math.ceil(Math.log(((double) t + 3) / 3) / Math.log(2))).longValue();
        double p = Math.pow(2, cycle - 1);
        long start = 3 * Double.valueOf(p).longValue();
        long rem = t - (3 * (Double.valueOf(p).longValue() - 1));
        return start - (rem - 1);
    }


    public static void main(String[] args) {

        System.out.println(strangeCounter(19));
        System.out.println(strangeCounter(20));
        System.out.println(strangeCounter(21));
        System.out.println(strangeCounter(4));
        System.out.println(strangeCounter(22));
        System.out.println(strangeCounter(21));
        System.out.println(strangeCounter(7));
        System.out.println(strangeCounter(13));
        System.out.println(strangeCounter(14));
        System.out.println(strangeCounter(4));
        System.out.println(strangeCounter(5));
        System.out.println(strangeCounter(6));
        System.out.println(strangeCounter(3));
        System.out.println(strangeCounter(24));
    }
}
