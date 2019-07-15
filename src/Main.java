import java.util.*;
import java.util.stream.Stream;

class Main {

    /*
    We are trying to find out how we can best organize our engineering teams. For this, we want to make sure we consider all
    options, and thus we want to create a list of all possible teams.   You will assume that we have at most 26 engineers,
    and that each engineer is given a unique lowercase character as a personal identifier, from 'a' to 'z'.
     You will read the input on STDIN (Standard Input), which will be a single line that contains a string formed of the identifiers
      of engineers we want to create teams with. You will write to STDOUT (Standard Output) the list of all the possible teams you
      can create with those engineers.   You will notice in the examples below that the output is sorted in ascending lexicographical order.
      Shorter strings come before longer strings, and 'a' < 'b' < ... < 'z'.
       The output strings should also be ordered lexicographically to ensure that the teams are unique, i.e. 'cba' should be printed as 'abc'.
            Example #1:   Only two engineers. In that case there are only two possibilities: either we have two teams of one engineer each, or we have a single team with two engineer.
             Sample input: ab
     Sample output: a b ab   Example #2:   This time with three engineers. Therefore we can have teams of one, two or three engineers.
      Sample input: abc   Sample output: a b c ab ac bc abc
     */


    public static int longestWPI(int[] hours) {
        int max = 0;
        int tiringDays = 0;
        int maxTiringDays = 0;
        int normalDays = 0;
        int maxNormalDays = 0;
        int index = 0;
        int[] arr = new int[hours.length];
        int[] arr1 = new int[hours.length];


        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                tiringDays++;
                if (tiringDays > maxTiringDays)
                    maxTiringDays = tiringDays;
            } else if (hours[i] > 0) {
                normalDays++;
                if (normalDays > maxNormalDays)
                    maxNormalDays = normalDays;
            } else {
                index++;
                normalDays = 0;
                maxNormalDays = 0;
                maxTiringDays = 0;
                tiringDays = 0;
            }

            arr[index] = maxNormalDays;
            arr1[index] = maxTiringDays;

        }

        for (int i = 0; i < arr.length; i++) {
            int data = 0;
            if (arr1[i] > arr[i]) {
                data = arr[i] + arr1[i];
            } else if (arr[i] > arr1[i]){
                data = arr1[i] + arr1[i] - 1;
            }

            if (data > max)
                max = data;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(longestWPI(new int[]{6, 6, 6}));
        System.out.println(longestWPI(new int[]{6, 9, 6}));
        System.out.println(longestWPI(new int[]{6, 9, 9}));
        System.out.println(longestWPI(new int[]{10,7,8,7,10}));
    }

    //Sample input: abc
    // Sample output:
    // a
    // b
    // c
    // ab
    // ac
    // bc
    // abc
}

