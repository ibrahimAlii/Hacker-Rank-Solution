import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            } else if (arr[i] > arr1[i]) {
                data = arr1[i] + arr1[i] - 1;
            }

            if (data > max)
                max = data;
        }
        return max;
    }

    private static char[] preProcess(String str) {
        int len = str.length();
        if (len == 0)
            return new char[]{'^', '$'};
        char[] processedArr = new char[(len * 2) + 3];
        int index = 0;
        processedArr[index++] = '^';
        for (int i = 0; i < len; i++) {
            processedArr[index++] = '#';
            processedArr[index++] = str.charAt(i);
        }

        processedArr[index++] = '#';
        processedArr[index] = '$';
        return processedArr;
    }


    private static String getLongestPalindrome(String str) {
        char[] s = preProcess(str);
        int N = s.length;
        int[] tempAr = new int[N + 1];
        int id = 0, max = 0;
        for (int i = 1; i < N - 1; i++) {
            tempAr[i] = max > i ? Math.min(tempAr[2 * id - i], max - i) : 0;
            while (s[i + 1 + tempAr[i]] == s[i - 1 - tempAr[i]])
                tempAr[i]++;
            if (i + tempAr[i] > max) {
                max = i + tempAr[i];
                id = i;
            }
        }
        /** length of largest palindrome **/
        int maxLen = 0;
        /** position of center of largest palindrome **/
        int centerIndex = 0;
        for (int i = 1; i < N - 1; i++) {
            if (tempAr[i] > maxLen) {
                maxLen = tempAr[i];
                centerIndex = i;
            }
        }
        /** starting index of palindrome **/
        int pos = (centerIndex - 1 - maxLen) / 2;
        return str.substring(pos, pos + maxLen);
    }

    public static int tribonacci(int n) {
        int result = 0;
        int temp0 = 0;
        int temp1 = 1;
        int temp2 = 1;

        for (int i = 1; i < n; i++) {
            result = i + temp1 + temp2;
            temp1 = i;
            temp2 = result;

        }

        return result;
    }

    public static String alphabetBoardPath(String target) {
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        StringBuilder result = new StringBuilder();

        int currentY = 0;
        int currentX = 0;

        for (int i = 0; i < target.length(); i++) {
            char q = target.charAt(i);

            if (q >= 'a' && q <= 'e') {
                while (currentY != 0) {
                    currentY--;
                    result.append("U");
                }
                while (board[currentY].charAt(currentX) != q) {
                    if (board[currentY].charAt(currentX) > q) {
                        currentX--;
                        result.append("L");
                    } else {
                        currentX++;
                        result.append("R");
                    }
                }
            } else if (q >= 'f' && q <= 'j') {
                while (currentY != 1) {
                    if (currentY > 1) {
                        currentY--;
                        result.append("U");
                    } else {
                        currentY++;
                        result.append("D");
                    }

                }
                while (board[currentY].charAt(currentX) != q) {
                    if (board[currentY].charAt(currentX) > q) {
                        currentX--;
                        result.append("L");
                    } else {
                        currentX++;
                        result.append("R");
                    }
                }
            } else if (q >= 'k' && q <= 'o') {
                while (currentY != 2) {
                    if (currentY > 2) {
                        currentY--;
                        result.append("U");
                    } else {
                        currentY++;
                        result.append("D");
                    }

                }
                while (board[currentY].charAt(currentX) != q) {
                    if (board[currentY].charAt(currentX) > q) {
                        currentX--;
                        result.append("L");
                    } else {
                        currentX++;
                        result.append("R");
                    }
                }

            } else if (q >= 'p' && q <= 't') {
                while (currentY != 3) {
                    if (currentY > 3) {
                        currentY--;
                        result.append("U");
                    } else {
                        currentY++;
                        result.append("D");
                    }

                }
                while (board[currentY].charAt(currentX) != q) {
                    if (board[currentY].charAt(currentX) > q) {
                        currentX--;
                        result.append("L");
                    } else {
                        currentX++;
                        result.append("R");
                    }
                }

            } else if (q >= 'u' && q <= 'y') {
                while (currentY != 4) {
                    if (currentY > 4) {
                        currentY--;
                        result.append("U");
                    } else {
                        currentY++;
                        result.append("D");
                    }

                }
                while (board[currentY].charAt(currentX) != q) {
                    if (board[currentY].charAt(currentX) > q) {
                        currentX--;
                        result.append("L");
                    } else {
                        currentX++;
                        result.append("R");
                    }
                }

            } else {
                while (currentY != 4) {
                    if (currentY > 4) {
                        currentY--;
                        result.append("U");
                    } else {
                        currentY++;
                        result.append("D");
                    }

                }

                while (currentX != 0){
                    currentX--;
                    result.append("L");
                }
                currentY--;
                result.append("D");
            }
            result.append("!");

        }

        return result.toString();
    }

    public static String[] getAnagrams(String[] str){
        ArrayList<char[]> group = new ArrayList<char[]>();
        ArrayList<ArrayList<String>> originalList = new ArrayList<ArrayList<String>>();
        String[] tempstr = str.clone(); //clone could do deep copy, and avoid to change str.

        //Category group for str.
        outerLoop:
        for(int pos=0; pos<tempstr.length; pos++){
            tempstr[pos]= tempstr[pos].trim().replaceAll(" ", "");
            char[] c = new char[tempstr[pos].length()];
            tempstr[pos].getChars(0,tempstr[pos].length(),c,0); //last character is at index srcEnd-1
            Arrays.sort(c);//ignore character's order in string.
            ArrayList<String> sArrList = new ArrayList<String>();

            for (char[] comparedChars : group) {
                if (Arrays.equals(comparedChars, c)) {//only compare character in same index.
                    sArrList = originalList.get(group.indexOf(comparedChars));
                    sArrList.add(str[pos]);
                    continue outerLoop;
                }
            }
            // can not find group
            sArrList.add(str[pos]);
            originalList.add(sArrList);
            group.add(c);
        }

        //Following begin to do sorting.
        String[] groupStr = new String[group.size()];
        Iterator<ArrayList<String>> it2 = originalList.iterator();
        for(int groupId=0 ; groupId<group.size() && it2.hasNext(); groupId++){
            ArrayList<String> temp = it2.next();
            Collections.sort(temp); // let string in each single row sort by alphabet.
            for (String ss : temp) {
                if (groupStr[groupId] == null || groupStr[groupId].length() == 0) groupStr[groupId] = ss;
                else groupStr[groupId] += "," + ss;
            }
        }

        Arrays.sort(groupStr);// let group sort by alphabet.
        return groupStr;
    }



    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);



    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
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

