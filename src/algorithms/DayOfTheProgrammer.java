package algorithms;

/*
Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the day of the year) during a year in the inclusive range from  to .

From  to , Russia's official calendar was the Julian calendar; since  they used the Gregorian calendar system. The transition from the Julian to Gregorian calendar system occurred in , when the next day after January  was February . This means that in , February  was the  day of the year in Russia.

In both calendar systems, February is the only month with a variable amount of days; it has  days during a leap year, and days during all other years. In the Julian calendar, leap years are divisible by ; in the Gregorian calendar, leap years are either of the following:

Divisible by .
Divisible by  and not divisible by .
Given a year, , find the date of the  day of that year according to the official Russian calendar during that year. Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .

For example, the given .  is divisible by , so it is a leap year. The  day of a leap year after  is September 12, so the answer is .

Function Description

Complete the dayOfProgrammer function in the editor below. It should return a string representing the date of the  day of the year given.

dayOfProgrammer has the following parameter(s):

year: an integer
Input Format

A single integer denoting year .

Constraints

Output Format

Print the full date of Day of the Programmer during year  in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is .

Sample Input 0

2017
Sample Output 0

13.09.2017
Explanation 0

In the year , January has  days, February has  days, March has  days, April has  days, May has  days, June has  days, July has  days, and August has  days. When we sum the total number of days in the first eight months, we get . Day of the Programmer is the  day, so then calculate  to determine that it falls on day  of the  month (September). We then print the full date in the specified format, which is 13.09.2017.

Sample Input 1

2016
Sample Output 1

12.09.2016
Explanation 1

Year  is a leap year, so February has  days but all the other months have the same number of days as in . When we sum the total number of days in the first eight months, we get . Day of the Programmer is the  day, so then calculate  to determine that it falls on day  of the month (September). We then print the full date in the specified format, which is 12.09.2016.

Sample Input 2

1800
Sample Output 2

12.09.1800
Explanation 2

Since 1800 is leap year. Day lies on 12 September.

 */
public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        boolean isLeapYear = false;

        if (year == 1918)
            return "26.09." + year;

        // mean it's the julian calendar
        if (year < 1919)
            isLeapYear = isJulianLeapYear(year);


        if (!isLeapYear)
            isLeapYear = isGregorianLeapYear(year);


        if (isLeapYear)
            return "12.09." + year;
        else return "13.09." + year;
    }

    private static boolean isGregorianLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    private static boolean isJulianLeapYear(int year) {
        return (year % 4 == 0);
    }

    public static void main(String[] args) {

        System.out.println(dayOfProgrammer(1800));
    }
}
